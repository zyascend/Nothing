package com.zyascend.Nothing.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zyascend.Nothing.base.BaseApplication;

/**
 * 功能：获取本机当前的网络状态
 * 作者：zyascend on 2017/5/11 16:55
 * 邮箱：zyascend@qq.com
 */

public class NetWorkUtils {

    /**
     * 判断是否连接到网络
     * @return
     */
    public static boolean available() {
        ConnectivityManager manager = (ConnectivityManager) BaseApplication.application.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return (info != null && info.isAvailable());
    }
}
