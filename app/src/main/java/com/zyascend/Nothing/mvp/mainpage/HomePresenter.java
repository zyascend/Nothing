package com.zyascend.Nothing.mvp.mainpage;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;

import java.util.List;

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
        httpService.getNotice(lifeCycleSubject, new BaseDataCallback<Notice>() {
            @Override
            public void onSuccess(Notice data) {
                if (isViewAttached())mViewRef.get().onGetNotice(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetNotice(null);
            }
        });
    }

    @Override
    public void getMyTagList() {

        httpService.getMyTagList(lifeCycleSubject, new BaseDataCallback<List<HomeTag>>() {
            @Override
            public void onSuccess(List<HomeTag> data) {
                if (isViewAttached())mViewRef.get().onGetMyTagList(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetMyTagList(null);
            }
        });
    }
}
