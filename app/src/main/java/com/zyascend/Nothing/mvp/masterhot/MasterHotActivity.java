package com.zyascend.Nothing.mvp.masterhot;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseActivity;
import com.zyascend.Nothing.bean.HotMatch;
import com.zyascend.Nothing.bean.RankMaster;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 10:13
 * 邮箱：zyascend@qq.com
 */

public class MasterHotActivity extends MVPBaseActivity<MasterContract.View, MasterHotPresenter>
        implements MasterContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_more_new)
    TextView tvMoreNew;
    @Bind(R.id.re_new)
    RecyclerView reNew;
    @Bind(R.id.tv_more_week)
    TextView tvMoreWeek;
    @Bind(R.id.re_week)
    RecyclerView reWeek;
    @Bind(R.id.tv_more_month)
    TextView tvMoreMonth;
    @Bind(R.id.re_month)
    RecyclerView reMonth;
    @Bind(R.id.re_total)
    RecyclerView reTotal;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private HotMatchAdapter newAdapter;
    private HotMatchAdapter weekAdapter;
    private HotMatchAdapter monthAdapter;
    private AllRankAdapter allRankAdapter;


    @Override
    public void showError() {

    }

    @Override
    protected MasterHotPresenter initPresenter() {
        return new MasterHotPresenter();
    }

    @Override
    protected void initView() {
        tvTitle.setText("博主人气榜");

        newAdapter = new HotMatchAdapter(this);
        reNew.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        reNew.setAdapter(newAdapter);

        weekAdapter = new HotMatchAdapter(this);
        reWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        reWeek.setAdapter(weekAdapter);

        monthAdapter = new HotMatchAdapter(this);
        reMonth.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        reMonth.setAdapter(monthAdapter);

        allRankAdapter = new AllRankAdapter(this);
        reTotal.setLayoutManager(new LinearLayoutManager(this));
        reTotal.setAdapter(allRankAdapter);

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_master_hot;
    }

    @OnClick({R.id.iv_back, R.id.tv_more_new, R.id.tv_more_week, R.id.tv_more_month})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.tv_more_new:
                break;
            case R.id.tv_more_week:
                break;
            case R.id.tv_more_month:
                break;
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.getNewMatch();
    }

    @Override
    public void onGetNewMatch(List<HotMatch> matches) {
        mPresenter.getWeekMatch();
        if (matches == null){
            showError();
            return;
        }
        newAdapter.addDatas(matches,true);
    }

    @Override
    public void onGetWeekMatch(List<HotMatch> matches) {
        mPresenter.getMonthMatch();
        if (matches == null){
            showError();
            return;
        }
        weekAdapter.addDatas(matches,true);
    }

    @Override
    public void onGetMonthMatch(List<HotMatch> matches) {
        mPresenter.getAllRank();
        if (matches == null){
            showError();
            return;
        }
        monthAdapter.addDatas(matches,true);
    }

    @Override
    public void onGetAllRank(List<RankMaster> masters) {
        if (masters == null){
            showError();
            return;
        }
        allRankAdapter.addDatas(masters,true);
    }

}
