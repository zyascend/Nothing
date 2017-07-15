package com.zyascend.Nothing.mvp.mainpage.tag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.bean.ChildTag;
import com.zyascend.Nothing.bean.SiftsBean;
import com.zyascend.Nothing.mvp.mainpage.MainContract;
import com.zyascend.Nothing.mvp.mainpage.grass.SiftsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/22 10:09
 * 邮箱：zyascend@qq.com
 */

public class TagFragment extends MVPBaseFragment<MainContract.TagView, TagPresenter>
        implements MainContract.TagView, TagFilterAdapter.TagClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG_ID = "TAG_Id";
    @Bind(R.id.rv_style)
    RecyclerView rvStyle;
    @Bind(R.id.rv_height)
    RecyclerView rvHeight;
    @Bind(R.id.rv_brand)
    RecyclerView rvColor;
    @Bind(R.id.recyclerView)
    RecyclerView rvDynamic;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private String currentId;

    private TagFilterAdapter adapter_Line1;
    private TagFilterAdapter adapter_Line2;
    private TagFilterAdapter adapter_Line3;

    private SiftsAdapter siftsAdapter;
    private List<ChildTag> currentTagList;

    public static TagFragment getInstance(String id) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ID, id);
        TagFragment fragment = new TagFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentId = getArguments().getString(TAG_ID);
        Log.d(TAG, "onCreate: 当前ID是" + currentId);
    }

    @Override
    protected void loadData() {
        Toast.makeText(mActivity, "当前ID是" + currentId, Toast.LENGTH_SHORT).show();
        mPresenter.getChildTags(currentId);
    }

    @Override
    protected void initViews() {

        adapter_Line1 = new TagFilterAdapter(getActivity());
        adapter_Line2 = new TagFilterAdapter(getActivity());
        adapter_Line3 = new TagFilterAdapter(getActivity());

        rvStyle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        rvHeight.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        rvColor.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));

        rvStyle.setAdapter(adapter_Line1);
        rvHeight.setAdapter(adapter_Line2);
        rvColor.setAdapter(adapter_Line3);

        adapter_Line1.setTagClickListener(this);
        adapter_Line2.setTagClickListener(this);
        adapter_Line3.setTagClickListener(this);

        rvDynamic.setLayoutManager(new LinearLayoutManager(getActivity()));
        siftsAdapter = new SiftsAdapter(getActivity());
        rvDynamic.setAdapter(siftsAdapter);

        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tag;
    }

    @Override
    public void showError() {

    }

    @Override
    protected void showLoading() {

    }

    @Override
    protected TagPresenter initPresenter() {
        return new TagPresenter();
    }

    @Override
    public void onTagClick(ChildTag tag) {
        if (currentTagList == null)
            currentTagList = new ArrayList<>();
        currentTagList.set(tag.getShowLine()-1,tag);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mPresenter.getDynamic(currentId,currentTagList);
    }

    @Override
    public void onGetChildTags(List<List<ChildTag>> tags) {
        if (tags == null || tags.isEmpty())return;
        adapter_Line1.addDatas(tags.get(0),true);
        adapter_Line2.addDatas(tags.get(1),true);
        adapter_Line3.addDatas(tags.get(2),true);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
    }

    @Override
    public void onGetDynamic(List<SiftsBean> data) {
        siftsAdapter.addDatas(data,true);
    }
}
