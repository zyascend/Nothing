package com.zyascend.Nothing.mvp.rank;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/26 09:18
 * 邮箱：zyascend@qq.com
 */

public class RankBaseFragment extends BaseFragment {


    @Bind(R.id.iv_help)
    ImageView ivHelp;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private RankPageAdapter adapter;

    @Override
    protected void loadData() {

    }

    @Override
    protected void initViews() {
        adapter = new RankPageAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_rank;
    }

    @Override
    protected void showError() {

    }

    @Override
    protected void showLoading() {

    }

    private static class RankPageAdapter extends FragmentStatePagerAdapter {

        public RankPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return RankFragment.getInstance(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "搭配";
                case 1:
                    return  "n博主";
                default:
                    return "搭配";
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
