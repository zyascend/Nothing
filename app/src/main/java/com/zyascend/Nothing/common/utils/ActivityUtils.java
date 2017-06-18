package com.zyascend.Nothing.common.utils;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

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
}
