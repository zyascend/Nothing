package com.zyascend.Nothing.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 使用MVP的Fragment基类
 * Created by zyascend on 2017/4/22.
 */

public abstract class MVPBaseFragment<V extends BaseView,T extends BasePresenter<V>> extends BaseFragment {
    protected T mPresenter;
    protected Bundle savedState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedState = savedInstanceState;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = initPresenter();
        if (mPresenter!=null)mPresenter.attachView((V)this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        mPresenter = null;
    }

    protected abstract T initPresenter();
}
