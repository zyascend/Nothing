package com.zyascend.Nothing.base;

import android.app.Application;
import android.content.Context;

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
    }

    public static Context getApplication() {
        return application;
    }
}
