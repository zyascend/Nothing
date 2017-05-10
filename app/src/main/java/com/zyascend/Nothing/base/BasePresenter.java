package com.zyascend.Nothing.base;

import com.zyascend.Nothing.common.rx.LifeCycleEvent;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import rx.subjects.PublishSubject;

/**
 * Presenter基类
 * 对View(MVP)进行绑定，解绑
 * Created by zyascend on 2017/4/22.
 */

public abstract class BasePresenter<T extends BaseView> {

    protected Reference<T> mViewRef;
    protected PublishSubject<LifeCycleEvent> lifeCycleSubject = PublishSubject.create();

    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    public void detachView(){
        lifeCycleSubject.onNext(LifeCycleEvent.DESTROY);
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public boolean isViewAttached(){
        return mViewRef!=null && mViewRef.get()!=null;
    }

    public T getView(){
        return mViewRef == null ? null : mViewRef.get();
    }

    public void onStop() {
        lifeCycleSubject.onNext(LifeCycleEvent.STOP);
    }

    public void onPause() {
        lifeCycleSubject.onNext(LifeCycleEvent.PAUSE);
    }

    public void onResume() {
        lifeCycleSubject.onNext(LifeCycleEvent.RESUME);
    }
}
