package com.zyascend.Nothing.mvp.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/25 09:51
 * 邮箱：zyascend@qq.com
 */

public class HotTagAdapter extends AmazingAdapter<HotTag> {


    public HotTagAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot_tag, parent, false);
        return new HotTagHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        HotTagHolder hotTagHolder = (HotTagHolder) holder;
        hotTagHolder.bindData(dataList.get(position));
    }


    class HotTagHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_tag_img)
        ImageView ivTagImg;
        @Bind(R.id.tv_tagName)
        TextView tvTagName;
        @Bind(R.id.tv_hotNum)
        TextView tvHotNum;

        public HotTagHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(HotTag data) {
            if (data == null)return;
            GlideUtils.loadRoundPic(mContext,ivTagImg,data.getPicture().getUrl());
            tvHotNum.setText(data.getHotNum());
            tvTagName.setText("#"+data.getName());
        }
    }
}
