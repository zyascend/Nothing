package com.zyascend.Nothing.mvp.masterhot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.RankMaster;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 15:33
 * 邮箱：zyascend@qq.com
 */
public class AllRankAdapter extends AmazingAdapter<RankMaster> {


    public AllRankAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rankfragment_user, parent, false);
        return new AllRankHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        AllRankHolder myHolder = (AllRankHolder) holder;
        myHolder.bindData(dataList.get(position));
    }


    class AllRankHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_user_img)
        ImageView ivUserImg;
        @Bind(R.id.tv_user_name)
        TextView tvUserName;
        @Bind(R.id.tv_user_info)
        TextView tvUserInfo;
        @Bind(R.id.iv_pic_1)
        ImageView ivPic1;
        @Bind(R.id.iv_pic_2)
        ImageView ivPic2;
        @Bind(R.id.iv_pic_3)
        ImageView ivPic3;

        public AllRankHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(RankMaster data) {
            if (data == null) return;

            GlideUtils.loadCirclePic(mContext,ivUserImg,data.getHead().getUrl());
            tvUserName.setText(data.getName());

            String info = data.getFansNum()+"粉丝"+data.getPraiseNum()+"赞"
                    + data.getMatchNum()+"搭配";
            tvUserInfo.setText(info);

            String url1 = data.getDynamics().get(0).getMatch().getPicture().getUrl();
            GlideUtils.loadRoundPic(mContext,ivPic1,url1);

            String url2 = data.getDynamics().get(1).getMatch().getPicture().getUrl();
            GlideUtils.loadRoundPic(mContext,ivPic2,url2);

            String url3 = data.getDynamics().get(2).getMatch().getPicture().getUrl();
            GlideUtils.loadRoundPic(mContext,ivPic3,url3);

        }
    }
}