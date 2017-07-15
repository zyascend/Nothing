package com.zyascend.Nothing.mvp.mainpage.follow;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;
import com.zyascend.Nothing.mvp.mainpage.MainContract;

/**
 * 功能：
 * 作者：zyascend on 2017/5/11 16:29
 * 邮箱：zyascend@qq.com
 */

public class FollowPresenter extends BasePresenter<MainContract.FollowView>
        implements MainContract.FollowPresenter{

    private HttpService httpService;

    public FollowPresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void fetchDynamic(String firstTime) {
        httpService.getFollowDynamic(firstTime, lifeCycleSubject, new BaseDataCallback<SiftsDataBean>() {
            @Override
            public void onSuccess(SiftsDataBean data) {
                if (isViewAttached())mViewRef.get().onGetDynamic(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().showError();
            }
        });
    }
}
