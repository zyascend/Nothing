package com.zyascend.Nothing.mvp.masterhot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.HotMatch;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 14:57
 * 邮箱：zyascend@qq.com
 */
public class HotMatchAdapter extends AmazingAdapter<HotMatch> {

    public HotMatchAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot_match, parent, false);
        //view.getLayoutParams().width = mRecyclerWidth/3;
        return new HotMatchHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        HotMatchHolder myHolder = (HotMatchHolder) holder;
        myHolder.bindData(dataList.get(position));
    }


    class HotMatchHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_pic)
        ImageView ivPic;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_fans)
        TextView tvFans;

        public HotMatchHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(HotMatch data) {

            if (data == null){
                Logger.d("DATA NULL");
                return;
            }
            HotMatch.MatchBean match = data.getMatch();
            if (match == null){
                Logger.d("MATCH NULL");
                return;
            }
            GlideUtils.loadRoundPic(mContext,ivPic,match.getPicture().getUrl());
            tvName.setText(match.getUser().getName());
            tvFans.setText(match.getUser().getFansNum()+" 粉丝 "+match.getUser().getFansNum()+" 赞");
        }
    }
}