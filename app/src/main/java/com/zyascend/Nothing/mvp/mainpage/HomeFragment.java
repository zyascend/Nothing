package com.zyascend.Nothing.mvp.mainpage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：Home界面的框架，负责推荐，关注，各种风格界面
 * 作者：zyascend on 2017/5/1 13:24
 * 邮箱：zyascend@qq.com
 */

public class HomeFragment extends MVPBaseFragment<MainContract.HomeView, HomePresenter> {


    @Bind(R.id.btn_notifications)
    ImageView btnNotifications;
    @Bind(R.id.btn_guide)
    ImageView btnGuide;
    @Bind(R.id.tl_tag)
    TabLayout tlTag;
    @Bind(R.id.iv_tag)
    ImageView ivTag;
    @Bind(R.id.viewPager)
    ViewPager viewPager;


    private TagPagerAdapter adapter;

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void loadData() {


    }

    @Override
    protected void initViews() {
        viewPager.setOffscreenPageLimit(2);
        adapter = new TagPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tlTag.setupWithViewPager(viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void showError() {

    }

    @Override
    protected void showLoading() {

    }

    @OnClick({R.id.btn_notifications, R.id.btn_guide, R.id.iv_tag})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_notifications:

                break;
            case R.id.btn_guide:

                break;
            case R.id.iv_tag:

                break;
        }
    }

    private static class TagPagerAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> fragmentList;
        private List<String> titleList;

        public TagPagerAdapter(FragmentManager fm) {
            super(fm);
            fragmentList = new ArrayList<>();
            titleList = new ArrayList<>();
        }

        public void setList(List<Fragment> fragments,List<String> titles){
            this.fragmentList = fragments;
            this.titleList = titles;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return titleList != null ? titleList.size() : 0;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
