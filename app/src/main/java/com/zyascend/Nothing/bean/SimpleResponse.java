package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 13:01
 * 邮箱：zyascend@qq.com
 */

public class SimpleResponse {

    /**
     * MESSAGE : 成功
     * STATUS : 1
     */

    private String MESSAGE;
    private String STATUS;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
