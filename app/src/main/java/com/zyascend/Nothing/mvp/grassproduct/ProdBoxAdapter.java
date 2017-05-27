package com.zyascend.Nothing.mvp.grassproduct;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.ProdBox;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/27 12:03
 * 邮箱：zyascend@qq.com
 */
public class ProdBoxAdapter extends AmazingAdapter<ProdBox> {


    public ProdBoxAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prod_box, parent, false);
        return new ProdBoxHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        ProdBoxHolder myHolder = (ProdBoxHolder) holder;
        myHolder.bindData(dataList.get(position));
    }


    class ProdBoxHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_pic)
        ImageView ivPic;
        @Bind(R.id.re_box_prod)
        RecyclerView reBoxProd;

        private BoxProdAdapter adapter;

        public ProdBoxHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            adapter = new BoxProdAdapter(mContext);
            reBoxProd.setAdapter(adapter);
            reBoxProd.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        }

        public void bindData(ProdBox data) {
            if (data == null) return;
            GlideUtils.loadNormalPic(mContext, ivPic, data.getPicture().getUrl());
            adapter.addDatas(data.getProducts(), true);
        }
    }

    public class BoxProdAdapter extends AmazingAdapter<ProdBox.ProductsBean> {

        public BoxProdAdapter(Context context) {
            super(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_box_prod, parent, false);
            return new BoxProdHolder(view);
        }

        @Override
        protected void bindView(RecyclerView.ViewHolder holder, int position) {
            BoxProdHolder myHolder = (BoxProdHolder) holder;
            myHolder.bindData(dataList.get(position));
        }


        class BoxProdHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.iv_pic)
            ImageView ivPic;
            @Bind(R.id.tv_name)
            TextView tvName;
            @Bind(R.id.tv_price)
            TextView tvPrice;
            public BoxProdHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }

            public void bindData(ProdBox.ProductsBean data) {
                if (data == null) return;
                GlideUtils.loadNormalPic(mContext,ivPic,data.getPicture().getUrl());
                tvName.setText(data.getName());
                tvPrice.setText("￥"+data.getPrice());
            }
        }
    }
}