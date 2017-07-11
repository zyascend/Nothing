package com.zyascend.Nothing.mvp.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.UserMatch;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/7/10 14:51
 * 邮箱：zyascend@qq.com
 */

public class UserAdapater extends AmazingAdapter<UserMatch> {



    public UserAdapater(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one_pic, parent, false);
        return new UserHolder(v);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        UserHolder userHolder = (UserHolder) holder;
        userHolder.bindData(dataList.get(position));
    }

    class UserHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_pic)
        ImageView ivPic;

        public UserHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);
        }

        public void bindData(UserMatch match) {
            if (match == null)return;
            String url = match.getMatch().getPicture().getUrl();
            GlideUtils.loadNormalPic(mContext,ivPic,url);
        }
    }
}
