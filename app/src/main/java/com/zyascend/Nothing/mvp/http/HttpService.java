package com.zyascend.Nothing.mvp.http;

import android.text.TextUtils;
import android.util.SparseArray;

import com.orhanobut.logger.Logger;
import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.BaseResponse;
import com.zyascend.Nothing.bean.ChildTag;
import com.zyascend.Nothing.bean.ChildTagMatch;
import com.zyascend.Nothing.bean.GrassProduct;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.HotKeyWordsResponse;
import com.zyascend.Nothing.bean.HotMatch;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.bean.ListData;
import com.zyascend.Nothing.bean.LoginResponse;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.MasterDetail;
import com.zyascend.Nothing.bean.MatchDetail;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.NormalData;
import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.bean.ProdBox;
import com.zyascend.Nothing.bean.ProductAITag;
import com.zyascend.Nothing.bean.ProductMenu;
import com.zyascend.Nothing.bean.RankMaster;
import com.zyascend.Nothing.bean.RankingMatch;
import com.zyascend.Nothing.bean.RankingUser;
import com.zyascend.Nothing.bean.RecommendMatch;
import com.zyascend.Nothing.bean.RecommendProduct;
import com.zyascend.Nothing.bean.SearchTag;
import com.zyascend.Nothing.bean.SiftsBean;
import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.bean.SimpleListResponse;
import com.zyascend.Nothing.bean.UserMatch;
import com.zyascend.Nothing.bean.WearingMatch;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.common.rx.LifeCycleEvent;
import com.zyascend.Nothing.common.rx.RxTransformer;
import com.zyascend.Nothing.common.utils.ActivityUtils;
import com.zyascend.Nothing.common.utils.SharedPreUtils;
import com.zyascend.Nothing.mvp.data.CacheManager;
import com.zyascend.Nothing.mvp.data.DataConstantValue;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import rx.Observable;

import rx.Subscriber;
import rx.functions.Action1;
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
                .registerPushToken(RequestHelper.getAccessToken(),RequestHelper.getRegisterPushTokenBody())
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
                .getMenu(RequestHelper.getAccessToken(),RequestHelper.getMenuBody(6))
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

        boolean jumpCache = firstTime != null;
        Logger.d("jumCache = "+jumpCache);
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

    public void findRankingMatchs(PublishSubject<LifeCycleEvent> subject, String rankingType
            ,String gender,final BaseDataCallback<List<RankingMatch>> callback){
        //只有选择“24小时榜”+无性别要求才会缓存
        boolean jumpCache = (!rankingType.equals("D") || gender!=null);
        Observable<SimpleListResponse<RankingMatch>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_RANKING_MATCH,true,jumpCache);

        Observable<SimpleListResponse<RankingMatch>> fromNet = RetrofitService.getDefault()
                .findRankingMatchs(RequestHelper.getAccessToken(),RequestHelper.getRankingBody(rankingType,gender))
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<RankingMatch>>transform(subject,CACHE_TYPE_RANKING_MATCH));
        Observable.concat(fromCache,fromNet)
                .first()
                .map(new Func1<SimpleListResponse<RankingMatch>, List<RankingMatch>>() {
                    @Override
                    public List<RankingMatch> call(SimpleListResponse<RankingMatch> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<RankingMatch>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<RankingMatch> rankingMatches) {
                        callback.onSuccess(rankingMatches);
                    }
                });
    }

    // TODO: 2017/5/25 body可能有点问题
    public void findRankingUsers(PublishSubject<LifeCycleEvent> subject, String rankingType
            ,String gender,final BaseDataCallback<List<Master>> callback){
        //只有选择“24小时榜”+无性别要求才会缓存
        boolean jumpCache = (!rankingType.equals("D") || gender!=null);
        Observable<SimpleListResponse<Master>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_RANKING_USER,true,jumpCache);

        Observable<SimpleListResponse<Master>> fromNet = RetrofitService.getDefault()
                .findRankingUser(RequestHelper.getAccessToken(),RequestHelper.getRankingBody(rankingType,gender))
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<Master>>transform(subject,CACHE_TYPE_RANKING_USER));
        Observable.concat(fromCache,fromNet)
                .first()
                .map(new Func1<SimpleListResponse<Master>, List<Master>>() {
                    @Override
                    public List<Master> call(SimpleListResponse<Master> data) {
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
                    public void onNext(List<Master> data) {
                        callback.onSuccess(data);
                    }
                });
    }

    public void getCommonMenu(int menuType, PublishSubject<LifeCycleEvent> subject
             , final BaseDataCallback<List<ProductMenu>> callback){
        RetrofitService.getDefault()
                .getCommonMenu(RequestHelper.getAccessToken(),RequestHelper.getMenuBody(menuType))
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<ProductMenu>>transform(subject,null))
                .map(new Func1<SimpleListResponse<ProductMenu>, List<ProductMenu>>() {
                    @Override
                    public List<ProductMenu> call(SimpleListResponse<ProductMenu> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<ProductMenu>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<ProductMenu> menus) {
                        callback.onSuccess(menus);
                    }
                });

    }

    public void findGrassHotProd(PublishSubject<LifeCycleEvent> subject
             , final BaseDataCallback<List<GrassProduct>> callback){
        RetrofitService.getDefault()
                .findGrassHotProdList(RequestHelper.getAccessToken(),RequestHelper.getGrassProdBody())
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<GrassProduct>>>transform(subject,null))
                .map(new Func1<NormalData<ListData<GrassProduct>>, List<GrassProduct>>() {
                    @Override
                    public List<GrassProduct> call(NormalData<ListData<GrassProduct>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<GrassProduct>>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }
                    @Override
                    public void onNext(List<GrassProduct> products) {
                        callback.onSuccess(products);
                    }
                });
    }

    public void findGrassProd(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<GrassProduct>> callback){
        RetrofitService.getDefault()
                .findGrassRecommendProdList(RequestHelper.getAccessToken(),RequestHelper.getGrassProdBody())
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<GrassProduct>>>transform(subject,null))
                .map(new Func1<NormalData<ListData<GrassProduct>>, List<GrassProduct>>() {
                    @Override
                    public List<GrassProduct> call(NormalData<ListData<GrassProduct>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<GrassProduct>>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }
                    @Override
                    public void onNext(List<GrassProduct> products) {
                        callback.onSuccess(products);
                    }
                });
    }

    public void getProdBox(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<ProdBox>> callback){
        RetrofitService.getDefault()
                .getProdBoxList(RequestHelper.getAccessToken(),RequestHelper.getGrassProdBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<ProdBox>>transform(subject,null))
                .map(new Func1<SimpleListResponse<ProdBox>, List<ProdBox>>() {
                    @Override
                    public List<ProdBox> call(SimpleListResponse<ProdBox> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<ProdBox>>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }
                    @Override
                    public void onNext(List<ProdBox> products) {
                        callback.onSuccess(products);
                    }
                });
    }

    public void findWearingProduct(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<WearingMatch>> callback){
        RetrofitService.getDefault()
                .findWearingProduct(RequestHelper.getAccessToken(),RequestHelper.getGrassProdBody())
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<WearingMatch>>>transform(subject,null))
                .map(new Func1<NormalData<ListData<WearingMatch>>, List<WearingMatch>>() {
                    @Override
                    public List<WearingMatch> call(NormalData<ListData<WearingMatch>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<WearingMatch>>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }
                    @Override
                    public void onNext(List<WearingMatch> products) {
                        callback.onSuccess(products);
                    }
                });
    }

    public void findMatchRankByType(String type,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<HotMatch>> callback) {
        RetrofitService.getDefault()
                .findMatchRanklistByType(RequestHelper.getAccessToken(), RequestHelper.getSimpleTypeBody(type))
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<HotMatch>>transform(subject, null))
                .map(new Func1<SimpleListResponse<HotMatch>, List<HotMatch>>() {
                    @Override
                    public List<HotMatch> call(SimpleListResponse<HotMatch> data) {
                        return data.getDATA().getList().subList(0,3);
                    }
                })
                .subscribe(new Subscriber<List<HotMatch>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<HotMatch> matches) {
                        callback.onSuccess(matches);
                    }
                });
    }

    public void findAllRanks(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<RankMaster>> callback) {
        RetrofitService.getDefault()
                .findAllRanklist(RequestHelper.getAccessToken(), RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<RankMaster>>transform(subject, null))
                .map(new Func1<SimpleListResponse<RankMaster>, List<RankMaster>>() {
                    @Override
                    public List<RankMaster> call(SimpleListResponse<RankMaster> data) {
                        return data.getDATA().getList().subList(0,15);
                    }
                })
                .subscribe(new Subscriber<List<RankMaster>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<RankMaster> matches) {
                        callback.onSuccess(matches);
                    }
                });
    }

    public void getDetail(String id,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<MatchDetail> callback){
        RetrofitService.getDefault()
                .getDetail(RequestHelper.getAccessToken(),RequestHelper.getIdBody(id))
                .compose(RxTransformer.INSTANCE.<NormalData<MatchDetail>>transform(subject,null))
                .map(new Func1<NormalData<MatchDetail>, MatchDetail>() {
                    @Override
                    public MatchDetail call(NormalData<MatchDetail> data) {
                        return data.getDATA();
                    }
                })
                .subscribe(new Subscriber<MatchDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(MatchDetail matchDetail) {
                        callback.onSuccess(matchDetail);
                    }
                });

    }



    public void getUser(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<MasterDetail> callback){
        RetrofitService.getDefault()
                .getUser(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<NormalData<MasterDetail>>transform(subject,null))
                .map(new Func1<NormalData<MasterDetail>, MasterDetail>() {
                    @Override
                    public MasterDetail call(NormalData<MasterDetail> data) {
                        return data.getDATA();
                    }
                })
                .subscribe(new Subscriber<MasterDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(MasterDetail master) {
                        callback.onSuccess(master);
                    }
                });

    }

    public void getMaster(String id,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<MasterDetail> callback){
        RetrofitService.getDefault()
                .getMaster(RequestHelper.getAccessToken(),RequestHelper.getIdBody(id))
                .compose(RxTransformer.INSTANCE.<NormalData<MasterDetail>>transform(subject,null))
                .map(new Func1<NormalData<MasterDetail>, MasterDetail>() {
                    @Override
                    public MasterDetail call(NormalData<MasterDetail> data) {
                        return data.getDATA();
                    }
                })
                .subscribe(new Subscriber<MasterDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(MasterDetail master) {
                        callback.onSuccess(master);
                    }
                });

    }

    public void getPraised(String id,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<UserMatch>> callback) {
        RetrofitService.getDefault()
                .getUserPraised(RequestHelper.getAccessToken(), RequestHelper.getIdBody(id))
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<UserMatch>>>transform(subject,null))
                .map(new Func1<NormalData<ListData<UserMatch>>, List<UserMatch>>() {
                    @Override
                    public List<UserMatch> call(NormalData<ListData<UserMatch>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<UserMatch>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<UserMatch> matches) {
                        callback.onSuccess(matches);
                    }
                });
    }

    public void getUserDynamics(String id,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<UserMatch>> callback) {
        RetrofitService.getDefault()
                .getUserDynamic(RequestHelper.getAccessToken(), RequestHelper.getIdBody(id))
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<UserMatch>>>transform(subject,null))
                .map(new Func1<NormalData<ListData<UserMatch>>, List<UserMatch>>() {
                    @Override
                    public List<UserMatch> call(NormalData<ListData<UserMatch>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<UserMatch>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<UserMatch> matches) {
                        callback.onSuccess(matches);
                    }
                });
    }


    public void addFollow(String masterId, PublishSubject<LifeCycleEvent> subject) {
        RetrofitService.getDefault()
                .addFollow(RequestHelper.getAccessToken(), RequestHelper.getIdBody(masterId))
                .compose(RxTransformer.INSTANCE.<NormalData>transform(subject,null))
                .subscribe(new Subscriber<NormalData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NormalData normalData) {
                        if (!normalData.STATUS.equals("1")){
                            Logger.e("follow Fail");
                        }
                    }
                });
    }

    public void cancelFollow(String id, PublishSubject<LifeCycleEvent> subject) {
        RetrofitService.getDefault()
                .cancelFollow(RequestHelper.getAccessToken(), RequestHelper.getIdBody(id))
                .compose(RxTransformer.INSTANCE.<NormalData>transform(subject,null))
                .subscribe(new Subscriber<NormalData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NormalData normalData) {
                        if (!normalData.STATUS.equals("1")){
                            Logger.e("unfollow Fail");
                        }
                    }
                });
    }

    public void getFollowDynamic(String firstTime,PublishSubject<LifeCycleEvent> subject
            ,final BaseDataCallback<SiftsDataBean>  callback){

        boolean jumpCache = firstTime == null;

        Observable<NormalData<SiftsDataBean>> fromCache = CacheManager.getInstance()
                .cacheObservable(CACHE_TYPE_SIFTS,true,jumpCache);
        Observable<NormalData<SiftsDataBean>> fromNet = RetrofitService.getDefault()
                .getFollowDynamic(RequestHelper.getAccessToken(),RequestHelper.getPageLoadBody(firstTime))
                .compose(RxTransformer.INSTANCE.<NormalData<SiftsDataBean>>transform(subject,CACHE_TYPE_FOLLOW_DYNA));

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

    public void getChildTags(String id, PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<List<ChildTag>>> callback) {
        RetrofitService.getDefault()
                .getChildTags(RequestHelper.getAccessToken(), RequestHelper.getIdBody(id))
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<List<ChildTag>>>transform(subject,null))
                .map(new Func1<SimpleListResponse<List<ChildTag>>, List<List<ChildTag>>>() {
                    @Override
                    public List<List<ChildTag>> call(SimpleListResponse<List<ChildTag>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<List<ChildTag>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<List<ChildTag>> childTags) {
                        callback.onSuccess(childTags);
                    }
                });
    }

    public void getDynamicByTags(String mainID, SparseArray<ChildTag> childTags, PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<SiftsBean>> callback){
        RetrofitService.getDefault()
                .getDynamicByTag(RequestHelper.getAccessToken(), RequestHelper.getMultiTagBody(childTags,mainID))
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<ChildTagMatch>>>transform(subject,null))
                .map(new Func1<NormalData<ListData<ChildTagMatch>>, List<SiftsBean>>() {
                    @Override
                    public List<SiftsBean> call(NormalData<ListData<ChildTagMatch>> data) {
                        List<ChildTagMatch> matches = data.getDATA().getList();
                        List<SiftsBean> res = new ArrayList<SiftsBean>();
                        for (ChildTagMatch match : matches){
                            SiftsBean bean = new SiftsBean();
                            bean.setDynamic(new SiftsBean.DynamicBean(match.getId(),match.getMatch()));
                            res.add(bean);
                        }
                        return res;
                    }
                })
                .subscribe(new Subscriber<List<SiftsBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<SiftsBean> been) {
                        callback.onSuccess(been);
                    }
                });
    }
    public void getIdentifyCode(String phone, PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<String> callback){

        RetrofitService.getDefault()
                .getAuthCode(RequestHelper.getAuthCodeBody(phone))
                .compose(RxTransformer.INSTANCE.<BaseResponse>transform(subject,null))
                .map(new Func1<BaseResponse, String>() {
                    @Override
                    public String call(BaseResponse baseResponse) {
                        return baseResponse.getMESSAGE();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        callback.onSuccess(s);
                    }
                });

    }



    public void register(String phone,String passWord,String code
            , PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<String> callback){

        RetrofitService.getDefault()
                .register(RequestHelper.getRegisterBody(phone,passWord,code))
                .compose(RxTransformer.INSTANCE.<BaseResponse>transform(subject,null))
                .map(new Func1<BaseResponse, String>() {
                    @Override
                    public String call(BaseResponse baseResponse) {
                        return baseResponse.getMESSAGE();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        callback.onSuccess(s);
                    }
                });
    }

    public void login(String phone,String password
            , PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<String> callback){

        RetrofitService.getDefault()
                .login(RequestHelper.getLoginBody(phone,password))
                .compose(RxTransformer.INSTANCE.<NormalData<LoginResponse>>transform(subject,null))
                .map(new Func1<NormalData<LoginResponse>, String>() {
                    @Override
                    public String call(NormalData<LoginResponse> data) {
                        //保存AccessToken
                        SharedPreUtils.saveString(SharedPreUtils.KEY_ACCESS_TOKEN,data.getDATA().getAccessToken());
                        return data.getMESSAGE();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        callback.onSuccess(s);
                    }
                });
    }

    public void getRecommendProd(String matchId,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<RecommendProduct>> callback){
        RetrofitService.getDefault()
                .findRecommendProductbyMatch(RequestHelper.getAccessToken(),RequestHelper.getMatchIdBody(matchId))
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<RecommendProduct>>>transform(subject,null))
                .map(new Func1<NormalData<ListData<RecommendProduct>>, List<RecommendProduct>>() {
                    @Override
                    public List<RecommendProduct> call(NormalData<ListData<RecommendProduct>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<RecommendProduct>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<RecommendProduct> recommendProducts) {
                        callback.onSuccess(recommendProducts);
                    }
                });
    }

    public void getRecommendMatch(String matchId,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<RecommendMatch>> callback){
        RetrofitService.getDefault()
                .findRecommendMatchbyMatch(RequestHelper.getAccessToken(),RequestHelper.getMatchIdBody(matchId))
                .compose(RxTransformer.INSTANCE.<NormalData<ListData<RecommendMatch>>>transform(subject,null))
                .map(new Func1<NormalData<ListData<RecommendMatch>>, List<RecommendMatch>>() {
                    @Override
                    public List<RecommendMatch> call(NormalData<ListData<RecommendMatch>> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<RecommendMatch>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<RecommendMatch> recommendProducts) {
                        callback.onSuccess(recommendProducts);
                    }
                });
    }

    public void findProductAITags(String matchId,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<ProductAITag>> callback){
        RetrofitService.getDefault()
                .findProductAITags(RequestHelper.getAccessToken(),RequestHelper.getAItagsBody(matchId))
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<ProductAITag>>transform(subject,null))
                .map(new Func1<SimpleListResponse<ProductAITag>, List<ProductAITag>>() {
                    @Override
                    public List<ProductAITag> call(SimpleListResponse<ProductAITag> data) {
                        return data.getDATA().getList();
                    }
                })
                .subscribe(new Subscriber<List<ProductAITag>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<ProductAITag> recommendProducts) {
                        callback.onSuccess(recommendProducts);
                    }
                });
    }

    public void getSearchHotWord(PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<String>> callback){
        RetrofitService.getDefault()
                .getHotKeyWords(RequestHelper.getAccessToken(),RequestHelper.getSimpleBody())
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<HotKeyWordsResponse>>transform(subject,null))
                .map(new Func1<SimpleListResponse<HotKeyWordsResponse>, List<String>>() {
                    @Override
                    public List<String> call(SimpleListResponse<HotKeyWordsResponse> data) {
                        if (!ActivityUtils.notNullOrEmpty(data.getDATA().getList()))return null;
                        List<String> res = new ArrayList<String>();
                        for (HotKeyWordsResponse word : data.getDATA().getList()){
                            res.add(word.getKey_word());
                        }
                        return res;
                    }
                })
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<String> data) {
                        callback.onSuccess(data);
                    }
                });
    }


    public void getSuggestWords(String input,PublishSubject<LifeCycleEvent> subject
            , final BaseDataCallback<List<String>> callback){
        RetrofitService.getDefault()
                .getSearchProductSuggestList(RequestHelper.getAccessToken(),RequestHelper.getContentBody(input))
                .compose(RxTransformer.INSTANCE.<SimpleListResponse<HotKeyWordsResponse>>transform(subject,null))
                .map(new Func1<SimpleListResponse<HotKeyWordsResponse>, List<String>>() {
                    @Override
                    public List<String> call(SimpleListResponse<HotKeyWordsResponse> data) {
                        if (!ActivityUtils.notNullOrEmpty(data.getDATA().getList()))return null;
                        List<String> res = new ArrayList<String>();
                        for (HotKeyWordsResponse word : data.getDATA().getList()){
                            res.add(word.getKey_word());
                        }
                        return res;
                    }
                })
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(List<String> data) {
                        callback.onSuccess(data);
                    }
                });
    }
}
