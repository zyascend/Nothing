package com.zyascend.Nothing.mvp.grassproduct;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.ProductMenu;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/27 11:51
 * 邮箱：zyascend@qq.com
 */
public class GrassMenuAdapter extends AmazingAdapter<ProductMenu> {



    public GrassMenuAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_product, parent, false);
        return new GrassMenuHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        GrassMenuHolder myHolder = (GrassMenuHolder) holder;
        myHolder.bindData(dataList.get(position));
    }


    class GrassMenuHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_pic)
        ImageView ivPic;
        @Bind(R.id.tv_name)
        TextView tvName;

        public GrassMenuHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(ProductMenu data) {
            if (data == null) return;
            GlideUtils.loadNormalPic(mContext,ivPic,data.getPicture().getUrl());
            tvName.setText(data.getName());
        }
    }

}