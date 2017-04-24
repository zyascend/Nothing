package com.zyascend.Nothing.mvp;

import android.view.View;

import com.zyascend.Nothing.base.MVPBaseActivity;

/**
 * 功能：
 * 作者：zyascend on 2017/4/24 10:28
 * 邮箱：zyascend@qq.com
 */

public class LogingActivity extends MVPBaseActivity<LoginContract.View,LoginPresenter>
        implements LoginContract.View{


    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return 0;
    }

    @Override
    public void showError() {
//        statusView.showError();
    }

    @Override
    protected LoginPresenter initPresenter() {
        return null;
    }

    @Override
    public void onClick(View view) {

    }
}
