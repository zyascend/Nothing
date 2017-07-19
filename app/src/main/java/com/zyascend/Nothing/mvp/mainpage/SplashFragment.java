package com.zyascend.Nothing.mvp.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.BaseFragment;
import com.zyascend.Nothing.common.utils.GlideUtils;
import com.zyascend.Nothing.common.utils.SharedPreUtils;
import com.zyascend.Nothing.mvp.user.UserActivity;

import org.w3c.dom.Text;

import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：省去MVP模式，直接与model交互，获取开屏信息
 * 每次使用提前加载好的数据
 * 作者：zyascend on 2017/5/8 12:56
 * 邮箱：zyascend@qq.com
 */

public class SplashFragment extends BaseFragment {

    @Bind(R.id.iv_pic)
    ImageView ivPic;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_date)
    TextView tvDate;
    @Bind(R.id.iv_goto)
    ImageView ivGoto;

    private String picUrl;
    private String content;
    private String name;
    private String userID;

    @Override
    protected void loadData() {

    }

    @Override
    protected void initViews() {
        //info 拼接格式：content&图片url&name&userid
        //默认为：null
        final String info = SharedPreUtils.getString(SharedPreUtils.KEY_SPLASH,null);
        if (!TextUtils.isEmpty(info)){
            String[] splahInfo = info.split("&");
            if (splahInfo.length != 4)return;
            picUrl = splahInfo[1];
            content = splahInfo[0];
            name = splahInfo[2];
            userID = splahInfo[3];

            tvDate.setText(content);
            tvName.setText(name);

            ivGoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //tiaozhuan
                    Intent intent = new Intent(getActivity(), UserActivity.class);
                    intent.putExtra(UserActivity.USER_TYPE,userID);
                    startActivity(intent);
                }
            });
            GlideUtils.loadNormalPic(getActivity(),ivPic,picUrl);
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void showError() {

    }

    @Override
    protected void showLoading() {

    }

    @OnClick(R.id.iv_goto)
    public void onClick() {
    }
}
