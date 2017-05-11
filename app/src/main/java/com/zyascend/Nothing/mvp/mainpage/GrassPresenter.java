package com.zyascend.Nothing.mvp.mainpage;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.RankingUser;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/11 16:25
 * 邮箱：zyascend@qq.com
 */

public class GrassPresenter extends BasePresenter<MainContract.GrassView>
    implements MainContract.GrassPresenter{

    private HttpService httpService;
    public GrassPresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void getBanner() {
        httpService.getBanner(lifeCycleSubject, new BaseDataCallback<List<BannerBean>>() {
            @Override
            public void onSuccess(List<BannerBean> data) {
                if (isViewAttached())mViewRef.get().onGetBanner(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetBanner(null);
            }
        });
    }

    @Override
    public void getMenu() {
        httpService.getMenu(lifeCycleSubject, new BaseDataCallback<List<MenuBean>>() {
            @Override
            public void onSuccess(List<MenuBean> data) {
                if (isViewAttached())mViewRef.get().onGetMenu(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetMenu(null);
            }
        });
    }

    @Override
    public void getRankUser() {
        httpService.getRankingUser(lifeCycleSubject, new BaseDataCallback<List<RankingUser>>() {
            @Override
            public void onSuccess(List<RankingUser> data) {
                if (isViewAttached())mViewRef.get().onGetRankUser(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetRankUser(null);
            }
        });
    }

    @Override
    public void getSifts() {

    }
}
