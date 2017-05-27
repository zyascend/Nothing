package com.zyascend.Nothing.mvp.grassproduct;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.GrassProduct;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/27 12:02
 * 邮箱：zyascend@qq.com
 */
public class GrassProdAdapter extends AmazingAdapter<GrassProduct> {

    public GrassProdAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grass_prod, parent, false);
        return new GrassProdHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        GrassProdHolder myHolder = (GrassProdHolder) holder;
        myHolder.bindData(dataList.get(position));
    }


    class GrassProdHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_pic)
        ImageView ivPic;
        @Bind(R.id.iv_source)
        ImageView ivSource;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_price)
        TextView tvPrice;

        public GrassProdHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(GrassProduct data) {
            if (data == null) return;
            if (TextUtils.equals("天猫",data.getSourceName())){
                ivSource.setImageResource(R.drawable.nothing_logo);
            }
            GlideUtils.loadNormalPic(mContext,ivPic,data.getPicture().getUrl());
            tvName.setText(data.getName());
            tvPrice.setText(data.getPrice());
        }
    }
}