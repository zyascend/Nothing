package com.zyascend.Nothing.common.rx;

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.bean.BaseResponse;
import com.zyascend.Nothing.common.rx.LifeCycleEvent;
import com.zyascend.Nothing.mvp.data.CacheManager;
import com.zyascend.Nothing.mvp.http.APIException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 *
 * Created by Administrator on 2016/11/22.
 */

public enum RxTransformer {

        INSTANCE;

    private static final CharSequence STATUS_OK = "1";
    private static final String TAG = "TAG_Compose";

    public <T extends BaseResponse> Observable.Transformer<T,T> transform(final PublishSubject<LifeCycleEvent> lifecycleSubject,final String cacheType){

        return new Observable.Transformer<T, T>(){
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                Observable<LifeCycleEvent> lifeObservable
                        = lifecycleSubject.takeFirst(new Func1<LifeCycleEvent, Boolean>() {
                    @Override
                    public Boolean call(LifeCycleEvent lifeCycleEvent) {

                        //若PublishSubject发送的事件与DESTROY/STOP/PAUSE一致时
                        //这个lifeObservable就对外发射数据

                        return LifeCycleEvent.DESTROY.equals(lifeCycleEvent)
                                || LifeCycleEvent.STOP.equals(lifeCycleEvent)
                                || LifeCycleEvent.PAUSE.equals(lifeCycleEvent);
                    }
                });
                return tObservable
                        //判断返回的数据是否出错
                        .flatMap(new Func1<T, Observable<T>>() {
                            @Override
                            public Observable<T> call(T t) {
                                if (!TextUtils.equals(t.getSTATUS(),STATUS_OK))
                                    return Observable.error(new APIException(t.getMESSAGE()));
                                return createData(t);
                            }
                        })
                        //从网络返回的数据，存入缓存
                        .map(new Func1<T, T>() {
                            @Override
                            public T call(T t) {
                                //当cacheType为空（null）时，说明不用缓存
                                if (!TextUtils.isEmpty(cacheType)){
                                    CacheManager.getInstance().saveCache(cacheType,t);
                                    Logger.d("从网络获取到"+cacheType+"数据，尝试存入缓存,当前线程---》");
                                }
                                return t;
                            }
                        })
                        //一旦lifecycleObservable对外发射了数据，
                        //就自动把当前的Observable(也就是网络请求的Observable)停掉
                        .takeUntil(lifeObservable)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        //默认情况下，doOnSubscribe()执行在 subscribe()发生的线程
                        //doOnSubscribe()之后有 subscribeOn()的话，它将执行在离它最近的subscribeOn()所指定的线程
                        //使其始终运行在主线程
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };

    }

    /**
     * 数据没问题，重新发射
     * @param data
     * @param <T>
     * @return
     */
    private <T extends BaseResponse> Observable<T> createData(final T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
