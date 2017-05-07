package com.zyascend.Nothing.mvp.http;

import com.zyascend.Nothing.common.BaseDataCallback;

/**
 * 功能：与Presenter直接交互，封装所有http请求
 * 作者：zyascend on 2017/5/3 14:47
 * 邮箱：zyascend@qq.com
 */

public class HttpService {

    private static HttpService SERVICE;
    private HttpService(){}

    public HttpService getInstance(){
        if (SERVICE == null){
            synchronized (HttpService.class){
                if (SERVICE == null){
                    return new HttpService();
                }
            }
        }
        return SERVICE;
    }

    public void getNotice(BaseDataCallback<String> callback){


    }


}
