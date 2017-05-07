package com.zyascend.Nothing.common;

/**
 * 功能：基础数据回调接口，用于从网络，磁盘获取数据的回调给presenter
 * 作者：zyascend on 2017/5/3 14:55
 * 邮箱：zyascend@qq.com
 */

public interface BaseDataCallback<T> {

    void onSuccess(T data);
    void onFail(String errorMsg);
}
