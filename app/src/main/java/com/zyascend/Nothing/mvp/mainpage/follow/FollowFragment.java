package com.zyascend.Nothing.mvp.mainpage.follow;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.mvp.mainpage.MainContract;

/**
 * 功能：
 * 作者：zyascend on 2017/5/11 16:28
 * 邮箱：zyascend@qq.com
 */

public class FollowFragment extends MVPBaseFragment<MainContract.FollowView,FollowPresenter>
    implements MainContract.FollowView{
    @Override
    protected void loadData() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_follow;
    }

    @Override
    public void showError() {

    }

    @Override
    protected void showLoading() {

    }

    @Override
    protected FollowPresenter initPresenter() {
        return new FollowPresenter();
    }
}
