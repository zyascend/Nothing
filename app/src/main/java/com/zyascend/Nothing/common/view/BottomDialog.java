package com.zyascend.Nothing.common.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.zyascend.Nothing.R;

/**
 * 功能：底部弹出菜单栏
 * 作者：zyascend on 2017/7/11 16:14
 * 邮箱：zyascend@qq.com
 */

public class BottomDialog extends DialogFragment {

    private static final String TAG = "default_dialog";

    private static final String KEY_LAYOUT_RES = "bottom_layout_res";
    private static final String KEY_HEIGHT = "bottom_height";
    private static final String KEY_DIM = "bottom_dim";
    private static final String KEY_CANCEL_OUTSIDE = "bottom_cancel_outside";

    private static final float DEFAULT_DIM = 0.2f;
    private FragmentManager mFragmentManager;

    @LayoutRes
    private int mLayoutRes;

    private ViewListener mViewListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BottomDialog);
//        if (savedInstanceState != null) {
//            mLayoutRes = savedInstanceState.getInt(KEY_LAYOUT_RES);
//            mHeight = savedInstanceState.getInt(KEY_HEIGHT);
//            mDimAmount = savedInstanceState.getFloat(KEY_DIM);
//            mIsCancelOutside = savedInstanceState.getBoolean(KEY_CANCEL_OUTSIDE);
//        }
    }


//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        outState.putInt(KEY_LAYOUT_RES, mLayoutRes);
//        outState.putInt(KEY_HEIGHT, mHeight);
//        outState.putFloat(KEY_DIM, mDimAmount);
//        outState.putBoolean(KEY_CANCEL_OUTSIDE, mIsCancelOutside);
//
//        super.onSaveInstanceState(outState);
//    }

    @Override
    public void onStart() {
        super.onStart();

        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();

        params.dimAmount = getDimAmount();

        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.BOTTOM;

        window.setAttributes(params);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);
        View v = inflater.inflate(getLayoutRes(), container, false);
        bindView(v);
        return v;
    }

    private void bindView(View v) {
        if (mViewListener != null) {
            mViewListener.bindView(v);
        }
    }

    public static BottomDialog create(FragmentManager manager) {
        BottomDialog dialog = new BottomDialog();
        dialog.setFragmentManager(manager);
        return dialog;
    }

    public BottomDialog setViewListener(ViewListener listener) {
        mViewListener = listener;
        return this;
    }

    private BottomDialog setFragmentManager(FragmentManager manager) {
        mFragmentManager = manager;
        return this;
    }

    private int getLayoutRes() {
        return mLayoutRes;
    }

    public BottomDialog setLayoutRes(@LayoutRes int layoutRes) {
        mLayoutRes = layoutRes;
        return this;
    }

    public float getDimAmount() {
        return DEFAULT_DIM;
    }

    public String getFragmentTag() {
        return TAG;
    }

    public BottomDialog show(){
        show(mFragmentManager, getFragmentTag());
        return this;
    }

    public interface ViewListener {
        void bindView(View v);
    }


}
