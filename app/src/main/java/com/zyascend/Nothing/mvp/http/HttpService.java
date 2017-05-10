package com.zyascend.Nothing.mvp.http;

import android.support.design.widget.BaseTransientBottomBar;
import android.text.TextUtils;

import com.zyascend.Nothing.bean.BaseResponse;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.bean.SimpleListResponse;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.common.rx.LifeCycleEvent;
import com.zyascend.Nothing.common.rx.RxTransformer;

import java.util.List;

import rx.Observable;

import rx.Subscriber;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * 功能：与Presenter直接交互，封装所有http请求
 * 作者：zyascend on 2017/5/3 14:47
 * 邮箱：zyascend@qq.com
 */

public class HttpService {

    private static final String TAG = "TAG_HttpService";
    private static final String STATUS_OK = "1";
    private static HttpService SERVICE;
    private HttpService(){}
    private String accessToken = "";

    public static HttpService getInstance(){
        if (SERVICE == null){
            synchronized (HttpService.class){
                if (SERVICE == null){
                    return new HttpService();
                }
            }
        }
        return SERVICE;
    }

    public void getNotice(PublishSubject<LifeCycleEvent> subject, final BaseDataCallback<Notice> callback){
        RetrofitService.getDefault()
                .registerPushToken(RequestHelper.getAccessToken(),RequestHelper.getRegisterBody())
                //处理嵌套请求 先注册pushToken 再请求数据
                .flatMap(new Func1<BaseResponse, Observable<SimpleListResponse<Notice>>>() {
                    @Override
                    public Observable<SimpleListResponse<Notice>> call(BaseResponse response) {
                        if (!TextUtils.equals(response.getSTATUS(),STATUS_OK))
                            return Observable.error(new APIException(response.getMESSAGE()));
                        return RetrofitService.getDefault()
                                .getNotice(RequestHelper.getAccessToken(),RequestHelper.getNoticeBody());
                    }
                })
                //生命周期控制，线程切换
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<Notice>>transform(subject))
                //数据预处理
                .map(new Func1<SimpleListResponse<Notice>, Notice>() {
                    @Override
                    public Notice call(SimpleListResponse<Notice> response) {
                        Notice msgNum = null;
                        if (response!=null && response.getDATA()!=null
                                && response.getDATA().getList()!=null){
                            msgNum = response.getDATA().getList().get(2);
                        }
                        return msgNum;
                    }
                })
                .subscribe(new Subscriber<Notice>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.toString());
                    }

                    @Override
                    public void onNext(Notice notice) {
                        callback.onSuccess(notice);
                    }
                });

    }

    public void getMyTagList(PublishSubject<LifeCycleEvent> subject, final BaseDataCallback<List<HomeTag>> callback){

        RetrofitService.getDefault()
                .getMyTagList(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<HomeTag>>transform(subject))
                .map(new Func1<SimpleListResponse<HomeTag>, List<HomeTag>>() {
                    @Override
                    public List<HomeTag> call(SimpleListResponse<HomeTag> response) {
                        return response.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<HomeTag>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<HomeTag> tagList) {
                        callback.onSuccess(tagList);
                    }
                });
    }


    public void getAllTagList(PublishSubject<LifeCycleEvent> subject, final BaseDataCallback<List<HomeTag>> callback){
        // TODO: 2017/5/10 还需处理缓存
        RetrofitService.getDefault()
                .getAllTagList(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<HomeTag>>transform(subject))
                .map(new Func1<SimpleListResponse<HomeTag>, List<HomeTag>>() {
                    @Override
                    public List<HomeTag> call(SimpleListResponse<HomeTag> response) {
                        return response.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<HomeTag>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<HomeTag> tagList) {
                        callback.onSuccess(tagList);
                    }
                });
    }







}
