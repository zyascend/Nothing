package com.zyascend.Nothing.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.zyascend.Nothing.base.BaseApplication;

/**
 * 功能：SharedPreferrence工具类
 * 作者：zyascend on 2017/7/16 16:02
 * 邮箱：zyascend@qq.com
 */

public class SharedPreUtils {

    private static String tag = SharedPreUtils.class.getSimpleName();
    private final static String SP_NAME = "data";
    private static SharedPreferences sp;
    private static Context context = BaseApplication.application;

    public static final String KEY_ACCESS_TOKEN = "key_access_token";
    public static final String KEY_PUSH_TOKEN = "key_push_token";


    public static void saveBoolean(String key, boolean value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().putBoolean(key, value).apply();
    }


    public static void saveString(String key, String value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().putString(key, value).apply();

    }

    public static void clear() {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().clear().apply();
    }


    public static void saveLong(String key, long value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().putLong(key, value).apply();
    }


    public static void saveInt(String key, int value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().putInt(key, value).apply();
    }


    public static void saveFloat(String key, float value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        sp.edit().putFloat(key, value).apply();
    }


    public static String getString(String key, String defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getString(key, defValue);
    }


    public static int getInt(String key, int defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getInt(key, defValue);
    }


    public static long getLong(String key, long defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getLong(key, defValue);
    }


    public static float getFloat(String key, float defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getFloat(key, defValue);
    }


    public static boolean getBoolean(String key,boolean defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        return sp.getBoolean(key, defValue);
    }
}
