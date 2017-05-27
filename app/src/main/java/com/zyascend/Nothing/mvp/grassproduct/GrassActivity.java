package com.zyascend.Nothing.mvp.grassproduct;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseActivity;
import com.zyascend.Nothing.bean.GrassProduct;
import com.zyascend.Nothing.bean.ProdBox;
import com.zyascend.Nothing.bean.ProductMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/26 15:02
 * 邮箱：zyascend@qq.com
 */

public class GrassActivity extends MVPBaseActivity<GrassContract.View, GrassPresenter>
        implements GrassContract.View, SwipeRefreshLayout.OnRefreshListener {


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
    RecyclerView reHotBox;
    @Bind(R.id.re_grass_product)
    RecyclerView reGrassProduct;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.re_menu)
    RecyclerView reMenu;
    @Bind(R.id.re_hotProduct)
    RecyclerView reHotProduct;

    private GrassMenuAdapter menuAdapter;
    private GrassProdAdapter grassProdAdapter;
    private HotProdAdapter hotProdAdapter;
    private ProdBoxAdapter boxAdapter;

    @Override
    protected GrassPresenter initPresenter() {
        return new GrassPresenter();
    }

    @Override
    protected void initView() {

        menuAdapter = new GrassMenuAdapter(this);
        reMenu.setAdapter(menuAdapter);
        reMenu.setLayoutManager(new GridLayoutManager(this,4));

        hotProdAdapter = new HotProdAdapter(this);
        reHotProduct.setAdapter(hotProdAdapter);
        reHotProduct.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

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
        if (menus == null){
            return;
        }
        menuAdapter.addDatas(menus,true);
    }

    @Override
    public void onGetHotProd(List<GrassProduct> products) {
        mPresenter.getProdBox();
        if (products == null)return;
        List<List<GrassProduct>> lists = new ArrayList<>();
        for (int i = 0; i < products.size() && i+5 < products.size(); i+=6) {
            lists.add(products.subList(i,i+5));
        }
        hotProdAdapter.addDatas(lists,true);
    }

    @Override
    public void onGetGrassProd(List<GrassProduct> products) {
        if (products == null)return;
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onGetProdBox(List<ProdBox> boxes) {
        mPresenter.getGrassProd();
        if (boxes == null)return;
        boxAdapter.addDatas(boxes,true);
    }

    @Override
    public void onRefresh() {

    }
}
