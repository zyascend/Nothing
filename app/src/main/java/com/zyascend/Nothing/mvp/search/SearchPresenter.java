package com.zyascend.Nothing.mvp.search;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.SearchTag;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/24 22:16
 * 邮箱：zyascend@qq.com
 */

public class SearchPresenter extends BasePresenter<SearchContract.View>
    implements SearchContract.Presenter{
    @Override
    public void getHotTags() {

    }

    @Override
    public void getMaster(int startRow, List<SearchTag> selectedTags) {

    }
}
