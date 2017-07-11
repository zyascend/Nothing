package com.zyascend.Nothing.mvp.user;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseActivity;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.MasterDetail;
import com.zyascend.Nothing.bean.UserMatch;
import com.zyascend.Nothing.common.utils.GlideUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：
 * 作者：zyascend on 2017/6/19 22:14
 * 邮箱：zyascend@qq.com
 */

public class UserActivity extends MVPBaseActivity<UserContract.View, UserPresenter>
        implements UserContract.View {

    public static final String USER_TYPE = "USER_TYPE";
    private static final int TYPE_CUR_USER = 0;
    private static final int TYPE_MASTER = 1;
    private static final int STATE_BOOK = 1;
    private static final int STATE_POST = 0;
    private static final int STATE_LIKED = 2;
    @Bind(R.id.iv_card_pic)
    ImageView ivCardPic;
    @Bind(R.id.iv_close_card)
    ImageView ivCloseCard;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_info)
    TextView tvInfo;
    @Bind(R.id.tv_fans)
    TextView tvFans;
    @Bind(R.id.ll_card_info)
    LinearLayout llCardInfo;
    @Bind(R.id.tv_user_name)
    TextView tvUserName;
    @Bind(R.id.tv_user_job)
    TextView tvUserJob;
    @Bind(R.id.tv_user_des)
    TextView tvUserDes;
    @Bind(R.id.tv_follow)
    TextView tvUserFollow;
    @Bind(R.id.tv_fans)
    TextView tvUserFans;
    @Bind(R.id.tv_action_follow)
    TextView tvActionFollow;
    @Bind(R.id.tv_post)
    TextView tvPost;
    @Bind(R.id.tv_book)
    TextView tvBook;
    @Bind(R.id.tv_liked)
    TextView tvLiked;
    @Bind(R.id.ll_tab)
    LinearLayout llTab;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.tv_contact)
    TextView tvContact;
    @Bind(R.id.iv_head)
    ImageView ivHead;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_card)
    ImageView ivCard;
    @Bind(R.id.iv_share)
    ImageView ivShare;
    @Bind(R.id.re_userToolBar)
    RelativeLayout reUserToolBar;

    private UserAdapater adapater;
    private String userId;
    private boolean followed;
    private int select_state;

    @Override
    public void showError() {

    }

    @Override
    public void onGetMaster(MasterDetail master) {
        GlideUtils.loadCirclePic(this, ivHead, master.getHead().getUrl());
        tvUserName.setText(master.getName());
        tvUserFans.setText(master.getFansNum() + "粉丝");
        tvUserFollow.setText(master.getAttentionNum() + "关注");
        tvPost.setText("发布 " + master.getMatchNum());
        tvBook.setText("BOOK " + master.getMagazineNum());
        tvLiked.setText("赞过 " + master.getPraiseNum());

        String coverUrl = master.getCover().getUrl();
        if (!TextUtils.isEmpty(coverUrl)){
            GlideUtils.loadNormalPic(this, ivCardPic,coverUrl);
        }else {
            ivCardPic.setBackgroundColor(Color.BLACK);
        }

        tvName.setText(master.getName());
        tvFans.setText(master.getAttentionNum()+"关注" + "  "+master.getFansNum()+"粉丝");


    }

    @Override
    public void onGetPraise(List<UserMatch> matches) {
        if (matches == null || matches.isEmpty())return;
        adapater.addDatas(matches,true);
    }

    @Override
    public void onGetDynamic(List<UserMatch> matches) {
        if (matches == null || matches.isEmpty())return;
        adapater.addDatas(matches,true);
    }

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected void initView() {

        //设置recyclerView
        adapater = new UserAdapater(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapater);

        userId = getIntent().getStringExtra(USER_TYPE);
        if (TextUtils.isEmpty(userId)) {
            //当前用户界面
            mPresenter.getUser();
        } else {
            mPresenter.getMaster(userId);
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_user;
    }

    @OnClick({R.id.iv_close_card, R.id.iv_head, R.id.iv_back,
            R.id.iv_card, R.id.iv_share,R.id.tv_action_follow
            ,R.id.tv_post,R.id.tv_liked,R.id.tv_book})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close_card:
                llCardInfo.setVisibility(View.GONE);
                ivCloseCard.setVisibility(View.GONE);

                reUserToolBar.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_head:
                // TODO: 2017/7/10
                break;
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_card:
                llCardInfo.setVisibility(View.VISIBLE);
                ivCloseCard.setVisibility(View.VISIBLE);

                reUserToolBar.setVisibility(View.GONE);
                scrollView.setVisibility(View.GONE);
                break;
            case R.id.iv_share:
                // TODO: 2017/7/10  share

                break;
            case R.id.tv_action_follow:
                if (!followed){
                    mPresenter.fallowMaster(userId);
                    tvActionFollow.setBackgroundResource(R.drawable.btn_round_orange_bg);
                    tvActionFollow.setTextColor(Color.WHITE);
                    tvActionFollow.setText("已关注");
                    followed = true;
                }else{
                    mPresenter.cancelFollow(userId);
                    tvActionFollow.setBackgroundResource(R.drawable.btn_stroke_bg);
                    tvActionFollow.setTextColor(Color.parseColor("#fe644a"));
                    tvActionFollow.setText("关注");
                    followed = false;
                }
                break;
            case R.id.tv_book:
                if (select_state != STATE_BOOK){
                    recyclerView.setVisibility(View.GONE);
                    select_state = STATE_BOOK;
                }
                break;
            case R.id.tv_post:
                if (select_state != STATE_POST){
                    mPresenter.getDynamics(userId);
                    select_state = STATE_POST;

                }
                break;
            case R.id.tv_liked:
                if (select_state != STATE_LIKED){
                    mPresenter.getPraised(userId);
                    select_state = STATE_LIKED;
                }
                break;
        }
    }

}
