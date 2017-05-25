package com.zyascend.Nothing.mvp.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.MultiAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/25 09:59
 * 邮箱：zyascend@qq.com
 */

public class SearchMasterAdapter extends MultiAdapter<Master> {



    public SearchMasterAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void bindCommonView(RecyclerView.ViewHolder holder, int position, int viewType) {
        MasterHolder masterHolder = (MasterHolder) holder;
        masterHolder.bindData(dataList.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder createCommonHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follow_user, parent, false);
        return new MasterHolder(view);
    }

    private class MasterHolder extends RecyclerView.ViewHolder {

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

        public MasterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        public void bindData(Master master) {
            GlideUtils.loadCirclePic(mContext,ivUserImg,master.getHead().getUrl());
            tvUserName.setText(master.getName());

            String info = "";
            if (master.getArea() != null)
                info = info + master.getArea().getName()+"/";
            info += master.getName();
            if (master.getHair()!=null)
                info = "/"+info+master.getHair().getName();
            tvUserInfo.setText(info);

            if (master.getDynamics() == null && master.getDynamics().size() != 3)
                return;

            String url1 = master.getDynamics().get(0).getMatch().getPicture().getUrl();
            GlideUtils.loadRoundPic(mContext,ivPic1,url1);

            String url2 = master.getDynamics().get(1).getMatch().getPicture().getUrl();
            GlideUtils.loadRoundPic(mContext,ivPic2,url2);

            String url3 = master.getDynamics().get(2).getMatch().getPicture().getUrl();
            GlideUtils.loadRoundPic(mContext,ivPic3,url3);


        }
    }
}
