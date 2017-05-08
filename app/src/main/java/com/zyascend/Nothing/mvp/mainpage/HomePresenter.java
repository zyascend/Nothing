package com.zyascend.Nothing.mvp.mainpage;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;
import com.zyascend.Nothing.mvp.login.LoginContract;

/**
 * 功能：
 * 作者：zyascend on 2017/5/1 16:00
 * 邮箱：zyascend@qq.com
 */

public class HomePresenter extends BasePresenter<MainContract.HomeView> implements MainContract.HomePresenter{
    private HttpService httpService;
    public HomePresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void getNotice() {
        httpService.getNotice(lifeCycleSubject, new BaseDataCallback<String>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFail(String errorMsg) {

            }
        });
    }
}
