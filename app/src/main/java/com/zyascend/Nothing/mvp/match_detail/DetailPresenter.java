package com.zyascend.Nothing.mvp.match_detail;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.MatchDetail;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 20:52
 * 邮箱：zyascend@qq.com
 */

public class DetailPresenter extends BasePresenter<DetailContract.View>
        implements DetailContract.Presenter {

    private HttpService httpService;
    public DetailPresenter() {
        httpService = HttpService.getInstance();
    }

    @Override
    public void getDetail(String id) {
        httpService.getDetail(id, lifeCycleSubject, new BaseDataCallback<MatchDetail>() {
            @Override
            public void onSuccess(MatchDetail data) {
                if (isViewAttached())mViewRef.get().onGetDetail(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetDetail(null);
            }
        });
    }

    @Override
    public void getProdAITags(String matchID) {

    }

    @Override
    public void getRecomendProd(String matchId) {

    }

    @Override
    public void getRecommedMatch(String matchId) {

    }


}
