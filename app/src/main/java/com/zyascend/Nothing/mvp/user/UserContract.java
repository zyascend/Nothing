package com.zyascend.Nothing.mvp.user;

import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.MatchDetail;
import com.zyascend.Nothing.bean.UserBean;
import com.zyascend.Nothing.bean.UserMatch;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/6/19 21:27
 * 邮箱：zyascend@qq.com
 */

public interface UserContract {
    interface View extends BaseView {

        void onGetMaster(Master master);
        void onGetPraise(List<UserMatch> matches);
        void onGetDynamic(List<UserMatch> matches);

    }
    interface Presenter{
        void getUser();
        void getMaster(String id);
        void getPraised(String id);
        void getDynamics(String id);
        void fallowMaster(String masterId);
    }
}
