package com.zyascend.Nothing.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 需要使用MVP模式的基类Activity
 * Created by zyascend on 2017/4/22.
 */

public abstract class MVPBaseActivity<V extends BaseView,T extends BasePresenter<V>> extends BaseActivity {


    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        if (mPresenter!=null)mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter = null;
    }

    protected abstract T initPresenter();
}
