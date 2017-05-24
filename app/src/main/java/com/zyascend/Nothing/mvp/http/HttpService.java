package com.zyascend.Nothing.mvp.http;

import android.support.design.widget.BaseTransientBottomBar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.BaseResponse;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.bean.ListData;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.NormalData;
import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.bean.RankingUser;
import com.zyascend.Nothing.bean.SearchTag;
import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.bean.SimpleListResponse;
import com.zyascend.Nothing.bean.SimpleResponse;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.common.rx.LifeCycleEvent;
import com.zyascend.Nothing.common.rx.RxTransformer;
import com.zyascend.Nothing.mvp.data.CacheManager;
import com.zyascend.Nothing.mvp.data.DataConstantValue;

import java.util.List;

import okhttp3.RequestBody;
import rx.Observable;

import rx.Subscriber;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * 功能：与Presenter直接交互，封装所有http请求
 * 作者：zyascend on 2017/5/3 14:47
 * 邮箱：zyascend@qq.com
 */

public class HttpService implements DataConstantValue{

    private static final String TAG = "TAG_HttpService";
    private static final String STATUS_OK = "1";
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

    public void getNotice(PublishSubject<LifeCycleEvent> subject, final BaseDataCallback<Notice> callback){
        RetrofitService.getDefault()
                .registerPushToken(RequestHelper.getAccessToken(),RequestHelper.getRegisterBody())
                //处理嵌套请求 先注册pushToken 再请求数据
                .flatMap(new Func1<BaseResponse, Observable<Notice>>() {
                    @Override
                    public Observable<Notice> call(BaseResponse response) {
                        if (!TextUtils.equals(response.getSTATUS(),STATUS_OK))
                            return Observable.error(new APIException(response.getMESSAGE()));

                        return RetrofitService.getDefault()
                                .getNotice(RequestHelper.getAccessToken(),RequestHelper.getNoticeBody());
                    }
                })
                //生命周期控制，线程切换
                .compose(RxTransformer.INSTANCE.<Notice>transform(subject,null))
                //数据预处理
                .subscribe(new Subscriber<Notice>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.toString());
                    }

                    @Override
                    public void onNext(Notice notice) {
                        callback.onSuccess(notice);
                    }
                });

    }

    public void getMyTagList(PublishSubject<LifeCycleEvent> subject, final BaseDataCallback<List<HomeTag>> callback){

        Observable<SimpleListResponse<HomeTag>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_MY_HOME_TAG,true,false);
        Observable<SimpleListResponse<HomeTag>> fromNetWork = RetrofitService.getDefault()
                .getMyTagList(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<HomeTag>>transform(subject,CACHE_TYPE_MY_HOME_TAG));

        Observable.concat(fromCache,fromNetWork)
                .first()
                .map(new Func1<SimpleListResponse<HomeTag>, List<HomeTag>>() {
                    @Override
                    public List<HomeTag> call(SimpleListResponse<HomeTag> response) {
                        return response.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<HomeTag>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<HomeTag> tagList) {
                        callback.onSuccess(tagList);
                    }
                });

    }


    public void getAllTagList(PublishSubject<LifeCycleEvent> subject, final BaseDataCallback<List<HomeTag>> callback){

        Observable<SimpleListResponse<HomeTag>> fromCache
                = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_ALL_HOME_TAG,false,false);
        Observable<SimpleListResponse<HomeTag>> fromNetWork
                = RetrofitService.getDefault()
                .getAllTagList(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<HomeTag>>transform(subject,CACHE_TYPE_ALL_HOME_TAG));

        Observable.concat(fromCache,fromNetWork)
                .first()
                .map(new Func1<SimpleListResponse<HomeTag>, List<HomeTag>>() {
                    @Override
                    public List<HomeTag> call(SimpleListResponse<HomeTag> response) {
                        return response.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<HomeTag>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<HomeTag> tagList) {
                        callback.onSuccess(tagList);
                    }
                });
    }


    public void getBanner(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<BannerBean>> callback) {

        Observable<SimpleListResponse<BannerBean>> fromCache
                = CacheManager.getInstance().cacheObservable(CACHE_TYPE_BANNER,true,false);
        Observable<SimpleListResponse<BannerBean>> fromNetWork
                = RetrofitService.getDefault()
                .getBannerList(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<BannerBean>>transform(subject,CACHE_TYPE_BANNER));
        Observable.concat(fromCache,fromNetWork)
                .first()
                .map(new Func1<SimpleListResponse<BannerBean>, List<BannerBean>>() {
                    @Override
                    public List<BannerBean> call(SimpleListResponse<BannerBean> response) {
                        return response.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<BannerBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<BannerBean> bannerBeen) {
                        callback.onSuccess(bannerBeen);
                    }
                });

    }

    public void getMenu(PublishSubject<LifeCycleEvent> subject, final BaseDataCallback<List<MenuBean>> callback){
        Observable<SimpleListResponse<MenuBean>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_MENU,true,false);
        Observable<SimpleListResponse<MenuBean>> fromNet = RetrofitService.getDefault()
                .getMenu(RequestHelper.getAccessToken(),RequestHelper.getMenuBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<MenuBean>>transform(subject,CACHE_TYPE_MENU));
        Observable.concat(fromCache,fromNet)
                .first()
                .map(new Func1<SimpleListResponse<MenuBean>, List<MenuBean>>() {
                    @Override
                    public List<MenuBean> call(SimpleListResponse<MenuBean> response) {
                        return response.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<MenuBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<MenuBean> menuBeen) {
                        callback.onSuccess(menuBeen);
                    }
                });

    }

    public void getRankingUser(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<RankingUser>> callback){
        Observable<SimpleListResponse<RankingUser>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_RANKUSER,true,false);
        Observable<SimpleListResponse<RankingUser>> fromNet = RetrofitService.getDefault()
                .getRankingUserList(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<RankingUser>>transform(subject,CACHE_TYPE_RANKUSER));
        Observable.concat(fromCache,fromNet)
                .first()
                .map(new Func1<SimpleListResponse<RankingUser>, List<RankingUser>>() {
                    @Override
                    public List<RankingUser> call(SimpleListResponse<RankingUser> response) {
                        return response.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<RankingUser>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<RankingUser> list) {
                        callback.onSuccess(list);
                    }
                });
    }

    public void getSifts(String firstTime
            , PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<SiftsDataBean> callback){

        boolean jumpCache = firstTime == null;

        Observable<NormalData<SiftsDataBean>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_SIFTS,true,jumpCache);
        Observable<NormalData<SiftsDataBean>> fromNet = RetrofitService.getDefault()
                .getSiftsList(RequestHelper.getAccessToken(),RequestHelper.getPageLoadBody(firstTime))
                .compose(RxTransformer.INSTANCE.<NormalData<SiftsDataBean>>transform(subject,CACHE_TYPE_SIFTS));

        Observable.concat(fromCache,fromNet)
                .first()
                .map(new Func1<NormalData<SiftsDataBean>, SiftsDataBean>() {
                    @Override
                    public SiftsDataBean call(NormalData<SiftsDataBean> data) {
                        return data.getDATA();
                    }
                })
                .subscribe(new Subscriber<SiftsDataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(SiftsDataBean siftsDataBean) {

                        callback.onSuccess(siftsDataBean);
                    }
                });

    }

    public void findMasterListByTags(int startRow, List<SearchTag> selectedTag, PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<Master>> callback){
        boolean jumpCache = (startRow == 0 && selectedTag == null);


        Observable<NormalData<ListData<Master>>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_SEARCH_MASTER,true,jumpCache);

        RequestBody body = RequestHelper.getTagBody(startRow,selectedTag);

        Observable<NormalData<ListData<Master>>> fromNet = RetrofitService.getDefault()
                .findMasterListByTags(RequestHelper.getAccessToken(),body)
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<Master>>>transform(subject,CACHE_TYPE_SEARCH_MASTER));
        Observable.concat(fromCache,fromNet)
                .first()
                .map(new Func1<NormalData<ListData<Master>>, List<Master>>() {
                    @Override
                    public List<Master> call(NormalData<ListData<Master>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<Master>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Master> masters) {
                        callback.onSuccess(masters);
                    }
                });


    }

    public void getHotTags(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<HotTag>> callback){
        Observable<SimpleListResponse<HotTag>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_SEARCH_TAG,true,false);

        Observable<SimpleListResponse<HotTag>> fromNet = RetrofitService.getDefault()
                .getHotTagList(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<HotTag>>transform(subject,CACHE_TYPE_SEARCH_TAG));

        Observable.concat(fromCache,fromNet)
                .first()
                .map(new Func1<SimpleListResponse<HotTag>, List<HotTag>>() {
                    @Override
                    public List<HotTag> call(SimpleListResponse<HotTag> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<HotTag>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<HotTag> hotTags) {
                        callback.onSuccess(hotTags);
                    }
                });

    }

    public void findTagListForSearchUser(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<List<SearchTag>>> callback){

        Observable<SimpleListResponse<List<SearchTag>>> fromCache = CacheManager.getInstance()
                .cacheObservable(DataConstantValue.CACHE_TYPE_FILTER_TAG,false,false);

        Observable<SimpleListResponse<List<SearchTag>>> fromNet = RetrofitService.getDefault()
                .findTagListForSearchUser(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<List<SearchTag>>>transform(subject,CACHE_TYPE_FILTER_TAG));

        Observable.concat(fromCache,fromNet)
                .first()
                .map(new Func1<SimpleListResponse<List<SearchTag>>, List<List<SearchTag>>>() {
                    @Override
                    public List<List<SearchTag>> call(SimpleListResponse<List<SearchTag>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<List<SearchTag>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<List<SearchTag>> lists) {
                        callback.onSuccess(lists);
                    }
                });


    }

}
