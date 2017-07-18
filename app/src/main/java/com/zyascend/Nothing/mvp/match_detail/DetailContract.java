package com.zyascend.Nothing.mvp.match_detail;

import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.bean.MatchDetail;
import com.zyascend.Nothing.bean.ProductAITag;
import com.zyascend.Nothing.bean.RecommendMatch;
import com.zyascend.Nothing.bean.RecommendProduct;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 20:51
 * 邮箱：zyascend@qq.com
 */

public interface DetailContract {

    interface View extends BaseView{
        void onGetDetail(MatchDetail detail);
        void onGetProdAiTag(List<ProductAITag> tags);
        void onGetRecommendProd(List<RecommendProduct> products);
        void onGetRecommendMatch(List<RecommendMatch> matches);
    }

    interface Presenter{
        void getDetail(String id);
        void getProdAITags(String matchID);
        void getRecomendProd(String matchId);
        void getRecommedMatch(String matchId);
    }

}
