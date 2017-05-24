package com.zyascend.Nothing.mvp.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.base.BaseApplication;
import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.BaseResponse;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.bean.ListData;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.NormalData;
import com.zyascend.Nothing.bean.RankingUser;
import com.zyascend.Nothing.bean.SearchTag;
import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.bean.SimpleListResponse;
import com.zyascend.Nothing.common.utils.NetWorkUtils;
import com.zyascend.Nothing.dao.CacheBean;
import com.zyascend.Nothing.dao.CacheBeanDao;
import com.zyascend.Nothing.dao.DaoMaster;
import com.zyascend.Nothing.dao.DaoSession;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 功能：缓存管理类（singleTon）
 * 作者：zyascend on 2017/5/10 23:21
 * 邮箱：zyascend@qq.com
 */

public class CacheManager implements DataConstantValue{

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

    public <T extends BaseResponse>Observable<T> cacheObservable(final String cacheType
            , final boolean checkTime,final boolean jumpCache){
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                if (jumpCache){
                    //跳过缓存,适用于加载列表中加载更多的情况
                    Logger.d("跳过了"+cacheType+"缓存");
                    subscriber.onCompleted();
                    return;
                }

                T cache = getCache(cacheType,checkTime);
                if (cache == null){
                    Logger.d("未获取到"+cacheType+"缓存");
                    subscriber.onCompleted();
                }else {
                    Logger.d("获取到"+cacheType+"缓存，发送数据......");
                    subscriber.onNext(cache);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private <T> T getCache(String type, boolean checkTime) {
        CacheBeanDao dao = daoSession.getCacheBeanDao();
        CacheBean cacheBean = dao.queryBuilder()
                .where(CacheBeanDao.Properties.Cache_type.eq(type))
                .build().unique();
        if (cacheBean == null)return null;

        //网络可用条件下，过期的缓存不展示
        //无网络状态下，有则展示
        if (checkTime && cacheBean.isExpire() && NetWorkUtils.available())
            return null;

        T data = null;
        try {
            //这种方法式并不优雅，可扩展性差，但也没办法了
            //1.JSON.parseObject(json,new TypeReference<T>()) 扑街
            //2.尝试获取泛型T的 T.class 扑街
            //只能根据cachetype给出一个明确的Class，再强转类型
            data = parseData(cacheBean.getJson_content(),type);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e(e.getMessage());
        }
        return data;
    }

    private <T> T parseData(String json, String type) {
        /**
         * 这个方法，不忍直视，shitttttt！！！
         */
        T data = null;
        switch (type){
            case CACHE_TYPE_MY_HOME_TAG :
            case CACHE_TYPE_ALL_HOME_TAG:
                data = (T) JSON.parseObject(json,new TypeReference<SimpleListResponse<HomeTag>>(){});
                break;
            case CACHE_TYPE_BANNER:
                data = (T) JSON.parseObject(json,new TypeReference<SimpleListResponse<BannerBean>>(){});
                break;
            case CACHE_TYPE_MENU:
                data = (T) JSON.parseObject(json,new TypeReference<SimpleListResponse<MenuBean>>(){});
                break;
            case CACHE_TYPE_RANKUSER:
                data = (T) JSON.parseObject(json,new TypeReference<SimpleListResponse<RankingUser>>(){});
                break;
            case CACHE_TYPE_SIFTS:
                data = (T) JSON.parseObject(json,new TypeReference<NormalData<SiftsDataBean>>(){});
                break;
            case CACHE_TYPE_SEARCH_MASTER:
                data = (T)JSON.parseObject(json,new TypeReference<NormalData<ListData<Master>>>(){});
                break;
            case CACHE_TYPE_SEARCH_TAG:
                data = (T) JSON.parseObject(json,new TypeReference<SimpleListResponse<HotTag>>(){});
                break;
            case CACHE_TYPE_FILTER_TAG:
                data = (T) JSON.parseObject(json,new TypeReference<SimpleListResponse<List<SearchTag>>>(){});
                break;
        }
        return data;
    }

    public <T> void saveCache(String type,T t){

        if (type == null)return;
        CacheBeanDao dao = daoSession.getCacheBeanDao();

        try {
            String json = JSON.toJSONString(t);
            Log.d(TAG, "saveCache: json = "+json);
            if (!TextUtils.isEmpty(json)){
                CacheBean bean = new CacheBean(type,json);
                dao.insertOrReplace(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "saveCache: e = "+e.toString());
        }
    }

}
