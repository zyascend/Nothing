package com.zyascend.Nothing.mvp.http;

/**
 * 功能：自定义网络请求异常类
 * 作者：zyascend on 2017/5/10 09:27
 * 邮箱：zyascend@qq.com
 */

public class APIException extends Exception {
    public APIException(String message) {
        super(message);
    }
}
