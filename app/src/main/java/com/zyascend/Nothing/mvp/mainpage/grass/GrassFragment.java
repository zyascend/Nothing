package com.zyascend.Nothing.mvp.mainpage.grass;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loonggg.rvbanner.lib.RecyclerViewBanner;
import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.RankingUser;
import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.mvp.mainpage.MainContract;
import com.zyascend.amazingadapter.LoadMoreListener;
import com.zyascend.amazingadapter.MultiAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 功能：
 * 作者：zyascend on 2017/5/11 16:23
 * 邮箱：zyascend@qq.com
 */

public class GrassFragment extends MVPBaseFragment<MainContract.GrassView, GrassPresenter>
        implements MainContract.GrassView, SwipeRefreshLayout.OnRefreshListener, LoadMoreListener {


    @Bind(R.id.rv_banner_1)
    RecyclerViewBanner banner;
    @Bind(R.id.re_MenuView)
    RecyclerView reMenu;
    @Bind(R.id.text_renqi)
    TextView textRenqi;
    @Bind(R.id.tv_getMore)
    TextView tvGetMore;
    @Bind(R.id.re_findRankUser)
    RecyclerView reFindRankUser;
    @Bind(R.id.re_sifts)
    RecyclerView reSifts;
    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    private MenuAdapter menuAdapter;
    private RankUserAdapter userAdapter;
    private SiftsAdapter siftsAdapter;


    /**
     * 用于分页请求的时间戳
     */
    private String curFirstTime;
    private List<BannerBean> bannerList;
    private boolean isRefresh = true;

    @Override
    protected void loadData() {
        swipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });

    }

    @Override
    protected void initViews() {
        //配置refreshLayout
        swipeRefresh.setOnRefreshListener(this);

        //配置Banner
        bannerList = new ArrayList<>();
        banner.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                String url = bannerList.get(position).getPicture().getUrl();
                Glide.with(bannerView.getContext())
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(bannerView);
            }
        });
        banner.setOnRvBannerClickListener(new RecyclerViewBanner.OnRvBannerClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(mActivity, "position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        //配置RecyclerView
        reMenu.setLayoutManager(new GridLayoutManager(mActivity,2));
        menuAdapter = new MenuAdapter(mActivity);
        reMenu.setAdapter(menuAdapter);

        reFindRankUser.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.HORIZONTAL,false));
        userAdapter = new RankUserAdapter(mActivity);
        reFindRankUser.setAdapter(userAdapter);

        siftsAdapter = new SiftsAdapter(mActivity);
        siftsAdapter.setLoadMoreListener(this);
        reSifts.setLayoutManager(new LinearLayoutManager(mActivity));
        reSifts.setAdapter(siftsAdapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_grass;
    }

    @Override
    public void showError() {
        Logger.e("ERROR");
    }

    @Override
    protected void showLoading() {

    }

    @Override
    protected GrassPresenter initPresenter() {
        return new GrassPresenter();
    }


    @Override
    public void onGetBanner(List<BannerBean> list) {
        if (list == null)showError();
        else {
            bannerList = list;
            banner.setRvBannerData(bannerList);
        }
        mPresenter.getMenu();
    }

    @Override
    public void onGetMenu(List<MenuBean> menuList) {
        if (menuList != null) {
            menuAdapter.addDatas(menuList,true);
        } else {
            showError();
        }
        mPresenter.getRankUser();
    }

    @Override
    public void onGetRankUser(List<RankingUser> userList) {
        if (userList != null) {
            userAdapter.addDatas(userList,true);
        } else {
            showError();
        }
        //请求第一页没有firstTime
        mPresenter.getSifts(null);
    }

    @Override
    public void onGetSifts(SiftsDataBean data) {

        if (data == null) {
            showError();
            if (!isRefresh){
                siftsAdapter.toggleStatus(MultiAdapter.STATUS_ERROR);
            }
            return;
        }
        Logger.d(data.getList().size());
        if (isRefresh) {
            siftsAdapter.addDatas(data.getList(),true);
            isRefresh = false;
        }
        else siftsAdapter.addDatas(data.getList(),false);
        curFirstTime = data.getFirstTime();
        if (TextUtils.isEmpty(curFirstTime))
            siftsAdapter.toggleStatus(MultiAdapter.STATUS_END);
    }

    @Override
    public void onRefresh() {
        mPresenter.getBanner();
    }

    @Override
    public void onLoadMore(boolean isReload) {
        if (!isRefresh) mPresenter.getSifts(curFirstTime);
    }
}
