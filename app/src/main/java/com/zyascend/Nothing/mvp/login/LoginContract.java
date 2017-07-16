package com.zyascend.Nothing.mvp.login;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.base.BaseView;

/**
 * 功能：登录界面契约类
 * 作者：zyascend on 2017/4/24 10:25
 * 邮箱：zyascend@qq.com
 */

public interface LoginContract {
    interface View extends BaseView{
        void onSendIdentifyCode(String msg);
        void onRegistered(String msg);
        void onLogined(String msg);
    }
    interface Presenter{
        void getIdentifyCode(String phoneNumber);
        void login(String phoneNumber,String password);
        void register(String phoneNumber,String passWord,String code);
    }
}
