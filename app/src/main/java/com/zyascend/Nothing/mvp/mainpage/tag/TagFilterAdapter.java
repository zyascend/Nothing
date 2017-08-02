package com.zyascend.Nothing.mvp.mainpage.tag;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.ChildTag;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：
 * 作者：zyascend on 2017/7/15 09:35
 * 邮箱：zyascend@qq.com
 */

public class TagFilterAdapter extends AmazingAdapter<ChildTag> {

    private SparseBooleanArray mSelectRecorder;
    public TagFilterAdapter(Context mContext) {
        super(mContext);
        mSelectRecorder = new SparseBooleanArray();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TagFilterHolder(inflate(R.layout.item_home_tag, parent));
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        TagFilterHolder h = (TagFilterHolder) holder;
        h.bind(dataList.get(position));
    }



    class TagFilterHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_text)
        TextView tvText;

        public TagFilterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.tv_text)
        public void onClick() {
            if (tagClickListener != null){
                tagClickListener.onTagClick(dataList.get(getAdapterPosition()));
            }
            mSelectRecorder.clear();
            mSelectRecorder.put(getAdapterPosition(),true);
            notifyDataSetChanged();
        }

        public void bind(ChildTag childTag) {
            if (childTag == null)return;

            if (mSelectRecorder.get(getAdapterPosition())){
                tvText.setBackground(ContextCompat.getDrawable(mContext,R.drawable.btn_round_orange_bg));
                tvText.setTextColor(Color.WHITE);
            }else {
                tvText.setBackgroundColor(Color.WHITE);
                tvText.setTextColor(Color.GRAY);
            }
            tvText.setText(childTag.getName());
        }
    }

    public void setTagClickListener(TagClickListener tagClickListener) {
        this.tagClickListener = tagClickListener;
    }

    private TagClickListener tagClickListener;

    public interface TagClickListener{
        void onTagClick(ChildTag tag);
    }
}
