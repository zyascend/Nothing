package com.zyascend.Nothing.mvp.match_detail;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseActivity;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 20:53
 * 邮箱：zyascend@qq.com
 */

public class DeatailActivity extends MVPBaseActivity<DetailContract.View,DetailPresenter>
    implements DetailContract.View{

    @Override
    public void showError() {

    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_match_detail;
    }
}
