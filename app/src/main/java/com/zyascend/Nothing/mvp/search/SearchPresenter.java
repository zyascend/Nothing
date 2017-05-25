package com.zyascend.Nothing.mvp.search;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.SearchTag;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/24 22:16
 * 邮箱：zyascend@qq.com
 */

public class SearchPresenter extends BasePresenter<SearchContract.View>
    implements SearchContract.Presenter{

    private HttpService httpService;
    public SearchPresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void getHotTags() {
        httpService.getHotTags(lifeCycleSubject, new BaseDataCallback<List<HotTag>>() {
            @Override
            public void onSuccess(List<HotTag> data) {
                if (isViewAttached())mViewRef.get().onGetHotTags(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetHotTags(null);
                Logger.e(errorMsg);
            }
        });

    }

    @Override
    public void getMaster(int startRow, List<SearchTag> selectedTags) {
        httpService.findMasterListByTags(startRow, selectedTags, lifeCycleSubject
                , new BaseDataCallback<List<Master>>() {
                    @Override
                    public void onSuccess(List<Master> data) {
                        if (isViewAttached())mViewRef.get().onGetMaster(data);
                    }

                    @Override
                    public void onFail(String errorMsg) {
                        if (isViewAttached()) mViewRef.get().showError();
                        Logger.e(errorMsg);
                    }
                });
    }
}
