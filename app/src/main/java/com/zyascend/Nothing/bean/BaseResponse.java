package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/10 09:35
 * 邮箱：zyascend@qq.com
 */

public class BaseResponse {

    public String MESSAGE;
    public String STATUS;

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
