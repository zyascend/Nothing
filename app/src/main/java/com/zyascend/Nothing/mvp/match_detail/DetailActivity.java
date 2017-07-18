package com.zyascend.Nothing.mvp.match_detail;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseActivity;
import com.zyascend.Nothing.bean.MatchComments;
import com.zyascend.Nothing.bean.MatchDetail;
import com.zyascend.Nothing.bean.ProductAITag;
import com.zyascend.Nothing.bean.RecommendMatch;
import com.zyascend.Nothing.bean.RecommendProduct;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.Nothing.mvp.mainpage.grass.MatchCommentAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：搭配详情页
 * 作者：zyascend on 2017/5/29 20:53
 * 邮箱：zyascend@qq.com
 */

public class DetailActivity extends MVPBaseActivity<DetailContract.View, DetailPresenter>
        implements DetailContract.View {

    private static final String MATCH_ID = "match_id";
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_more)
    ImageView ivMore;
    @Bind(R.id.re_pic)
    RecyclerView rePic;
    @Bind(R.id.tv_lookCount)
    TextView tvLookCount;
    @Bind(R.id.tv_praiseCount)
    TextView tvPraiseCount;
    @Bind(R.id.tv_description)
    TextView tvDescription;
    @Bind(R.id.flex_tag)
    FlexboxLayout flexTag;
    @Bind(R.id.iv_user_img)
    ImageView ivUserImg;
    @Bind(R.id.tv_user_name)
    TextView tvUserName;
    @Bind(R.id.tv_user_info)
    TextView tvUserInfo;
    @Bind(R.id.tv_commentsCount)
    TextView tvCommentsCount;
    @Bind(R.id.re_comment)
    RecyclerView reComment;
    @Bind(R.id.flex_match)
    FlexboxLayout flexMatch;
    @Bind(R.id.re_match)
    RecyclerView reMatch;
    @Bind(R.id.tv_likeCount)
    TextView tvLikeCount;
    @Bind(R.id.tv_collect)
    TextView tvCollect;
    @Bind(R.id.ed_comment)
    EditText edComment;
    @Bind(R.id.iv_remind)
    ImageView ivRemind;
    private MatchDetailAdapter detailAdapter;
    private String matchId;
    private List<ProductAITag> mAiTag;

    @Override
    public void showError() {

    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initView() {

        matchId = getIntent().getStringExtra(MATCH_ID);
        if (TextUtils.isEmpty(matchId)){
            Toast.makeText(this, "id errror", Toast.LENGTH_SHORT).show();
        }

        detailAdapter = new MatchDetailAdapter(this);
        rePic.setAdapter(detailAdapter);
        rePic.setLayoutManager(new LinearLayoutManager(this));

        mPresenter.getDetail(matchId);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_match_detail;
    }

    @Override
    public void onGetDetail(MatchDetail detail) {
        if (detail == null || detail.getMatch() == null){
            showError();
            return;
        }
        MatchDetail.MatchBean match = detail.getMatch();

        detailAdapter.setProdList(match.getProdList());
        detailAdapter.addDatas(match.getPicList(),true);

        tvPraiseCount.setText(match.getPraiseCount()+" 赞");
        tvLookCount.setText(match.getLookCount()+" 浏览");
        tvDescription.setText(match.getDescription());// TODO: 2017/5/30 处理@ 
        
        setTagList(match.getTagList());
        
        MatchDetail.MatchBean.UserBean user = match.getUser();
        setUser(user);

        tvCommentsCount.setText("所有"+match.getCommCount()+"条评论");
        if (match.getMatchComments() != null && !match.getMatchComments().isEmpty()){
            setMatchComment(match.getMatchComments());
        }

        mPresenter.getProdAITags(matchId);
    }

    @Override
    public void onGetProdAiTag(List<ProductAITag> tags) {
        mAiTag = tags;
        if (tags != null && !tags.isEmpty()){
            for (ProductAITag tag : tags){
                TextView tv = new TextView(this);
                tv.setText(tag.getTagLabel());
                tv.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_stroke_bg));
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onAiTagClicked(String.valueOf(((TextView) view).getText()));
                    }
                });
                flexMatch.addView(tv);
            }
        }
        mPresenter.getRecommedMatch(matchId);
    }

    private void onAiTagClicked(String text) {
        if (mAiTag != null && !mAiTag.isEmpty()){
            for (ProductAITag t : mAiTag){
                if (t.getTagLabel().equals(text)){
                    Toast.makeText(this, "跳转"+text, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onGetRecommendProd(List<RecommendProduct> products) {
        if (products != null && !products.isEmpty()){

        }

    }

    @Override
    public void onGetRecommendMatch(List<RecommendMatch> matches) {
        if (matches != null && !matches.isEmpty()){
            RecommendMatchAdapter adapter = new RecommendMatchAdapter(this);
            reMatch.setAdapter(adapter);
            reMatch.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            adapter.addDatas(matches,true);
        }
    }

    private void setMatchComment(List<MatchComments> matchComments) {
        MatchCommentAdapter adapter = new MatchCommentAdapter(this);
        reComment.setAdapter(adapter);
        reComment.setLayoutManager(new LinearLayoutManager(this));
        adapter.addDatas(matchComments,true);
    }

    private void setUser(MatchDetail.MatchBean.UserBean user) {
        GlideUtils.loadCirclePic(this,ivUserImg,user.getHead().getUrl());
        tvUserName.setText(user.getName());
        String info;
        if (user.getHair() != null){
            info = user.getHeight()+"cm/"+user.getHair().getName();
        }else info = user.getHeight()+"cm";
        tvUserInfo.setText(info);
    }

    private void setTagList(List<MatchDetail.MatchBean.TagListBean> tags) {
        if (tags != null && !tags.isEmpty()){
            for (MatchDetail.MatchBean.TagListBean tag : tags){
                TextView tv = new TextView(this);
                tv.setText(tag.getName());
                tv.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_stroke_bg));
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DetailActivity.this, String.valueOf(((TextView) view).getText()), Toast.LENGTH_SHORT).show();
                    }
                });
                flexTag.addView(tv);
            }
        }

    }

    @OnClick({R.id.iv_back, R.id.iv_more, R.id.tv_likeCount, R.id.tv_collect, R.id.iv_remind})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:

                break;
            case R.id.iv_more:

                break;
            case R.id.tv_likeCount:

                break;
            case R.id.tv_collect:

                break;
            case R.id.iv_remind:

                break;
        }
    }
}
