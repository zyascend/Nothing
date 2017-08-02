package com.zyascend.Nothing.mvp.mainpage.follow;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.SiftsBean;
import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.mvp.mainpage.MainContract;
import com.zyascend.Nothing.mvp.mainpage.grass.SiftsAdapter;
import com.zyascend.amazingadapter.MultiAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/11 16:28
 * 邮箱：zyascend@qq.com
 */

public class FollowFragment extends MVPBaseFragment<MainContract.FollowView, FollowPresenter>
        implements MainContract.FollowView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private SiftsAdapter adapter;
    private boolean isRefresh = true;
    private String curFirstTime;

    @Override
    protected void loadData() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
    }

    @Override
    protected void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new SiftsAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycler;
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

    @Override
    public void onRefresh() {
        mPresenter.fetchDynamic(null);
    }

    @Override
    public void onGetDynamic(SiftsDataBean data) {
        if (data == null) {
            showError();
            if (!isRefresh){
                adapter.toggleStatus(MultiAdapter.STATUS_ERROR);
            }
            return;
        }
        List<SiftsBean> list = data.getList();
        if (!list.isEmpty() && list.get(0).getType() == 6){
            list.remove(0);
        }
        if (isRefresh) {
            adapter.addDatas(list,true);
            isRefresh = false;
        }
        else adapter.addDatas(list,false);
        curFirstTime = data.getFirstTime();
        if (TextUtils.isEmpty(curFirstTime))
            adapter.toggleStatus(MultiAdapter.STATUS_END);
    }
}
