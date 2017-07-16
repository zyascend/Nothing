package com.zyascend.Nothing.mvp.http;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zyascend.Nothing.base.BaseApplication;
import com.zyascend.Nothing.bean.ChildTag;
import com.zyascend.Nothing.bean.SearchTag;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 功能：用于构建各种请求的参数
 * 作者：zyascend on 2017/5/8 22:32
 * 邮箱：zyascend@qq.com
 * 注 ：这种构造请求体的方法有可读性差的缺点，实际项目中禁止使用
 * 正确方法：根据内容生成对象，再转化为jsonString
 */

public class RequestHelper {
    private static final String TYPE_JSON = "application/json";
    private static final String TAG = "TAG_RequestHelper";
    private static final String simpleBdy = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"sysVersion\":\"23\"}";

    public static String getAccessToken(){
        return "18a480ba87d04e1daac69cc540922703";
    }

    public static RequestBody getRegisterPushTokenBody() {
        //{"appVersion":"","deviceType":"android","pushToken":"13065ffa4e386063e87","sysVersion":"23"}
        StringBuilder sb = new StringBuilder();
        sb.append("{\"appVersion\":\"\",\"deviceType\":\"android\",\"pushToken\":\"");
        sb.append(getPushToken());
        sb.append("\",\"sysVersion\":\"23\"}");
        return RequestBody.create(MediaType.parse(TYPE_JSON), sb.toString());
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
        return RequestBody.create(MediaType.parse(TYPE_JSON),def);
    }

    public static RequestBody getSimpleBody() {
        return RequestBody.create(MediaType.parse(TYPE_JSON),simpleBdy);
    }

    public static RequestBody getMenuBody(int menuType) {
        String json = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"isPage\":false,\"limit\"" +
                ":0,\"menuType\":"
                + menuType
                + ",\"sourceType\":0,\"startRow\":0,\"sysVersion\":\"23\"}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }

    public static RequestBody getPageLoadBody(String firstTime) {

        if (firstTime == null){
            //这是第一次加载数据
            String json = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"isFirstRegister\"" +
                    ":false,\"startRow\":\"0\",\"sysVersion\":\"23\"}";
            return RequestBody.create(MediaType.parse(TYPE_JSON),json);
        }else{
            String json = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"isFirstRegister\":false,\"startRow\":\"15\",\"startTime\"" +
                    ":\""+firstTime+"\",\"sysVersion\":\"23\"}";
            return RequestBody.create(MediaType.parse(TYPE_JSON),json);
        }
    }


    public static RequestBody getStartRowBody(int startRow) {
        String json = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"startRow\":"
                +startRow+",\"sysVersion\":\"23\"}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }

    public static RequestBody getTagBody(int startRow, List<SearchTag> selectedTag) {
        String json;
        if (selectedTag == null){
            json = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"startRow\":"
                    +startRow+",\"sysVersion\":\"23\"}";
        }else {
            json = "{\"appVersion\":\"1.9.9.2\",\"childTagIds\":"
                    + JSON.toJSONString(selectedTag)
                    + ",\"deviceType\":\"android\",\"startRow\":0,\"sysVersion\":\"23\"}";
        }
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }

    public static RequestBody getRankingBody(String rankingType, String gender) {
        String json = "";
        if (gender == null){
            json = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"isFirstRegister\":false,\"rankingType\":\""
                    +rankingType
                    +"\",\"sysVersion\":\"23\",\"userId\":\""
                    +getUserId()
                    +"\"}";
        }else {
            json = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"gender\":\""
                    +gender
                    +"\",\"isFirstRegister\":false,\"rankingType\":\""
                    +rankingType
                    +"\",\"sysVersion\":\"23\",\"userId\":\""
                    +getUserId()
                    +"\"}";
        }
        //
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }

    private static String getUserId() {
        return "0236b7681e8848d39259d494b6507c05";
    }

    public static RequestBody getGrassProdBody() {
        String json = "{\"appVersion\":\"1.9.9.2\",\"deviceType\":\"android\",\"priceSort\":0,\"sourceType\":0,\"startRow\":0,\"sysVersion\":\"23\"}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }


    public static RequestBody getSimpleTypeBody(String type) {
        String json = "{\"appVersion\":\"2.0.4\",\"deviceType\":\"android\",\"sysVersion\":\"23\",\"type\":\""
                + type
                + "\"}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }

    public static RequestBody getIdBody(String id) {
        String json = "{\"appVersion\":\"2.0.4\",\"deviceType\":\"android\",\"id\":\""
                + id
                + "\",\"sysVersion\":\"23\"}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }

    public static RequestBody getByIdBody(String id) {
        String json = "{\"appVersion\":\"2.0.4\",\"deviceType\":\"android\",\"byUserId\":\""
                + id
                + "\",\"sysVersion\":\"23\"}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }

    public static RequestBody getMultiTagBody(List<ChildTag> childTags,String mainId) {
        String tags = childTags.toString();
        String body = "{\"appVersion\":\"2.0.4\",\"childTagIds\":"
                + tags
                + ",\"deviceType\":\"android\",\"mainTagId\":"
                + mainId
                + ",\"startRow\":0,\"sysVersion\":\"23\"}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),body);
    }

    public static RequestBody getRegisterBody(String phone, String passWord, String code) {
        String json = "{\"appVersion\":\"2.0.4\",\"authCode\":\""
                + code +
                "\",\"deviceType\":\"android\",\"isEncrypt\":true,\"password\":\""
                + getMd5(passWord) +
                "\",\"phone\":\""
                + phone +
                "\",\"pushToken\":\""
                + getPushToken() +
                "\",\"sysVersion\":\"23\"}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }

    public static RequestBody getAuthCodeBody(String phone) {
        String json = "{\"appVersion\":\"2.0.4\",\"deviceType\":\"android\",\"phone\":\"" +
                phone +
                "\",\"sysVersion\":\"23\",\"type\":1}";
        return RequestBody.create(MediaType.parse(TYPE_JSON),json);
    }
}
