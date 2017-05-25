package com.zyascend.Nothing.mvp.rank;

import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.RankingMatch;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/25 22:43
 * 邮箱：zyascend@qq.com
 */

public interface RankContract {

    interface View extends BaseView{
        void onGetRankingMatch(List<RankingMatch> matches);
        void onGetRankingUser(List<Master> masters);
    }

    interface Presenter {
        void getRankingMatch(String rankingType,String gender);
        void getRankingUser(String rankingType,String gender);
    }
}
