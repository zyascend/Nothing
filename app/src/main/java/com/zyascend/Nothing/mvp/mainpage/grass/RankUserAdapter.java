package com.zyascend.Nothing.mvp.mainpage.grass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.RankingUser;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/22 11:15
 * 邮箱：zyascend@qq.com
 */

public class RankUserAdapter extends AmazingAdapter<RankingUser> {


    public static final int USER_TYPE_REDN = 4;
    public static final int USER_TYPE_YELLOWV = 2;


    public RankUserAdapter(Context mContext) {
        super(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank_user, parent, false);
        return new RankUserHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        RankUserHolder userHolder = (RankUserHolder) holder;
        userHolder.bind(dataList.get(position),mContext);
    }

    class RankUserHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_user_img)
        ImageView ivUserImg;
        @Bind(R.id.iv_vip_img)
        ImageView ivVipImg;
        @Bind(R.id.tv_name)
        TextView tvName;

        public RankUserHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(RankingUser data, Context context) {
            tvName.setText(data.getName());
            GlideUtils.loadCirclePic(context,ivUserImg,data.getHead().getUrl());
            if (USER_TYPE_REDN == data.getType()){
                ivVipImg.setImageResource(R.drawable.verified_icon);
            }else if (USER_TYPE_YELLOWV == data.getType()){
                ivVipImg.setImageResource(R.drawable.verified_yellow);
            }
        }
    }
}
