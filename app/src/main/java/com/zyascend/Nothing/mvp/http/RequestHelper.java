package com.zyascend.Nothing.mvp.http;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zyascend.Nothing.base.BaseApplication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 功能：用于构建各种请求的参数
 * 作者：zyascend on 2017/5/8 22:32
 * 邮箱：zyascend@qq.com
 */

public class RequestHelper {
    private static final String JSON = "application/json";
    private static final String TAG = "TAG_RequestHelper";
    private static final String simpleBdy = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"sysVersion\":\"23\"}";

    public static String getAccessToken(){
        return "18a480ba87d04e1daac69cc540922703";
    }

    public static RequestBody getRegisterBody() {
        //{"appVersion":"","deviceType":"android","pushToken":"13065ffa4e386063e87","sysVersion":"23"}
        StringBuilder sb = new StringBuilder();
        sb.append("{\"appVersion\":\"\",\"deviceType\":\"android\",\"pushToken\":\"");
        sb.append(getPushToken());
        sb.append("\",\"sysVersion\":\"23\"}");
        return RequestBody.create(MediaType.parse(JSON), sb.toString());
    }

    /**
     * 通过设备的IMEI码
     * @return
     */
    private static String getPushToken() {
        TelephonyManager manager = (TelephonyManager) BaseApplication.application
                .getSystemService(Context.TELEPHONY_SERVICE);
        // TODO: 2017/5/10 要开启动态权限
        //String deviceId = manager.getDeviceId();
        return getMd5("864587029619922");
    }


    public static String getMd5(String data){
        Log.d(TAG, "getMd5: origin = ------>"+data);
        MessageDigest md = null;
        String res = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            StringBuilder buf = new StringBuilder();
            byte[] bits = md.digest();
            for(int i=0;i<bits.length;i++){
                int a = bits[i];
                if(a<0) a+=256;
                if(a<16) buf.append("0");
                buf.append(Integer.toHexString(a));
            }
            res = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getMd5: after =------->"+res);
        return res;
    }

    public static RequestBody getNoticeBody() {
        String def = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"lastLetterNumId\":-1,\"lastOtherNumId\":-1,\"lastSysNumId\":-1,\"sysVersion\":\"23\"}";
        return RequestBody.create(MediaType.parse(JSON),def);
    }

    public static RequestBody getSimpleBody() {
        return RequestBody.create(MediaType.parse(JSON),simpleBdy);
    }
}
