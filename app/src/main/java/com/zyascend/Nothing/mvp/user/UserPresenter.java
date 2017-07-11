package com.zyascend.Nothing.mvp.user;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.MasterDetail;
import com.zyascend.Nothing.bean.UserMatch;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.common.rx.LifeCycleEvent;
import com.zyascend.Nothing.mvp.http.HttpService;

import java.util.List;

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
        httpService.getUser(lifeCycleSubject, new BaseDataCallback<MasterDetail>() {
            @Override
            public void onSuccess(MasterDetail data) {
                if (isViewAttached())mViewRef.get().onGetMaster(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().showError();
            }
        });
    }

    @Override
    public void getMaster(String id) {
        httpService.getMaster(id,lifeCycleSubject, new BaseDataCallback<MasterDetail>() {
            @Override
            public void onSuccess(MasterDetail data) {
                if (isViewAttached())mViewRef.get().onGetMaster(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().showError();
            }
        });
    }

    @Override
    public void getPraised(String id) {
        httpService.getPraised(id, lifeCycleSubject, new BaseDataCallback<List<UserMatch>>() {
            @Override
            public void onSuccess(List<UserMatch> data) {
                if (isViewAttached())mViewRef.get().onGetPraise(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().showError();
            }
        });
    }

    @Override
    public void getDynamics(String id) {

        httpService.getUserDynamics(id, lifeCycleSubject, new BaseDataCallback<List<UserMatch>>() {
            @Override
            public void onSuccess(List<UserMatch> data) {
                if (isViewAttached())mViewRef.get().onGetDynamic(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().showError();
            }
        });
    }

    @Override
    public void fallowMaster(String masterId) {
        httpService.addFollow(masterId,lifeCycleSubject);
    }

    @Override
    public void cancelFollow(String id) {
        httpService.cancelFollow(id,lifeCycleSubject);

    }


}
