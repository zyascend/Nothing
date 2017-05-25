package com.zyascend.Nothing.mvp.rank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.RankingMatch;
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
    private static final int TYPE_MATCH = 1000;
    private static final int TYPE_USER = 2000;
    private int type = TYPE_MATCH;

    private SearchMasterAdapter masterAdapter;


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
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        if (type == TYPE_USER){


        }else {
            masterAdapter = new SearchMasterAdapter(mActivity);
            recyclerView.setAdapter(masterAdapter);
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
        if (matches == null)showError();

    }

    @Override
    public void onGetRankingUser(List<Master> masters) {
        if (masters == null)showError();
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
