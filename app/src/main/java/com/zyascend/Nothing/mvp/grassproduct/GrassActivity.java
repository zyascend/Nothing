package com.zyascend.Nothing.mvp.grassproduct;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseActivity;
import com.zyascend.Nothing.bean.GrassProduct;
import com.zyascend.Nothing.bean.ProdBox;
import com.zyascend.Nothing.bean.ProductMenu;
import com.zyascend.Nothing.common.utils.ActivityUtils;
import com.zyascend.Nothing.common.view.BottomDialog;
import com.zyascend.Nothing.common.view.ScrollRecyclerView;
import com.zyascend.Nothing.mvp.search.SearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：主编推荐页面
 * 作者：zyascend on 2017/5/26 15:02
 * 邮箱：zyascend@qq.com
 */

public class GrassActivity extends MVPBaseActivity<GrassContract.View, GrassPresenter>
        implements GrassContract.View,
        SwipeRefreshLayout.OnRefreshListener
        , View.OnClickListener {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_search)
    TextView tvSearch;
    @Bind(R.id.tv_filter)
    TextView tvFilter;
    @Bind(R.id.tv_more_hot_product)
    TextView tvMoreHotProduct;
    @Bind(R.id.tv_more_box)
    TextView tvMoreBox;
    @Bind(R.id.re_hot_box)
    ScrollRecyclerView reHotBox;
    @Bind(R.id.re_grass_product)
    ScrollRecyclerView reGrassProduct;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.re_menu)
    ScrollRecyclerView reMenu;
    @Bind(R.id.re_hotProduct)
    ScrollRecyclerView reHotProduct;

    private GrassMenuAdapter menuAdapter;
    private GrassProdAdapter grassProdAdapter;
    private HotProdAdapter hotProdAdapter;
    private ProdBoxAdapter boxAdapter;
    private BottomDialog mDialog;

    @Override
    protected GrassPresenter initPresenter() {
        return new GrassPresenter();
    }

    @Override
    protected void initView() {

        menuAdapter = new GrassMenuAdapter(this);
        reMenu.setAdapter(menuAdapter);
        reMenu.setLayoutManager(new GridLayoutManager(this, 4));

        hotProdAdapter = new HotProdAdapter(this);
        reHotProduct.setAdapter(hotProdAdapter);
        reHotProduct.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        boxAdapter = new ProdBoxAdapter(this);
        reHotBox.setAdapter(boxAdapter);
        reHotBox.setLayoutManager(new LinearLayoutManager(this));

        grassProdAdapter = new GrassProdAdapter(this);
        reGrassProduct.setAdapter(grassProdAdapter);
        reGrassProduct.setLayoutManager(new LinearLayoutManager(this));

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
        return R.layout.activity_product;
    }

    @Override
    public void showError() {

    }

    @Override
    public void onGetProdMenu(List<ProductMenu> menus) {
        mPresenter.getHotProd();
        if (menus == null) {
            return;
        }
        menuAdapter.addDatas(menus, true);
    }

    @Override
    public void onGetHotProd(List<GrassProduct> products) {
        mPresenter.getProdBox();
        if (products == null) return;
        List<List<GrassProduct>> lists = new ArrayList<>();
        for (int i = 0; i < products.size() && i + 5 < products.size(); i += 6) {
            lists.add(products.subList(i, i + 5));
        }
        hotProdAdapter.addDatas(lists, true);
    }

    @Override
    public void onGetGrassProd(List<GrassProduct> products) {
        swipeRefreshLayout.setRefreshing(false);
        if (products == null) return;
        grassProdAdapter.addDatas(products,true);
    }

    @Override
    public void onGetProdBox(List<ProdBox> boxes) {
        mPresenter.getGrassProd();
        if (boxes == null) return;
        boxAdapter.addDatas(boxes, true);
    }

    @Override
    public void onRefresh() {
        mPresenter.getProdMenu(2);
    }

    private void showFilterDialog() {
        mDialog = BottomDialog.create(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_grass_filter)
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
        TextView haitao = (TextView) v.findViewById(R.id.tv_haitao);
        TextView female = (TextView) v.findViewById(R.id.tv_taobao);
        TextView taobao = (TextView) v.findViewById(R.id.tv_cancel);

        all.setOnClickListener(this);
        haitao.setOnClickListener(this);
        female.setOnClickListener(this);
        taobao.setOnClickListener(this);

    }


    @OnClick({R.id.iv_back, R.id.tv_search, R.id.tv_filter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.tv_search:
                ActivityUtils.startActivity(this,SearchActivity.class);
                break;
            case R.id.tv_filter:
                showFilterDialog();
                break;
            case R.id.tv_all:
                mDialog.dismiss();

                break;
            case R.id.tv_haitao:

                break;
            case R.id.tv_taobao:

                break;
            case R.id.tv_cancel:

                break;
        }
    }
}
