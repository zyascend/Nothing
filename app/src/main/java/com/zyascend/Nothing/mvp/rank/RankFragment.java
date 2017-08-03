package com.zyascend.Nothing.mvp.rank;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.RankingMatch;
import com.zyascend.Nothing.common.utils.ActivityUtils;
import com.zyascend.Nothing.common.view.RecyclerDivider;
import com.zyascend.Nothing.mvp.search.SearchMasterAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/25 22:42
 * 邮箱：zyascend@qq.com
 */

public class RankFragment extends MVPBaseFragment<RankContract.View, RankPresenter>
        implements RankContract.View, SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private static final String TYPE = "fragment_type";
    private static final int TYPE_MATCH = 0;
    private static final int TYPE_USER = 1;
    private int type = TYPE_MATCH;

    private SearchMasterAdapter masterAdapter;
    private RankingMatchAdapter matchAdapter;


    public static RankFragment getInstance(int type){
        RankFragment rankFragment = new RankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE,type);
        rankFragment.setArguments(bundle);
        return rankFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt(TYPE);
    }

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
        swipeRefreshLayout.setOnRefreshListener(this);
        if (type == TYPE_USER){
            recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
            masterAdapter = new SearchMasterAdapter(mActivity);
            recyclerView.setAdapter(masterAdapter);
        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(mActivity,3));
            recyclerView.addItemDecoration(new RecyclerDivider(getActivity(), RecyclerDivider.BOTH_SET
                    , ActivityUtils.dpToPixel(2), Color.WHITE));
            matchAdapter = new RankingMatchAdapter(mActivity);
            recyclerView.setAdapter(matchAdapter);
        }
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
    public void onGetRankingMatch(List<RankingMatch> matches) {
        swipeRefreshLayout.setRefreshing(false);
        if (matches == null){
            showError();
            return;
        }
        matchAdapter.addDatas(matches,true);
    }

    @Override
    public void onGetRankingUser(List<Master> masters) {
        swipeRefreshLayout.setRefreshing(false);
        if (masters == null){
            showError();
            return;
        }
        masterAdapter.addDatas(masters,true);
    }

    @Override
    protected RankPresenter initPresenter() {
        return new RankPresenter();
    }

    @Override
    public void onRefresh() {
        if (type == TYPE_USER){
            mPresenter.getRankingUser("D",null);
        }else {
            mPresenter.getRankingMatch("D",null);
        }
    }
}
