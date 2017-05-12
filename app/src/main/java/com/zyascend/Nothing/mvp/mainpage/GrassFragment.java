package com.zyascend.Nothing.mvp.mainpage;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loonggg.rvbanner.lib.RecyclerViewBanner;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.RankingUser;
import com.zyascend.Nothing.bean.SiftsDataBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/11 16:23
 * 邮箱：zyascend@qq.com
 */

public class GrassFragment extends MVPBaseFragment<MainContract.GrassView, GrassPresenter>
        implements MainContract.GrassView {


    @Bind(R.id.rv_banner_1)
    RecyclerViewBanner rvBanner1;
    @Bind(R.id.re_coverView)
    RecyclerView reCoverView;
    @Bind(R.id.text_renqi)
    TextView textRenqi;
    @Bind(R.id.tv_getMore)
    TextView tvGetMore;
    @Bind(R.id.re_findRankUser)
    RecyclerView reFindRankUser;
    @Bind(R.id.re_sifts)
    RecyclerView reSifts;
    /**
     * 用于分页请求的时间戳
     *
     */
    private String curFirstTime;

    @Override
    protected void loadData() {
        mPresenter.getBanner();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_grass;
    }

    @Override
    public void showError() {

    }

    @Override
    protected void showLoading() {

    }

    @Override
    protected GrassPresenter initPresenter() {
        return new GrassPresenter();
    }


    @Override
    public void onGetBanner(List<BannerBean> bannerList) {
        if (bannerList != null){
            Log.d(TAG, "onGetBanner: "+bannerList.size());
        }else{
            showError();
        }
        mPresenter.getMenu();
    }

    @Override
    public void onGetMenu(List<MenuBean> menuList) {
        if (menuList != null){
            Log.d(TAG, "onGetBanner: "+menuList.size());
        }else{
            showError();
        }
        mPresenter.getRankUser();
    }

    @Override
    public void onGetRankUser(List<RankingUser> userList) {
        if (userList != null){
            Log.d(TAG, "onGetBanner: "+userList.size());
        }else{
            showError();
        }
        //请求第一页没有firstTime
        mPresenter.getSifts(null);
    }

    @Override
    public void onGetSifts(SiftsDataBean data) {
        if (data == null){
            showError();
            return;
        }

        curFirstTime = data.getFirstTime();


    }
}
