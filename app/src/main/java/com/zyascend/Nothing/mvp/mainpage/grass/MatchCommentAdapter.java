package com.zyascend.Nothing.mvp.mainpage.grass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.SiftsBean;
import com.zyascend.amazingadapter.AmazingAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 功能：
 * 作者：zyascend on 2017/5/23 22:35
 * 邮箱：zyascend@qq.com
 */

public class MatchCommentAdapter
        extends AmazingAdapter<SiftsBean.DynamicBean.MatchBean.MatchCommentsBean> {

    public MatchCommentAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match_comment, parent, false);
        return new MatchCommentHolder(view);
    }

    @Override
    protected void bindView(RecyclerView.ViewHolder holder, int position) {
        MatchCommentHolder matchCommentHolder = (MatchCommentHolder) holder;
        matchCommentHolder.bind(dataList.get(position));
    }

    private class MatchCommentHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_comments)
        TextView tvComments;
        public MatchCommentHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(SiftsBean.DynamicBean.MatchBean.MatchCommentsBean comments) {
            // TODO: 2017/5/23 待处理： 1.用户名高亮 2.表情
            String content = "";
            if (comments.getReplyUser()!=null){
                content = comments.getUser().getName()+"回复"+comments.getReplyUser().getName()
                        + ": "+comments.getContent();
            }else {
                content = comments.getUser().getName()+": "+comments.getContent();
            }
            tvComments.setText(content);
        }
    }
}
