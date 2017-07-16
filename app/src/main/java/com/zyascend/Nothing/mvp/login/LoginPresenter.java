package com.zyascend.Nothing.mvp.login;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;
import com.zyascend.Nothing.mvp.login.LoginContract;

/**
 * 登陆界面的Presenter
 * Created by Administrator on 2017/4/24.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {


    private final HttpService httpService;

    public LoginPresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void getIdentifyCode(String phoneNumber) {
        httpService.getIdentifyCode(phoneNumber, lifeCycleSubject, new BaseDataCallback<String>() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached())
                    mViewRef.get().onSendIdentifyCode(data);
            }

            @Override
            public void onFail(String errorMsg) {

            }
        });
    }

    @Override
    public void login(String phoneNumber, String password) {

    }

    @Override
    public void register(String phoneNumber, String passWord, String code) {
        httpService.register(phoneNumber,passWord,code,lifeCycleSubject, new BaseDataCallback<String>() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached())
                    mViewRef.get().onRegistered(data);
            }

            @Override
            public void onFail(String errorMsg) {

            }
        });

    }
}
