package com.zyascend.Nothing.mvp.match_detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.MatchDetail;
import com.zyascend.amazingadapter.AmazingAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/30 15:39
 * 邮箱：zyascend@qq.com
 */
public class MatchDetailAdapter extends AmazingAdapter<MatchDetail.MatchBean.PicListBean> {

    @Bind(R.id.iv_pic)
    ImageView ivPic;
    private List<MatchDetail.MatchBean.ProdListBean> prodList;

    public MatchDetailAdapter(Context context) {
        super(context);
    }

    public void setProdList(List<MatchDetail.MatchBean.ProdListBean> prods){
        this.prodList = prods;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match_detail, parent, false);
        return new DetailHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        DetailHolder myHolder = (DetailHolder) holder;
        myHolder.bindData(dataList.get(position));
    }


    class DetailHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_pic)
        ImageView ivPic;

        public DetailHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindData(MatchDetail.MatchBean.PicListBean data) {
            if (data == null) return;
            float ratio = data.getHeight()/data.getWidth();
            int width = ivPic.getWidth() == 0
                    ? mContext.getResources().getDisplayMetrics().widthPixels : ivPic.getWidth();
            int height = (int) (width*ratio);

            Glide.with(mContext)
                    .load(data.getUrl())
                    .centerCrop()
                    .override(width,height)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(ivPic);

            if (getAdapterPosition() == 0 && prodList != null){
                for(MatchDetail.MatchBean.ProdListBean prod : prodList){
                    setProds(prod);
                }
            }
        }

        private void setProds(MatchDetail.MatchBean.ProdListBean prod) {

        }
    }
}