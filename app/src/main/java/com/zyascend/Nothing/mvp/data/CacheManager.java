package com.zyascend.Nothing.mvp.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zyascend.Nothing.base.BaseApplication;
import com.zyascend.Nothing.bean.BaseResponse;
import com.zyascend.Nothing.dao.CacheBean;
import com.zyascend.Nothing.dao.CacheBeanDao;
import com.zyascend.Nothing.dao.DaoMaster;
import com.zyascend.Nothing.dao.DaoSession;

import junit.framework.Test;

import java.lang.reflect.ParameterizedType;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 功能：缓存管理类（singleTon）
 * 作者：zyascend on 2017/5/10 23:21
 * 邮箱：zyascend@qq.com
 */

public class CacheManager {

    private static final String TAG = "TAG_CacheManager";
    private static CacheManager manager;
    private static DaoSession daoSession;

    private CacheManager(){
        Context context = BaseApplication.application;
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "NoBoring.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }

    public static CacheManager getInstance(){
        if (manager == null){
            synchronized (CacheManager.class){
                if (manager == null){
                    manager = new CacheManager();
                }
            }
        }
        return manager;
    }

    public <T extends BaseResponse>Observable<T> cacheObservable(final String cacheType,final boolean checkTime){
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                T cache = getCache(cacheType,checkTime);
                if (cache == null){
                    subscriber.onCompleted();
                }else {
                    subscriber.onNext(cache);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private <T extends BaseResponse> T getCache(String type, boolean checkTime) {
        CacheBeanDao dao = daoSession.getCacheBeanDao();
        CacheBean cacheBean = dao.queryBuilder()
                .where(CacheBeanDao.Properties.Cache_type.eq(type))
                .build().unique();
        if (cacheBean == null)return null;
        if (checkTime && cacheBean.isExpire())return null;
        T data = null;
        try {
            Class <T> tClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            data = JSON.parseObject(cacheBean.getJson_content(),tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public <T extends BaseResponse> void saveCache(String type,T t){

        if (type == null)return;
        CacheBeanDao dao = daoSession.getCacheBeanDao();

        try {
            String json = JSON.toJSONString(t);
            if (!TextUtils.isEmpty(json)){
                CacheBean bean = new CacheBean(type,json);
                dao.insertOrReplace(bean);
                Log.d(TAG, "saveCache: ------->done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
