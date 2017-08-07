package com.zyascend.Nothing.mvp.grassproduct;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.GrassProduct;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/27 12:00
 * 邮箱：zyascend@qq.com
 */
public class HotProdAdapter extends AmazingAdapter<List<GrassProduct>> {


    public HotProdAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_menu, parent, false);
        return new HotProductHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        HotProductHolder myHolder = (HotProductHolder) holder;
        myHolder.bindData(dataList.get(position));
    }


    class HotProductHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.recyclerView)
        RecyclerView recyclerView;

        private HotProdChildAdapter adapter;

        public HotProductHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            adapter = new HotProdChildAdapter(mContext);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));

        }

        public void bindData(List<GrassProduct> data) {
            if (data == null) return;
            adapter.addDatas(data, true);
        }
    }

    public class HotProdChildAdapter extends AmazingAdapter<GrassProduct> {



        public HotProdChildAdapter(Context context) {
            super(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grass_prod, parent, false);
            return new HotProdChildHolder(view);
        }

        @Override
        protected void bindView(RecyclerView.ViewHolder holder, int position) {
            HotProdChildHolder myHolder = (HotProdChildHolder) holder;
            myHolder.bindData(dataList.get(position));
        }


        class HotProdChildHolder extends RecyclerView.ViewHolder {

            @Bind(R.id.iv_pic)
            ImageView ivPic;
            @Bind(R.id.tv_name)
            TextView tvName;
            @Bind(R.id.tv_price)
            TextView tvPrice;

            public HotProdChildHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }

            public void bindData(GrassProduct data) {
                if (data == null) return;
                GlideUtils.loadRoundPic(mContext,ivPic,data.getPicture().getUrl());
                tvName.setText(data.getName());
                tvPrice.setText(String.valueOf(data.getPrice()));
            }
        }
    }
}