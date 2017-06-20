package com.zyascend.Nothing.mvp.user;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseActivity;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.UserMatch;

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
    @Bind(R.id.space_middle)
    Space spaceMiddle;
    @Bind(R.id.tv_follow)
    TextView tvFollow;
    @Bind(R.id.tv_fans)
    TextView tvFans;
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

    @Override
    public void showError() {

    }

    @Override
    public void onGetMaster(Master master) {

    }

    @Override
    public void onGetPraise(List<UserMatch> matches) {

    }

    @Override
    public void onGetDynamic(List<UserMatch> matches) {

    }

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected void initView() {

        //设置recyclerView

        int userType = getIntent().getIntExtra(USER_TYPE,TYPE_CUR_USER);
        if (userType == TYPE_CUR_USER) {
            //当前用户界面

        }else {

        }

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_user;
    }

    @OnClick({R.id.iv_close_card, R.id.iv_head, R.id.iv_back, R.id.iv_card, R.id.iv_share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close_card:

                break;
            case R.id.iv_head:

                break;
            case R.id.iv_back:

                break;
            case R.id.iv_card:

                break;
            case R.id.iv_share:

                break;
        }
    }
}
