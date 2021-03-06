package com.zyascend.Nothing.mvp.mainpage.grass;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.bean.MatchComments;
import com.zyascend.Nothing.bean.SiftsBean;
import com.zyascend.Nothing.common.utils.ActivityUtils;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.Nothing.common.view.SpanTextView;
import com.zyascend.Nothing.mvp.match_detail.DetailActivity;
import com.zyascend.amazingadapter.MultiAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        @Bind(R.id.flexBox)
        FlexboxLayout flexboxLayout;
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
        private String matchId;

        public SiftsHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(Context context, SiftsBean siftsBean) {

            if (siftsBean == null || siftsBean.getType() == 6 || siftsBean.getDynamic() == null
                    ||siftsBean.getDynamic().getMatch() == null) return;

            matchId = siftsBean.getDynamic().getId();

            final SiftsBean.DynamicBean.MatchBean data = siftsBean.getDynamic().getMatch();

            String headUrl = data.getUser().getHead().getUrl();
            GlideUtils.loadCirclePic(context,ivUserImg,headUrl);

            tvName.setText(data.getUser().getName());
            tvTime.setText(data.getShowTime());

            tvUserInfo.setText(appendUserInfo(data));

            String des = data.getDescription();
            if (data.getRemindUsers()!=null && !data.getRemindUsers().isEmpty()){
                final List<SiftsBean.DynamicBean.MatchBean.RemindUsersBean> list = data.getRemindUsers();
                for (SiftsBean.DynamicBean.MatchBean.RemindUsersBean reminder : list){
                    String user = "@"+reminder.getName();
                    des+=user;
                }
                tvDescription.setText(des);
            }

            String picUrl = data.getPicture().getUrl();
            GlideUtils.loadRoundPic(context,ivPicture,picUrl);
            tvPicNum.setText(data.getPictureCount()+"张");

            fillFlexBox(data);

            tvLookCount.setText(data.getLookCount()+" 浏览");
            tvLikeCount.setText(data.getPraiseCount()+" 赞");
            tvCommentsCount.setText("全部共"+data.getCommCount()+"条评论");

            if(data.getMatchComments()!=null && !data.getMatchComments().isEmpty()){
                bindComments(data.getMatchComments());
            }

        }

        @OnClick(R.id.iv_picture)
        public void onClick() {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra(DetailActivity.MATCH_ID,matchId);
            mContext.startActivity(intent);
        }

        private void fillFlexBox(SiftsBean.DynamicBean.MatchBean data) {
            if (data.getSiftTag() == null)return;
            String siftTag = data.getSiftTag().getName();
            flexboxLayout.addView(obtainTextView(siftTag));
            if (data.getProdList() != null && !data.getProdList().isEmpty()){
                StringBuilder sb;
                for (SiftsBean.DynamicBean.MatchBean.ProdListBean product : data.getProdList()){
                     sb = new StringBuilder();
                     sb.append(product.getCategoryName());
                     sb.append(":");
                     sb.append(product.getBrandName());
                     flexboxLayout.addView(obtainTextView(sb.toString()));
                }
            }
            String body = data.getHeight()+"cm"+data.getWeight()+"kg";
            flexboxLayout.addView(obtainTextView(body));
        }

        private TextView obtainTextView(String content) {

            TextView textView = new TextView(mContext);
            textView.setGravity(Gravity.CENTER);
            textView.setText(content);
            textView.setTextSize(12);
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.orange_dark));
            textView.setBackgroundResource(R.drawable.btn_stroke_bg);
//            textView.setTag();
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            int padding = ActivityUtils.dpToPixel(4);
            int paddingLeftAndRight = ActivityUtils.dpToPixel(8);
            ViewCompat.setPaddingRelative(textView, paddingLeftAndRight, padding, paddingLeftAndRight, padding);
            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            int margin = ActivityUtils.dpToPixel(6);
            int marginTop = ActivityUtils.dpToPixel(10);
            layoutParams.setMargins(margin, marginTop, margin, 0);
            textView.setLayoutParams(layoutParams);
            return textView;
        }

        private void jumpToUser(String reminder, List<SiftsBean.DynamicBean.MatchBean.RemindUsersBean> list) {
            for (SiftsBean.DynamicBean.MatchBean.RemindUsersBean user : list){
                if (TextUtils.equals(reminder,user.getName())){
                    // TODO: 2017/5/23 处理跳转逻辑
                    Logger.d(reminder+"clicked!!!");
                    break;
                }
            }
        }

        private String appendUserInfo(SiftsBean.DynamicBean.MatchBean data) {
            if (data.getUser().getHair()!=null && data.getUser().getArea()!=null)
                return data.getUser().getArea().getName()+"/"+data.getUser().getHair().getName()
                +"/"+data.getUser().getHeight();
            else return data.getUser().getHeight();
        }

        private void bindComments(List<MatchComments> comments) {
            MatchCommentAdapter adapter = new MatchCommentAdapter(mContext);
            listComments.setAdapter(adapter);
            listComments.setLayoutManager(new LinearLayoutManager(mContext));
            adapter.addDatas(comments,true);
        }
    }


}
