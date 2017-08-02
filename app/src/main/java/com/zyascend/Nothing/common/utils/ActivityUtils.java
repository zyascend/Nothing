package com.zyascend.Nothing.common.utils;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.zyascend.Nothing.base.BaseApplication;
import com.zyascend.Nothing.mvp.grassproduct.GrassActivity;

/**
 * 功能：
 * 作者：zyascend on 2017/6/17 14:47
 * 邮箱：zyascend@qq.com
 */

public class ActivityUtils {
    public static void startActivity(Context context, Class<?> activity){
        Intent intent = new Intent(context,activity);
        context.startActivity(intent);
    }
    public static int pixelToDp( int pixel) {
        DisplayMetrics displayMetrics = BaseApplication.application.getResources().getDisplayMetrics();
        return pixel < 0 ? pixel : Math.round(pixel / displayMetrics.density);
    }
    public static int dpToPixel(int dp) {
        DisplayMetrics displayMetrics = BaseApplication.application.getResources().getDisplayMetrics();
        return dp < 0 ? dp : Math.round(dp * displayMetrics.density);
    }

    public static TextView obtainTextView(String body, Context context) {

        return null;
    }
}
