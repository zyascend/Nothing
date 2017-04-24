package com.zyascend.Nothing.common.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 功能：用于切换各种状态的工具类（加载中，出错）
 * 作者：zyascend on 2017/4/24 11:14
 * 邮箱：zyascend@qq.com
 */

public class StatusView {

    private Context mContext;
    private View errorView;
    private View loadingView;


    public StatusView(Builder builder) {
        errorView = builder.errorView;
        loadingView = builder.loadingView;
    }

    public void showError(View needHideView){
        needHideView.setVisibility(View.INVISIBLE);
        errorView.setVisibility(View.VISIBLE);
    }


    public void showLoaing(View needHideView){
        needHideView.setVisibility(View.INVISIBLE);
        loadingView.setVisibility(View.VISIBLE);
    }

    public static class Builder{

        private Context mContext;
        private View errorView;
        private View loadingView;
        private LayoutInflater inflater;

        public Builder(Context context) {
            this.mContext = context;
            this.inflater = LayoutInflater.from(context);
        }

        public Builder setLoadingView(int res){
            this.loadingView = inflater.inflate(res,null);
            loadingView.setVisibility(View.GONE);
            return this;
        }

        public Builder setErrorView(int res){
            this.errorView = inflater.inflate(res,null);
            loadingView.setVisibility(View.GONE);
            return this;
        }

        public StatusView build(){
            return new StatusView(this);
        }


    }


}
