package com.zyascend.Nothing.mvp.search;

import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.SearchTag;

import java.util.List;

/**
 * 功能：Search页面契约类
 * 作者：zyascend on 2017/5/24 22:12
 * 邮箱：zyascend@qq.com
 */

public interface SearchContract {
    interface Presenter {
        void getHotTags();
        void getMaster(int startRow, List<SearchTag> selectedTags);

    }
    interface View extends BaseView{
        void onGetHotTags(List<HotTag> hotTags);
        void onGetMaster(List<Master> masters);
    }
}
