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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.BaseFragment;
import com.zyascend.Nothing.common.view.BottomDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：
 * 作者：zyascend on 2017/5/26 09:18
 * 邮箱：zyascend@qq.com
 */

public class RankBaseFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.iv_help)
    ImageView ivHelp;
    @Bind(R.id.tv_sex_filter)
    TextView sexFilter;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tv_24)
    TextView tv24;
    @Bind(R.id.tv_week)
    TextView tvWeek;
    @Bind(R.id.tv_month)
    TextView tvMonth;
    @Bind(R.id.ll_rank)
    LinearLayout llRank;

    private RankPageAdapter adapter;
    private BottomDialog mDialog;

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

    @OnClick({R.id.tv_sex_filter, R.id.tv_24, R.id.tv_week, R.id.tv_month})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sex_filter:
                showSexFilterDialog();
                break;
            case R.id.tv_24:

                break;
            case R.id.tv_week:

                break;
            case R.id.tv_month:

                break;

            case R.id.tv_all:

                break;
            case R.id.tv_male:

                break;
            case R.id.tv_female:

                break;
            case R.id.tv_cancel:

                break;

        }
    }

    private void showSexFilterDialog() {
        mDialog = BottomDialog.create(getChildFragmentManager())
                .setLayoutRes(R.layout.dialog_sex_filter)
                .setViewListener(new BottomDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {
                        bindDialogView(v);
                    }
                })
                .show();

    }

    private void bindDialogView(View v) {

        TextView all = (TextView) v.findViewById(R.id.tv_all);
        TextView male = (TextView) v.findViewById(R.id.tv_male);
        TextView female = (TextView) v.findViewById(R.id.tv_female);
        TextView cancel = (TextView) v.findViewById(R.id.tv_cancel);

        all.setOnClickListener(this);
        male.setOnClickListener(this);
        female.setOnClickListener(this);
        cancel.setOnClickListener(this);

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
            switch (position) {
                case 0:
                    return "搭配";
                case 1:
                    return "n博主";
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
