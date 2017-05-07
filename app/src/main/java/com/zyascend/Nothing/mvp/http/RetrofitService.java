package com.zyascend.Nothing.mvp.http;

import android.util.Log;

import com.zyascend.Nothing.base.BaseApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 功能：配置httpclient，构造Retrofit实例
 * 作者：zyascend on 2017/5/3 11:23
 * 邮箱：zyascend@qq.com
 */

public class RetrofitService {

    private static final String BASE_URL = "https://api.nothing.la/nothing/";
    private static API api;

    private static final int DEFAULT_TIMEOUT = 10000;

    public static API getDefault(){
        if (api == null){
            synchronized (RetrofitService.class){
                if (api == null){
                    api = createApi();
                }
            }
        }
        return api;
    }

    private static API createApi() {

        InputStream inputStream=null;

        try {
            inputStream= BaseApplication.getApplication().getAssets().open("nothing_ssl.cer");
        } catch (IOException e) {
            Log.e("OKHTTP", "打开证书失败 ");
            e.printStackTrace();
        }

        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(new InputStream[]{inputStream},null,null);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        okhttp3.Response originalResponse = chain.proceed(request);
                        return originalResponse.newBuilder().header("Accept-Encoding", "gzip").build();
                    }
                })
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslParams.sSLSocketFactory,sslParams.trustManager)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                }).build();
        api = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(API.class);
        return api;
    }

}
