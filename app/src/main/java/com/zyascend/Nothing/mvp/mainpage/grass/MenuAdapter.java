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
import com.zyascend.Nothing.common.utils.ActivityUtils;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.Nothing.mvp.grassproduct.GrassActivity;
import com.zyascend.Nothing.mvp.masterwearing.MasterWearActivity;
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
        final MenuHolder menuHolder = (MenuHolder) holder;
        menuHolder.bind(dataList.get(position));
        menuHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (menuHolder.getAdapterPosition()){
                    case 0:
                        ActivityUtils.startActivity(mContext,GrassActivity.class);
                        break;
                    case 1:
                        ActivityUtils.startActivity(mContext, MasterWearActivity.class);
                        break;
                    case 2:
                        //功能布局一致的界面，忽略
                        break;
                    case 3:
                        //功能布局一致的界面，忽略
                        break;
                }
            }
        });
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

        public void bind(MenuBean data){
            if (data == null)return;
            tvName.setText(data.getName());
            tvSubName.setText(data.getSubName());
            if (1 == data.getPicType()){

                userImgLayout.setVisibility(View.GONE);
                ivNormalImg.setVisibility(View.VISIBLE);
                GlideUtils.loadNormalPic(mContext,ivNormalImg,data.getPicture().getUrl());
            }else {
                userImgLayout.setVisibility(View.VISIBLE);
                ivNormalImg.setVisibility(View.GONE);

                List<MenuBean.PictureListBean> list = data.getPictureList();

                GlideUtils.loadCirclePic(mContext,ivUser01,list.get(0).getUrl());
                GlideUtils.loadCirclePic(mContext,ivUser02,list.get(1).getUrl());
                GlideUtils.loadCirclePic(mContext,ivUser03,list.get(2).getUrl());

            }
        }
    }
}
