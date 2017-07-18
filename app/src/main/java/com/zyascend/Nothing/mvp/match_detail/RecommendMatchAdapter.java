package com.zyascend.Nothing.mvp.match_detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.RecommendMatch;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/7/18 12:16
 * 邮箱：zyascend@qq.com
 */

public class RecommendMatchAdapter extends AmazingAdapter<RecommendMatch> {


    public RecommendMatchAdapter(Context mContext) {
        super(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MatchHolder(inflate(R.layout.item_recommend_match, parent));
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        MatchHolder matchHolder = (MatchHolder) holder;
        matchHolder.bind(dataList.get(position));
    }

    class MatchHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_pic)
        ImageView ivPic;
        @Bind(R.id.tv_description)
        TextView tvDescription;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_likeCount)
        TextView tvLikeCount;

        public MatchHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(RecommendMatch match) {

            if (match == null || match.matchBean == null)return;
            GlideUtils.loadNormalPic(mContext,ivPic,match.matchBean.getPicture().getUrl());

            tvDescription.setText(match.matchBean.getDescription());
            tvName.setText(match.matchBean.getUser().getName());
            tvLikeCount.setText(match.matchBean.getPraiseCount());

        }
    }
}
