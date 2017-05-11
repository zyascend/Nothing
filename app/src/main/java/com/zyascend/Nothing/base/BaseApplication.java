package com.zyascend.Nothing.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.zyascend.Nothing.service.InitializeService;

/**
 * Application入口
 * Created by zyascend on 2017/4/22.
 */

public class BaseApplication extends Application {

    public static Context application;
    private static final String TAG = "BaseApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        application = this;
        InitializeService.start(this);
    }
}
