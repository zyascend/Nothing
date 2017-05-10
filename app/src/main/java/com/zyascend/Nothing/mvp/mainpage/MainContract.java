package com.zyascend.Nothing.mvp.mainpage;

import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.Notice;

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
    interface GrassView extends BaseView {}
    interface GrassPresenter {}



}
