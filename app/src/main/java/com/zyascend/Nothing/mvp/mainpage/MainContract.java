package com.zyascend.Nothing.mvp.mainpage;

import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.bean.RankingUser;
import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.common.BaseDataCallback;

import java.util.List;

/**
 * 功能：Home界面的契约类
 * 作者：zyascend on 2017/5/1 15:37
 * 邮箱：zyascend@qq.com
 */

public interface MainContract {
    /**
     * 负责tab信息的获取和更新
     */
    interface HomeView extends BaseView {
        void onGetNotice(Notice notice);
        void onGetMyTagList(List<HomeTag> tagList);
    }
    interface HomePresenter {
        void getNotice();
        void getMyTagList();
    }

    /**
     * 负责推荐页面的逻辑
     */
    interface GrassView extends BaseView {

        void onGetBanner(List<BannerBean> bannerList);
        void onGetMenu(List<MenuBean> menuList);
        void onGetRankUser(List<RankingUser> userList);
        void onGetSifts(SiftsDataBean data);

    }

    interface GrassPresenter {

        void getBanner();
        void getMenu();
        void getRankUser();
        void getSifts(String firstTime);
    }

    /**
     * 负责关注页面的逻辑
     *
     */
    interface FollowView extends BaseView{}
    interface FollowPresenter{}

    /**
     * tag页面的逻辑
     */

    interface TagView extends BaseView{}
    interface TagPresenter{}


}
