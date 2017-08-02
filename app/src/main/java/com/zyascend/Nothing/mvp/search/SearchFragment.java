package com.zyascend.Nothing.mvp.search;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.common.view.BottomDialog;
import com.zyascend.amazingadapter.MultiAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 功能：
 * 作者：zyascend on 2017/5/24 22:17
 * 邮箱：zyascend@qq.com
 */

public class SearchFragment extends MVPBaseFragment<SearchContract.View, SearchFragmentPresenter>
        implements SearchContract.View, SwipeRefreshLayout.OnRefreshListener {

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
    private HotTagAdapter tagAdapter;
    private SearchMasterAdapter masterAdapter;
    private boolean isRefresh = true;
    private BottomDialog mDialog;

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
        swipeRefresh.setOnRefreshListener(this);

        tagAdapter = new HotTagAdapter(mActivity);
        tagRecyclerView.setAdapter(tagAdapter);
        tagRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));

        masterAdapter = new SearchMasterAdapter(mActivity);
        userRecyclerView.setAdapter(masterAdapter);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

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
        if (hotTags == null) showError();
        else {
            tagAdapter.addDatas(hotTags, true);
        }
        mPresenter.getMaster(0, null);
    }

    @Override
    public void onGetMaster(List<Master> masters) {
        swipeRefresh.setRefreshing(false);
        if (masters == null) {
            if (!isRefresh) {
                masterAdapter.toggleStatus(MultiAdapter.STATUS_END);
            } else {
                showError();
            }
            return;
        }
        if (masters.isEmpty()) {
            masterAdapter.toggleStatus(MultiAdapter.STATUS_END);
            return;
        }
        masterAdapter.addDatas(masters, isRefresh);
    }

    @Override
    protected SearchFragmentPresenter initPresenter() {
        return new SearchFragmentPresenter();
    }

    @Override
    public void onRefresh() {
        mPresenter.getHotTags();
    }

    @OnClick({R.id.tv_moreHotTag, R.id.tv_filter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_moreHotTag:

                break;
            case R.id.tv_filter:
                showFilterDialog();
                break;
        }
    }

    private void showFilterDialog() {
        mDialog = BottomDialog.create(getChildFragmentManager())
                .setLayoutRes(R.layout.dialog_master_filter)
                .setViewListener(new BottomDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {
                        bindDialogView(v);
                    }
                }).show();

    }

    private void bindDialogView(View v) {


    }
}
