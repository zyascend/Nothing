package com.zyascend.Nothing.mvp.http;

import android.text.TextUtils;

import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.bean.SimpleListResponse;
import com.zyascend.Nothing.bean.SimpleResponse;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.common.LifeCycleEvent;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * 功能：与Presenter直接交互，封装所有http请求
 * 作者：zyascend on 2017/5/3 14:47
 * 邮箱：zyascend@qq.com
 */

public class HttpService {

    private static HttpService SERVICE;
    private HttpService(){}
    private String accessToken = "";

    public static HttpService getInstance(){
        if (SERVICE == null){
            synchronized (HttpService.class){
                if (SERVICE == null){
                    return new HttpService();
                }
            }
        }
        return SERVICE;
    }

    public void getNotice(PublishSubject<LifeCycleEvent> subject,BaseDataCallback<String> callback){
        RetrofitService.getDefault()
                .registerPushToken(RequestHelper.getAccessToken(),RequestHelper.getRegisterBody())
                .flatMap(new Func1<SimpleResponse, Observable<SimpleListResponse<Notice>>>() {
                    @Override
                    public Observable<SimpleListResponse<Notice>> call(SimpleResponse simpleResponse) {
                        //错误处理？？
                        return RetrofitService.getDefault().getNotice();
                    }
                })

    }


}
