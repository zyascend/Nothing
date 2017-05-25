package com.zyascend.Nothing.mvp.rank;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.RankingMatch;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/25 22:46
 * 邮箱：zyascend@qq.com
 */

public class RankPresenter extends BasePresenter<RankContract.View>
        implements RankContract.Presenter  {

    private HttpService httpService;
    public RankPresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void getRankingMatch(String rankingType, String gender) {
        httpService.findRankingMatchs(lifeCycleSubject, rankingType
                , gender, new BaseDataCallback<List<RankingMatch>>() {
                    @Override
                    public void onSuccess(List<RankingMatch> data) {
                        if (isViewAttached())mViewRef.get().onGetRankingMatch(data);
                    }

                    @Override
                    public void onFail(String errorMsg) {
                        if (isViewAttached())mViewRef.get().onGetRankingMatch(null);
                        Logger.e(errorMsg);

                    }
                });
    }

    @Override
    public void getRankingUser(String rankingType, String gender) {
        httpService.findRankingUsers(lifeCycleSubject, rankingType, gender
                , new BaseDataCallback<List<Master>>() {
                    @Override
                    public void onSuccess(List<Master> data) {
                        if (isViewAttached())mViewRef.get().onGetRankingUser(data);
                    }

                    @Override
                    public void onFail(String errorMsg) {
                        if (isViewAttached())mViewRef.get().onGetRankingUser(null);
                        Logger.e(errorMsg);
                    }
                });
    }
}
