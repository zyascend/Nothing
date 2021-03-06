package com.zyascend.Nothing.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.common.rx.LifeCycleEvent;

import butterknife.ButterKnife;
import rx.subjects.PublishSubject;

/**
 * 基类Fragment
 * Created by zyascend on 2017/4/22.
 */

public abstract class BaseFragment extends Fragment {

    protected final String TAG = this.getClass().getSimpleName();
    private static final String STATE_SAVE_IS_HIDDEN = "hidden";

    public final PublishSubject<LifeCycleEvent> lifeCycleSubject = PublishSubject.create();

    protected boolean isInitView = false;
    protected boolean isLoad = false;
    protected View rootView;
    protected boolean isVisible;
    protected Activity mActivity;
    protected boolean isFirstLoad = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        lifeCycleSubject.onNext(LifeCycleEvent.CREATE);
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //防止getActivity()返回null
        this.mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            int layoutId = getLayoutId();
            Log.d(TAG, "onCreateView: ");
            rootView = inflater.inflate(layoutId, container, false);
            ButterKnife.bind(this, rootView);
            initViews();
        }
        ButterKnife.bind(this,rootView);
        isInitView = true;
        lazyLoad();
        afterLazyLoad();
        return rootView;
    }

    public void afterLazyLoad() {

    }


    private void lazyLoad() {
        if (isLazyLoad()){
            //Logger.d("lazyLoad: "+isFirstLoad+"/"+isVisible+"/"+isInitView);
            if(!isFirstLoad || !isVisible || !isInitView)return;
            loadData();
            isFirstLoad = false;
        }else {
            loadData();
        }
    }

    public boolean isLazyLoad() {
        return true;
    }

    protected abstract void loadData();


    @Override
    public void onPause() {
        lifeCycleSubject.onNext(LifeCycleEvent.PAUSE);
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    public void onStop() {
        lifeCycleSubject.onNext(LifeCycleEvent.STOP);
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    public void onStart() {
        lifeCycleSubject.onNext(LifeCycleEvent.START);
        super.onStart();
    }

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!getUserVisibleHint()){
            doOnInvisible();
            isVisible = false;
            Logger.d("NOW 不可见");
        }else {
            Logger.d("NOW 可见");
            isVisible = true;
            lazyLoad();
            doOnVisible();
        }
    }

    public void doOnVisible() {

    }

    public void doOnInvisible() {

    }

    @Override
    public void onDestroyView() {
        lifeCycleSubject.onNext(LifeCycleEvent.DESTROY);
        super.onDestroyView();
        isInitView = false;
        isLoad = false;
        ButterKnife.unbind(this);
        Log.d(TAG, "onDestroyView: ");
//        RefWatcher refWatcher = BaseApplication.getRefWatcher(getActivity());
//        refWatcher.watch(this);
    }






    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN,isHidden());
        super.onSaveInstanceState(outState);

    }

    protected abstract void initViews();

    protected abstract int getLayoutId();

    protected abstract void showError();

    protected abstract void showLoading();

}
