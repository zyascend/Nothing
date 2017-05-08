package com.zyascend.Nothing.mvp.mainpage;

import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.common.LifeCycleEvent;

import rx.subjects.PublishSubject;

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
        void onGetNotice();
    }
    interface HomePresenter {
        void getNotice();
    }

    /**
     * 负责推荐页面的逻辑
     */
    interface GrassView extends BaseView {}
    interface GrassPresenter {}



}
