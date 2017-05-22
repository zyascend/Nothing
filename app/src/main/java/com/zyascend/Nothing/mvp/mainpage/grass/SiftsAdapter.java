package com.zyascend.Nothing.mvp.mainpage.grass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.SiftsBean;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;
import com.zyascend.amazingadapter.MultiAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/22 11:16
 * 邮箱：zyascend@qq.com
 */

public class SiftsAdapter extends MultiAdapter<SiftsBean> {



    public SiftsAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void bindCommonView(RecyclerView.ViewHolder holder, int position, int viewType) {
        SiftsHolder siftsHolder = (SiftsHolder) holder;
        siftsHolder.bind(mContext, dataList.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder createCommonHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sifts, parent, false);
        return new SiftsHolder(view);
    }

    class SiftsHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_user_img)
        ImageView ivUserImg;
        @Bind(R.id.iv_vip_img)
        ImageView ivVipImg;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_user_info)
        TextView tvUserInfo;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_description)
        TextView tvDescription;
        @Bind(R.id.iv_picture)
        ImageView ivPicture;
        @Bind(R.id.tv_picNum)
        TextView tvPicNum;
        @Bind(R.id.view_tag)
        View viewTag;
        @Bind(R.id.tv_lookCount)
        TextView tvLookCount;
        @Bind(R.id.tv_likeCount)
        TextView tvLikeCount;
        @Bind(R.id.iv_like)
        ImageView ivLike;
        @Bind(R.id.iv_comments)
        ImageView ivComments;
        @Bind(R.id.re_comLike)
        RelativeLayout reComLike;
        @Bind(R.id.tv_commentsCount)
        TextView tvCommentsCount;
        @Bind(R.id.list_comments)
        RecyclerView listComments;

        public SiftsHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(Context context, SiftsBean siftsBean) {
            if (siftsBean == null) return;
            SiftsBean.DynamicBean.MatchBean data = siftsBean.getDynamic().getMatch();
            if (data == null) return;

            String headUrl = data.getUser().getHead().getUrl();
            GlideUtils.loadCirclePic(context,ivUserImg,headUrl);

            tvName.setText(data.getUser().getName());
            tvTime.setText(data.getShowTime());

            String userInfo = data.getUser().getArea().getName()+"/"
                    +data.getUser().getHeight()+"/"+data.getUser().getHair().getName();
            tvUserInfo.setText(userInfo);

            // TODO: 2017/5/22 处理remind
            // url : http://blog.csdn.net/auronjim/article/details/47314881
            tvDescription.setText(data.getDescription());

            String picUrl = data.getPicture().getUrl();
            GlideUtils.loadRoundPic(context,ivPicture,picUrl);
            tvPicNum.setText(data.getPictureCount()+"张");

            // TODO: 2017/5/22  处理flexBox

            tvLookCount.setText(data.getLookCount()+" 浏览");
            tvLikeCount.setText(data.getPraiseCount()+" 赞");
            tvCommentsCount.setText("全部共"+data.getCommCount()+"条评论");

            // TODO: 2017/5/22 处理评论列表


        }
    }
}
