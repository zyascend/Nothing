package com.zyascend.Nothing.mvp.search;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.base.MVPBaseActivity;

/**
 * 功能：
 * 作者：zyascend on 2017/7/19 15:17
 * 邮箱：zyascend@qq.com
 */

public class SearchActivity extends MVPBaseActivity {
    @Override
    protected BasePresenter initPresenter() {
        return new SearchActivityPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_search;
    }
}
