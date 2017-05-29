package com.zyascend.Nothing.mvp.masterhot;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.HotMatch;
import com.zyascend.Nothing.bean.RankMaster;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 10:13
 * 邮箱：zyascend@qq.com
 */

public class MasterHotPresenter extends BasePresenter<MasterContract.View>
        implements MasterContract.Presenter {

    private static final String TYPE_NEW = "1";
    private static final String TYPE_WEEK = "2";
    private static final String TYPE_MONTH = "3";
    private HttpService httpService;

    public MasterHotPresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void getNewMatch() {
        httpService.findMatchRankByType(TYPE_NEW, lifeCycleSubject, new BaseDataCallback<List<HotMatch>>() {
            @Override
            public void onSuccess(List<HotMatch> data) {
                if (isViewAttached())mViewRef.get().onGetNewMatch(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetNewMatch(null);
            }
        });
    }

    @Override
    public void getWeekMatch() {
        httpService.findMatchRankByType(TYPE_WEEK, lifeCycleSubject, new BaseDataCallback<List<HotMatch>>() {
            @Override
            public void onSuccess(List<HotMatch> data) {
                if (isViewAttached())mViewRef.get().onGetWeekMatch(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetWeekMatch(null);
            }
        });
    }

    @Override
    public void getMonthMatch() {
        httpService.findMatchRankByType(TYPE_MONTH, lifeCycleSubject, new BaseDataCallback<List<HotMatch>>() {
            @Override
            public void onSuccess(List<HotMatch> data) {
                if (isViewAttached())mViewRef.get().onGetMonthMatch(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetMonthMatch(null);
            }
        });
    }

    @Override
    public void getAllRank() {
        httpService.findAllRanks(lifeCycleSubject, new BaseDataCallback<List<RankMaster>>() {
            @Override
            public void onSuccess(List<RankMaster> data) {
                if (isViewAttached())mViewRef.get().onGetAllRank(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetAllRank(null);
            }
        });
    }

}
