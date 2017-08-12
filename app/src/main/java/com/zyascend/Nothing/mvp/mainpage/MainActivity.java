package com.zyascend.Nothing.mvp.mainpage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.BaseActivity;
import com.zyascend.Nothing.common.utils.ActivityUtils;
import com.zyascend.Nothing.common.utils.SharedPreUtils;
import com.zyascend.Nothing.mvp.login.LoginActivity;
import com.zyascend.Nothing.mvp.rank.RankBaseFragment;
import com.zyascend.Nothing.mvp.rank.RankFragment;
import com.zyascend.Nothing.mvp.search.SearchFragment;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：主界面的框架Activity，切换四大fragment（首页，搜索，排名，个人）
 * 作者：zyascend on 2017/5/1 12:39
 * 邮箱：zyascend@qq.com
 */

public class MainActivity extends BaseActivity {
    private static final String TAG_HOME = "tag_home";
    private static final String TAG_SEARCH = "tag_search";
    private static final String TAG_RANK = "tag_rank";
    /**
     *
     */
    @Bind(R.id.iv_home)
    ImageView ivHome;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.iv_upload)
    ImageView ivUpload;
    @Bind(R.id.iv_rank)
    ImageView ivRank;
    @Bind(R.id.iv_profile)
    ImageView ivProfile;
//    @Bind(R.id.content_viewstub)
    ViewStub viewStub;

    /**
     * 当前tab的选择
     */
    private int selected = 0;

    private HomeFragment homeFragment;
    private SplashFragment splashFragment;
    private Handler mHandler;
    private SearchFragment searchFragment;
    private RankBaseFragment rankFragment;
    private boolean logined;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {

        viewStub = (ViewStub) findViewById(R.id.content_viewstub);
        mHandler = new Handler();
        //首先加载并显示SplashFragment
        FragmentManager manager = getSupportFragmentManager();
        splashFragment = new SplashFragment();
        manager.beginTransaction()
                .replace(R.id.splash_frame,splashFragment)
                .commit();

        //当窗体加载完成，加载主布局
        //getWindow().getDecorView().post(new LoadMainTask());
        logined = !TextUtils.isEmpty(SharedPreUtils.getString(SharedPreUtils.KEY_ACCESS_TOKEN,null));
        if (logined){
            loadMainPageFragment();
        }

        //开启延时显示SplashFragment的内容，同时ManiPage加载数据
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                mHandler.postDelayed(new DelayRunnable(MainActivity.this,splashFragment,logined),2000);
            }
        });

    }

    private static class DelayRunnable implements Runnable{

        private final boolean logined;
        private WeakReference<Context> contextRef;
        private WeakReference<SplashFragment> fragmentRef;

        DelayRunnable(Context context, SplashFragment f, boolean logined) {
            contextRef = new WeakReference<Context>(context);
            fragmentRef = new WeakReference<SplashFragment>(f);
            this.logined = logined;
        }

        @Override
        public void run() {
            // 移除splash页面
            if(contextRef!=null){
                SplashFragment splashFragment = fragmentRef.get();
                if(splashFragment==null){
                    return;
                }
                AppCompatActivity activity = (AppCompatActivity)contextRef.get() ;
                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.remove(splashFragment);
                transaction.commit();
                if (!logined){
                    ActivityUtils.startActivity(activity, LoginActivity.class);
                }
            }
        }
    }

    private void loadMainPageFragment() {

        viewStub.inflate();
        ButterKnife.bind(MainActivity.this);

        //初次启动默认选择home界面
        ivHome.setImageResource(R.drawable.home_fill);

        if (savedState == null){
            //初始化各个Fragment
            //初次创建
            homeFragment = new HomeFragment();
            searchFragment = new SearchFragment();
            rankFragment = new RankBaseFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentFrame,homeFragment,TAG_HOME)
                    .add(R.id.fragmentFrame,searchFragment,TAG_SEARCH)
                    .add(R.id.fragmentFrame,rankFragment,TAG_RANK)
                    .hide(searchFragment)
                    .hide(rankFragment)
                    .show(homeFragment)
                    .commit();
        }else {
            //异常情况下被销毁后的恢复
            FragmentManager manager = getSupportFragmentManager();
            homeFragment = (HomeFragment) manager.findFragmentByTag(TAG_HOME);
            searchFragment = (SearchFragment) manager.findFragmentByTag(TAG_SEARCH);
            rankFragment = (RankBaseFragment) manager.findFragmentByTag(TAG_RANK);
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main_frame;
    }

    /**
     * 需要延迟绑定
     * @return
     */
    @Override
    public boolean canBind() {
        return false;
    }

    @OnClick({R.id.iv_home, R.id.iv_search, R.id.iv_upload, R.id.iv_rank, R.id.iv_profile})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                if (selected!=0){
                    getSupportFragmentManager().beginTransaction()
                            .show(homeFragment)
                            .hide(getShowFragment())
                            .commit();
                    selected = 0;
                    toggleImageResource();
                }
                break;
            case R.id.iv_search:
                if (selected!=1){
                    getSupportFragmentManager().beginTransaction()
                            .show(searchFragment)
                            .hide(getShowFragment())
                            .commit();
                    selected = 1;
                    toggleImageResource();
                }
                break;
            case R.id.iv_upload:
                onUploadClick();
                break;
            case R.id.iv_rank:
                if (selected!=3){
                    getSupportFragmentManager().beginTransaction()
                            .show(rankFragment)
                            .hide(getShowFragment())
                            .commit();
                    selected = 3;
                    toggleImageResource();
                }
                break;
            case R.id.iv_profile:
                if (selected!=4){


                    selected = 4;
                    toggleImageResource();
                }
                break;
        }
    }

    private Fragment getShowFragment() {
        switch (selected){
            case 0:
                return homeFragment;
            case 1:
                return searchFragment;
            case 3:
                return rankFragment;
            case 4:
                return null;
        }
        return null;
    }

    private void toggleImageResource() {
        ivHome.setImageResource(R.drawable.home_stroke);
        ivSearch.setImageResource(R.drawable.search_stroke);
        ivRank.setImageResource(R.drawable.rank_stroke);
        ivProfile.setImageResource(R.drawable.profile_stroke);
        switch (selected){
            case 0:
                ivHome.setImageResource(R.drawable.home_fill);
                break;
            case 1:
                ivSearch.setImageResource(R.drawable.main_tab_search_on);
                break;
            case 3:
                ivRank.setImageResource(R.drawable.main_tab_rank_on);
                break;
            case 4:
                ivProfile.setImageResource(R.drawable.profile_fill);
                break;
        }
    }

    private void onUploadClick() {

    }
}
