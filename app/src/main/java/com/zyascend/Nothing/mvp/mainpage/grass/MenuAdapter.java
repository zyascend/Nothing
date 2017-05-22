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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/22 11:12
 * 邮箱：zyascend@qq.com
 */

public class MenuAdapter extends AmazingAdapter<MenuBean> {




    public MenuAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        MenuHolder menuHolder = (MenuHolder) holder;
        MenuBean data = dataList.get(position);
        if (data == null)return;
        menuHolder.tvName.setText(data.getName());
        menuHolder.tvSubName.setText(data.getSubName());
        if (1 == data.getPicType()){

            menuHolder.userImgLayout.setVisibility(View.GONE);
            menuHolder.ivNormalImg.setVisibility(View.VISIBLE);
            GlideUtils.loadNormalPic(mContext,menuHolder.ivNormalImg,data.getPicture().getUrl());
        }else {
            menuHolder.userImgLayout.setVisibility(View.VISIBLE);
            menuHolder.ivNormalImg.setVisibility(View.GONE);

            List<MenuBean.PictureListBean> list = data.getPictureList();

            GlideUtils.loadCirclePic(mContext,menuHolder.ivUser01,list.get(0).getUrl());
            GlideUtils.loadCirclePic(mContext,menuHolder.ivUser02,list.get(1).getUrl());
            GlideUtils.loadCirclePic(mContext,menuHolder.ivUser03,list.get(2).getUrl());

        }
    }

    class MenuHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_subName)
        TextView tvSubName;
        @Bind(R.id.iv_normal_img)
        ImageView ivNormalImg;
        @Bind(R.id.iv_user_03)
        ImageView ivUser03;
        @Bind(R.id.iv_user_02)
        ImageView ivUser02;
        @Bind(R.id.iv_user_01)
        ImageView ivUser01;
        @Bind(R.id.re_user_img)
        RelativeLayout userImgLayout;

        public MenuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
