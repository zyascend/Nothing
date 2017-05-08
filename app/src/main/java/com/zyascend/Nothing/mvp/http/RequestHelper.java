package com.zyascend.Nothing.mvp.http;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.zyascend.Nothing.base.BaseApplication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 功能：用于构建各种请求的参数
 * 作者：zyascend on 2017/5/8 22:32
 * 邮箱：zyascend@qq.com
 */

public class RequestHelper {
    private static final String JSON = "application/json";

    public static String getAccessToken(){
        return "18a480ba87d04e1daac69cc540922703";
    }

    public static RequestBody getRegisterBody() {
        //{"appVersion":"","deviceType":"android","pushToken":"13065ffa4e386063e87","sysVersion":"23"}
        StringBuilder sb = new StringBuilder();
        sb.append("{\"appVersion\":\"\",\"deviceType\":\"android\",\"pushToken\":\"");
        sb.append(getPushToken());
        sb.append("\",\"sysVersion\":\"23\"");
        return RequestBody.create(MediaType.parse(JSON), sb.toString());
    }

    /**
     * 通过设备的IMEI码
     * @return
     */
    private static String getPushToken() {
        TelephonyManager manager = (TelephonyManager) BaseApplication.getApplication()
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = manager.getDeviceId();
        String md5 = getMd5(deviceId);
        return md5;
    }

    private static String getMd5(String deviceId) {
        MessageDigest md = null;//SHA 或者 MD5
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // TODO: 2017/5/8
        BASE64Encoder base = new BASE64Encoder ();
        String pwdAfter = base.encode(md.digest(pwd.getBytes()));
        return pwdAfter;
    }
}
