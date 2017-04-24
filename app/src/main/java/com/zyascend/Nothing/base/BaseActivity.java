package com.zyascend.Nothing.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.LoginFilter;
import android.text.StaticLayout;
import android.util.Log;
import android.view.View;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.common.LifeCycleEvent;
import com.zyascend.Nothing.common.utils.StatusView;

import butterknife.ButterKnife;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subjects.PublishSubject;

/**
 * 基类Activity
 * Created by zyascend on 2017/4/22.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements View.OnClickListener {

    protected final String TAG = this.getClass().getSimpleName();
    public final PublishSubject<LifeCycleEvent> lifeCycleSubject = PublishSubject.create();
    protected StatusView statusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        statusView = new StatusView.Builder(this)
                .setErrorView(R.layout.view_error)
                .setLoadingView(R.layout.view_loading)
                .build();
        initView();
        loadData();
    }



    public void loadData() {}

    protected abstract void initView();

    protected abstract int getLayoutID();


    @Override
    protected void onStop() {
        lifeCycleSubject.onNext(LifeCycleEvent.STOP);
        super.onStop();
    }

    @Override
    protected void onPause() {
        lifeCycleSubject.onNext(LifeCycleEvent.PAUSE);
        super.onPause();
    }

    @Override
    protected void onResume() {
        lifeCycleSubject.onNext(LifeCycleEvent.RESUME);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        lifeCycleSubject.onNext(LifeCycleEvent.DESTROY);
        //RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
        //refWatcher.watch(this);
        super.onDestroy();
    }

    static{
        final String TAG = "RXTAG";
        RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler() {
            @Override
            public void handleError(Throwable e) {
                e.printStackTrace();
                Log.e(TAG, "handleError: e= "+e.toString());
            }
        });
    }
}
