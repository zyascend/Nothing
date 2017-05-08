package com.zyascend.Nothing.base;

import android.app.Application;
import android.content.Context;

import com.zyascend.Nothing.service.InitializeService;

/**
 * Application入口
 * Created by zyascend on 2017/4/22.
 */

public class BaseApplication extends Application {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        InitializeService.start(this);
    }

    public static Context getApplication() {
        return application;
    }
}
