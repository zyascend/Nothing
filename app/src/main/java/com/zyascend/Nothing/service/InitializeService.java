package com.zyascend.Nothing.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.zyascend.Nothing.base.BaseApplication;

/**
 * 功能：负责应用启动前第三方SDK的初始化工作
 * 作者：zyascend on 2017/5/8 11:05
 * 邮箱：zyascend@qq.com
 */

public class InitializeService extends IntentService {

    private static final String ACTION_INIT_SDK = "com.zyascend.Nothing.INIT_SDK";

    public InitializeService() {
        super("InitializeService");
    }

    /**
     * 启动IntentService
     * @param app
     */
    public static void start(Context app) {
        Intent intent = new Intent(app,InitializeService.class);
        intent.setAction(ACTION_INIT_SDK);
        app.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent == null)return;
        if(TextUtils.equals(ACTION_INIT_SDK,intent.getAction())){
            init();
        }
    }

    /**
     * 初始化操作
     */
    private void init() {

    }
}
