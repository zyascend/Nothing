package com.zyascend.Nothing.mvp.login;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseActivity;
import com.zyascend.Nothing.common.utils.ActivityUtils;
import com.zyascend.Nothing.mvp.mainpage.MainActivity;
import com.zyascend.Nothing.mvp.user.UserContract;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：登录界面
 * 作者：zyascend on 2017/4/24 10:28
 * 邮箱：zyascend@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter>
        implements LoginContract.View {


    @Bind(R.id.vp_welcomeViewPager)
    ViewPager vpWelcomeViewPager;
    @Bind(R.id.btn_jumpLogin_down)
    Button btnJumpLoginDown;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.ll_login_register)
    LinearLayout llLoginRegister;
    @Bind(R.id.ed_phoneNum)
    EditText edPhoneNum;
    @Bind(R.id.ed_identifyCode)
    EditText edIdentifyCode;
    @Bind(R.id.tv_getIdentifyCode)
    TextView tvGetIdentifyCode;
    @Bind(R.id.ed_password)
    EditText edPassword;
    @Bind(R.id.tv_forgetPassWord)
    TextView tvForgetPassWord;
    @Bind(R.id.btn_login_register)
    Button btnLoginRegister;
    @Bind(R.id.view_input_login)
    LinearLayout viewInputLogin;
    @Bind(R.id.iv_weChat)
    ImageView ivWeChat;
    @Bind(R.id.iv_weibo)
    ImageView ivWeibo;
    @Bind(R.id.iv_qq)
    ImageView ivQq;
    @Bind(R.id.thirdLoginView)
    LinearLayout thirdLoginView;
    @Bind(R.id.view_login)
    RelativeLayout viewLogin;
    @Bind(R.id.ll_identify_code)
    LinearLayout identifyCodeView;

    private int[] backImageRes;
    private ImagePagerAdapter pagerAdapter;
    private float mPosY;
    private float mCurPosY;
    private int loginBtnHeight;
    private int totalHeight;
    private boolean isBeingDown;
    private String mPhoneNumber;
    private String mPassWord;
    private String mIdCode;
    private int sendTime;

    private Handler timeHandler;

    private Runnable timeRunnable = new Runnable() {
        @Override
        public void run() {
            sendTime--;
            tvGetIdentifyCode.setText(sendTime+getString(R.string.resend));
            if (sendTime>0){
                timeHandler.postDelayed(this,1000);
            }else {
                tvGetIdentifyCode.setEnabled(true);
            }
        }
    };
    private boolean isLoginMode;

    @Override
    protected void initView() {
        //配置ViewPager
        backImageRes = new int[]{R.drawable.welcome1,R.drawable.welcome2,R.drawable.welcome3};
        pagerAdapter = new ImagePagerAdapter();
        vpWelcomeViewPager.setAdapter(pagerAdapter);
        vpWelcomeViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mPosY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mCurPosY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        if (mCurPosY - mPosY > 0
                                && (Math.abs(mCurPosY - mPosY) > 25)) {
                            //向下滑动
                            startScrollDown();
                        }
                        break;
                }
                return true;
            }
        });

    }

    /**
     * 登录框下滑动画
     */
    private void startScrollDown() {
        if (isBeingDown){return;}//当前就在下面，不滑动
        loginBtnHeight = btnLogin.getLayoutParams().height;
        totalHeight = viewLogin.getLayoutParams().height;
        int transY = totalHeight-loginBtnHeight;

        ObjectAnimator down = ObjectAnimator.ofFloat(viewLogin,"translationY",transY);
        down.setDuration(800);
        down.start();

        isBeingDown = true;
    }

    /**
     * 登录框上滑动画
     */
    private void startScrollUp(){
        if (!isBeingDown){return;}//当前在上面，不滑动

        int transY = loginBtnHeight - totalHeight;
        ObjectAnimator down = ObjectAnimator.ofFloat(viewLogin,"translationY",transY);
        down.setDuration(800);
        down.start();

        isBeingDown = false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void showError() {

    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }


    @OnClick({R.id.btn_jumpLogin_down, R.id.btn_login, R.id.btn_register, R.id.tv_getIdentifyCode
            , R.id.tv_forgetPassWord, R.id.btn_login_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_jumpLogin_down:
                ActivityUtils.startActivity(this, MainActivity.class);
                break;
            case R.id.btn_login:
                isLoginMode = true;
                startScrollUp();
                showLoginView();
                break;
            case R.id.btn_register:
                isLoginMode = false;
                startScrollUp();
                showRegisterView();
                break;
            case R.id.tv_getIdentifyCode:
                getIdentifyCode();
                break;
            case R.id.tv_forgetPassWord:
                forgetPassWord();
                break;
            case R.id.btn_login_register:
                if (isLoginMode)startLogin();
                else startRegister();
                break;
        }
    }

    private void startRegister() {
        mPhoneNumber = edPhoneNum.getText().toString();
        mPassWord = edPassword.getText().toString();
        mIdCode = edIdentifyCode.getText().toString();
        if(TextUtils.isEmpty(mPhoneNumber) || mPhoneNumber.length()!=11){
            Toast.makeText(this, "手机号输入有误", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mPassWord) || mPassWord.length()<5){
            Toast.makeText(this, "密码输入有误", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mIdCode) || mIdCode.length()!=5){
            Toast.makeText(this, "验证码输入有误", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.register(mPhoneNumber,mPassWord,mIdCode);
    }

    private void getIdentifyCode() {
        mPhoneNumber = edPhoneNum.getText().toString();
        if(TextUtils.isEmpty(mPhoneNumber) || mPhoneNumber.length()!=11){
            Toast.makeText(this, "手机号输入有误", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.getIdentifyCode(mPhoneNumber);

    }

    private void forgetPassWord() {
        // TODO: 2017/7/16  待完善
    }

    private void startLogin() {
        mPhoneNumber = edPhoneNum.getText().toString();
        mPassWord = edPassword.getText().toString();
        if(TextUtils.isEmpty(mPhoneNumber) || mPhoneNumber.length()!=11){
            Toast.makeText(this, "手机号输入有误", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mPassWord) || mPassWord.length()<5){
            Toast.makeText(this, "密码输入有误", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.login(mPhoneNumber,mPassWord);
    }

    private void showRegisterView() {
        identifyCodeView.setVisibility(View.VISIBLE);
        tvForgetPassWord.setVisibility(View.GONE);
        btnJumpLoginDown.setText(R.string.register);
    }

    private void showLoginView() {
        identifyCodeView.setVisibility(View.GONE);
        tvForgetPassWord.setVisibility(View.VISIBLE);
        btnJumpLoginDown.setText(R.string.login);

    }

    @Override
    public void onSendIdentifyCode(String msg) {
        //发送成功，开始倒计时
        sendTime = 50;
        String curTime = sendTime+"秒后重新发送";
        tvGetIdentifyCode.setText(curTime);
        tvGetIdentifyCode.setEnabled(false);
        timeHandler = new Handler();
        timeHandler.postDelayed(timeRunnable,1000);
    }

    @Override
    public void onRegistered(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogined(String msg) {
        if (TextUtils.equals(msg,getString(R.string.sccuess))){
            //login ok ,jump to main page
            ActivityUtils.startActivity(this,MainActivity.class);
        }else{
            // login failed !!!
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    private class ImagePagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return backImageRes.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView ig = new ImageView(LoginActivity.this);
            ig.getLayoutParams().width = container.getWidth();
            ig.getLayoutParams().height = container.getHeight();
            ig.setImageResource(backImageRes[position]);
            container.addView(ig);
            return ig;
        }
    }
}
