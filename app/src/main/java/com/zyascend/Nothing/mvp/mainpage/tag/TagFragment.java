package com.zyascend.Nothing.mvp.mainpage.tag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.MVPBaseFragment;
import com.zyascend.Nothing.mvp.mainpage.MainContract;

/**
 * 功能：
 * 作者：zyascend on 2017/5/22 10:09
 * 邮箱：zyascend@qq.com
 */

public class TagFragment extends MVPBaseFragment<MainContract.TagView,TagPresenter> {

    private static final String TAG_ID = "TAG_Id";
    private String currentId;

    public static TagFragment getInstance(String id) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ID,id);
        TagFragment fragment = new TagFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentId = getArguments().getString(TAG_ID);
        Log.d(TAG, "onCreate: 当前ID是"+currentId);
    }

    @Override
    protected void loadData() {
        Toast.makeText(mActivity, "当前ID是"+currentId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tag;
    }

    @Override
    protected void showError() {

    }

    @Override
    protected void showLoading() {

    }

    @Override
    protected TagPresenter initPresenter() {
        return new TagPresenter();
    }

}
