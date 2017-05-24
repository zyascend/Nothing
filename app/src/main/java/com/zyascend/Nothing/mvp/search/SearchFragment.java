package com.zyascend.Nothing.mvp.search;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.bean.Master;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/24 22:17
 * 邮箱：zyascend@qq.com
 */

public class SearchFragment extends MVPBaseFragment<SearchContract.View, SearchPresenter>
        implements SearchContract.View {


    @Bind(R.id.tv_search)
    TextView tvSearch;
    @Bind(R.id.tv_moreHotTag)
    TextView tvMoreHotTag;
    @Bind(R.id.tagRecyclerView)
    RecyclerView tagRecyclerView;
    @Bind(R.id.tv_filter)
    TextView tvFilter;
    @Bind(R.id.userRecyclerView)
    RecyclerView userRecyclerView;
    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    @Override
    protected void loadData() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void showError() {

    }

    @Override
    protected void showLoading() {

    }

    @Override
    public void onGetHotTags(List<HotTag> hotTags) {

    }

    @Override
    public void onGetMaster(List<Master> masters) {

    }

    @Override
    protected SearchPresenter initPresenter() {
        return null;
    }


}
