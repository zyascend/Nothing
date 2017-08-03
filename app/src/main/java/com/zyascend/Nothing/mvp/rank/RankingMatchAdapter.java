package com.zyascend.Nothing.mvp.rank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.RankingMatch;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/25 23:14
 * 邮箱：zyascend@qq.com
 */

public class RankingMatchAdapter extends AmazingAdapter<RankingMatch> {


    public RankingMatchAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match_rank, parent, false);
        return new RankingMatchHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        RankingMatchHolder matchHolder = (RankingMatchHolder) holder;
        matchHolder.bindData(dataList.get(position));
    }

    class RankingMatchHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_pic)
        ImageView ivPic;
        @Bind(R.id.tv_rankNum)
        TextView tvRankNum;
        @Bind(R.id.tv_hotNum)
        TextView tvHotNum;

        public RankingMatchHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(RankingMatch data) {
            if (data == null)return;
            GlideUtils.loadNormalPic(mContext,ivPic,data.getMatch().getPicture().getUrl());
            tvRankNum.setText(String.valueOf(getAdapterPosition()+1));
            tvHotNum.setText(String.valueOf(data.getMatch().getHotNum()));
        }
    }
}
