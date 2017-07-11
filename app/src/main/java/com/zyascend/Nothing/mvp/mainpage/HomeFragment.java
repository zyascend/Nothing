package com.zyascend.Nothing.mvp.mainpage;

import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.common.view.BottomDialog;
import com.zyascend.Nothing.mvp.mainpage.follow.FollowFragment;
import com.zyascend.Nothing.mvp.mainpage.grass.GrassFragment;
import com.zyascend.Nothing.mvp.mainpage.tag.TagFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 功能：Home界面的框架，负责推荐，关注，各种风格界面
 * 作者：zyascend on 2017/5/1 13:24
 * 邮箱：zyascend@qq.com
 */

public class HomeFragment extends MVPBaseFragment<MainContract.HomeView, HomePresenter>
        implements MainContract.HomeView{


    @Bind(R.id.btn_notifications)
    ImageView btnNotifications;
    @Bind(R.id.btn_guide)
    ImageView btnGuide;
    @Bind(R.id.tv_notifi_num)
    TextView tvNotifiNum;
    @Bind(R.id.tl_tag)
    TabLayout tlTag;
    @Bind(R.id.iv_tag)
    ImageView ivTag;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private TagPagerAdapter adapter;
    private BottomDialog mDialog;
    private List<HomeTag> mTagList;

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void loadData() {
        mPresenter.getNotice();
    }

    @Override
    protected void initViews() {
        viewPager.setOffscreenPageLimit(2);
        adapter = new TagPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tlTag.setupWithViewPager(viewPager);
    }


    @Override
    public boolean isLazyLoad() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void showError() {

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
                showAllTagDialog();
                break;
        }
    }

    private void showAllTagDialog() {
        mDialog = BottomDialog.create(getChildFragmentManager())
                .setLayoutRes(R.layout.dialog_edit_tag)
                .setViewListener(new BottomDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {

                    }
                })
                .show();

        //mDialog.dismiss();
    }

    @Override
    public void onGetNotice(Notice notice) {
        if (notice==null)showError();
        else {
            Logger.d("notice num :"+notice.getDATA().getList().size() );
            tvNotifiNum.setText(notice.getDATA().getList().size());
        }
        mPresenter.getMyTagList();
    }

    @Override
    public void onGetMyTagList(List<HomeTag> tagList) {
        if (tagList == null)showError();
        else {
            mTagList = tagList;
            adapter.setList(tagList);
        }
    }

    private static class TagPagerAdapter extends FragmentStatePagerAdapter {

        private static final String TITLE_FOLLOW = "关注";
        private static final String TITLE_GRASS = "推荐";
        private List<Fragment> fragmentList;
        private List<String> titleList;

        public TagPagerAdapter(FragmentManager fm) {
            super(fm);
            fragmentList = new ArrayList<>();
            titleList = new ArrayList<>();
            titleList.add(TITLE_GRASS);
            titleList.add(TITLE_FOLLOW);
            fragmentList.add(new GrassFragment());
            fragmentList.add(new FollowFragment());
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

        public void setList(List<HomeTag> tagList) {
            for (HomeTag tag : tagList){
                titleList.add(tag.getName());
                TagFragment fragment = TagFragment.getInstance(tag.getId());
                fragmentList.add(fragment);
            }
            notifyDataSetChanged();
        }
    }
}
