package com.zyascend.Nothing.mvp.masterhot;

import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.bean.HotMatch;
import com.zyascend.Nothing.bean.RankMaster;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 10:11
 * 邮箱：zyascend@qq.com
 */

public interface MasterContract {

    interface Presenter{
        void getNewMatch();
        void getWeekMatch();
        void getMonthMatch();
        void getAllRank();
    }

    interface View extends BaseView{
        void onGetNewMatch(List<HotMatch> matches);
        void onGetWeekMatch(List<HotMatch> matches);
        void onGetMonthMatch(List<HotMatch> matches);
        void onGetAllRank(List<RankMaster> masters);
    }

}
