package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 15:46
 * 邮箱：zyascend@qq.com
 */

public class BaseRequsetBody {

    /**
     * appVersion : 1.9.9.2
     * deviceType : android
     * sysVersion : 23
     */

    public String appVersion;
    public String deviceType;
    public String sysVersion;

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }
}
