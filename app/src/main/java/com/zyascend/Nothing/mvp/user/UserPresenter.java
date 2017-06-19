package com.zyascend.Nothing.mvp.user;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.mvp.http.HttpService;

/**
 * 功能：
 * 作者：zyascend on 2017/6/19 22:11
 * 邮箱：zyascend@qq.com
 */

public class UserPresenter extends BasePresenter<UserContract.View> implements UserContract.Presenter {

    private HttpService httpService;

    public UserPresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void getUser() {

    }

    @Override
    public void getMaster(String id) {
    }

    @Override
    public void getPraised(String id) {

    }

    @Override
    public void getDynamics(String id) {

    }

    @Override
    public void fallowMaster(String masterId) {

    }
}
