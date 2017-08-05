package com.zyascend.Nothing.common.utils;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.BaseApplication;
import com.zyascend.Nothing.mvp.grassproduct.GrassActivity;

import java.util.Collection;
import java.util.List;

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
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText(body);
        textView.setTextSize(12);
        textView.setTextColor(ContextCompat.getColor(context, R.color.orange_dark));
        textView.setBackgroundResource(R.drawable.btn_stroke_bg);
        int padding = ActivityUtils.dpToPixel(4);
        int paddingLeftAndRight = ActivityUtils.dpToPixel(8);
        ViewCompat.setPaddingRelative(textView, paddingLeftAndRight, padding, paddingLeftAndRight, padding);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = ActivityUtils.dpToPixel(6);
        int marginTop = ActivityUtils.dpToPixel(10);
        layoutParams.setMargins(margin, marginTop, margin, 0);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public static boolean notNullOrEmpty(Collection collection) {
        if (collection != null && !collection.isEmpty())return true;
        return false;
    }
}
