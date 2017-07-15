 package com.zyascend.Nothing.mvp.http;

import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.BaseResponse;
import com.zyascend.Nothing.bean.ChildTag;
import com.zyascend.Nothing.bean.ChildTagMatch;
import com.zyascend.Nothing.bean.GrassProduct;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.HotMatch;
import com.zyascend.Nothing.bean.HotTag;
import com.zyascend.Nothing.bean.ListData;
import com.zyascend.Nothing.bean.Master;
import com.zyascend.Nothing.bean.MasterDetail;
import com.zyascend.Nothing.bean.MatchDetail;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.NormalData;
import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.bean.ProdBox;
import com.zyascend.Nothing.bean.ProductMenu;
import com.zyascend.Nothing.bean.RankMaster;
import com.zyascend.Nothing.bean.RankingMatch;
import com.zyascend.Nothing.bean.RankingUser;

import com.zyascend.Nothing.bean.SearchTag;
import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.bean.SimpleListResponse;
import com.zyascend.Nothing.bean.UserBean;
import com.zyascend.Nothing.bean.UserMatch;
import com.zyascend.Nothing.bean.WearingMatch;


import java.util.List;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 12:27
 * 邮箱：zyascend@qq.com
 */

public interface API {

    String ACCESS_TOKEN = "accessToken";

    /**
     * 获取未读消息
     * url=https://api.nothing.la/nothing/v2/user/getNotice.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body:{"appVersion":"1.9.9.2","deviceType":"android","lastLetterNumId":-1,"lastOtherNumId":-1,"lastSysNumId":-1,"sysVersion":"23"}
     */
    @POST("v2/user/getNotice.do")
    Observable<Notice> getNotice(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 注册pushToken
     * url=https://api.nothing.la/nothing/registerPushToken.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body:{"appVersion":"","deviceType":"android","pushToken":"13065ffa4e386063e87","sysVersion":"23"}
     */
    @POST("registerPushToken.do")
    Observable<BaseResponse> registerPushToken(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 获取用户首页tab数据
     * url=https://api.nothing.la/nothing/v2_1/tag/findMyList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body：{"appVersion":"1.9.9.2","deviceType":"android","sysVersion":"23"}
     */
    @POST("v2_1/tag/findMyList.do")
    Observable<SimpleListResponse<HomeTag>> getMyTagList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);


    /**
     * 获取全部tab类型数据
     * url= https://api.nothing.la/nothing/tag/common/findList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body：simple版
     */
    @POST("tag/common/findList.do")
    Observable<SimpleListResponse<HomeTag>> getAllTagList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 获取人气榜
     * url=https://api.nothing.la/nothing/v1_9_8/rankinglist/common/findRankingUserList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body={"appVersion":"1.9.9.2","deviceType":"android","sysVersion":"23"}
     */
    @POST("v1_9_8/rankinglist/common/findRankingUserList.do")
    Observable<SimpleListResponse<RankingUser>> getRankingUserList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 获取当前用户信息
     * url=https://api.nothing.la/nothing/user/getUser.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body=simple版
     */
    @POST("user/getUser.do")
    Observable<NormalData<MasterDetail>> getUser(@Query(ACCESS_TOKEN)String accessToken,@Body RequestBody body);

    /**
     * 获取其他用户信息
     * https://api.nothing.la/nothing/user/common/getUser.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"2.0.4","deviceType":"android","id":"2b791ec33785403a983333a99648f9b8","sysVersion":"23"}
     */
    Observable<NormalData<MasterDetail>> getMaster(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     *获取banner数据
     * url=https://api.nothing.la/nothing/banner/common/findList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body:simple ver
     */
    @POST("banner/common/findList.do")
    Observable<SimpleListResponse<BannerBean>> getBannerList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 获取首页菜单数据
     * url=https://api.nothing.la/nothing/v1_9_2/menu/common/findList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body：{"appVersion":"1.9.9.2","deviceType":"android","isPage":false,"limit":0,"menuType":6,"sourceType":0,"startRow":0,"sysVersion":"23"}
     */
    @POST("v1_9_2/menu/common/findList.do")
    Observable<SimpleListResponse<MenuBean>> getMenu(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 获取sifts数据
     * url=https://api.nothing.la/nothing/v1_9/sift/getSifts.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body = {"appVersion":"1.9.9.2","deviceType":"android","isFirstRegister":false,"startRow":"0","sysVersion":"23"}
     */
    @POST("v1_9/sift/getSifts.do")
    Observable<NormalData<SiftsDataBean>> getSiftsList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 获取hottag
     * url = https://api.nothing.la/nothing/v1_7/tag/common/findHotListByFind.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body={"appVersion":"1.9.9.2","deviceType":"android","sysVersion":"23"}
     */
    @POST("v1_7/tag/common/findHotListByFind.do")
    Observable<SimpleListResponse<HotTag>> getHotTagList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * search页面
     * https://api.nothing.la/nothing/v1_9_8/tag/findMasterListByTags.do?accessToken=18a480ba87d04e1daac69cc540922703
     * 首次,默认：{"appVersion":"1.9.9.2","deviceType":"android","startRow":0,"sysVersion":"23"}
     * 下一页：{"appVersion":"1.9.9.2","deviceType":"android","startRow":30,"sysVersion":"23"}
     * "startRow":30 = pagesize
     * 筛选：{"appVersion":"1.9.9.2","childTagIds":[{"id":"40a23ab1bebb4ba2b2efcfbd0a56a62a","line":1,"name":"日系"},{"id":"26f98c66c5184c8e94d64ebe6007c0e2","line":2,"name":"155-159cm"}],"deviceType":"android","startRow":0,"sysVersion":"23"}
     */
    @POST("v1_9_8/tag/findMasterListByTags.do")
    Observable<NormalData<ListData<Master>>> findMasterListByTags(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * https://api.nothing.la/nothing/v1_9_8/tag/findTagListForSearchUser.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body simple Ver
     */
    @POST("v1_9_8/tag/findTagListForSearchUser.do")
    Observable<SimpleListResponse<List<SearchTag>>> findTagListForSearchUser(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * rank
     * match
     * https://api.nothing.la/nothing/dynamic/common/findRankingList.do?accessToken=18a480ba87d04e1daac69cc540922703
     *{"appVersion":"1.9.9.2","deviceType":"android","gender":"1","isFirstRegister":false,"rankingType":"D","sysVersion":"23","userId":"0236b7681e8848d39259d494b6507c05"}
     * gender 性别
     * type 24小时榜
     */
    @POST("dynamic/common/findRankingList.do")
    Observable<SimpleListResponse<RankingMatch>> findRankingMatchs(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * rank-user
     * https://api.nothing.la/nothing/user/common/findRankingList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"1.9.9.2","deviceType":"android","rankingType":"D","startRow":0,"sysVersion":"23"}
     */
    @POST("user/common/findRankingList.do")
    Observable<SimpleListResponse<Master>> findRankingUser(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 竹编推荐-menu
     * https://api.nothing.la/nothing/v1_9_2/menu/common/findList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"1.9.9.2","deviceType":"android","isPage":false,"limit":0,"menuType":2,"sourceType":0,"startRow":0,"sysVersion":"23"}
     */
    @POST("v1_9_2/menu/common/findList")
    Observable<SimpleListResponse<ProductMenu>> getCommonMenu(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 主编推荐-人气单品
     * https://api.nothing.la/nothing/v1_9_2/grass/common/findGrassHotProdList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"1.9.9.2","deviceType":"android","priceSort":0,"sourceType":0,"startRow":0,"sysVersion":"23"}
     */
    @POST("v1_9_2/grass/common/findGrassHotProdList.do")
    Observable<NormalData<ListData<GrassProduct>>> findGrassHotProdList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 主编推荐-推荐单品
     * https://api.nothing.la/nothing/v1_9_2/grass/common/findGrassRecommendProdList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"1.9.9.2","deviceType":"android","priceSort":0,"sourceType":0,"startRow":0,"sysVersion":"23"}
     */
    @POST("v1_9_2/grass/common/findGrassRecommendProdList.do")
    Observable<NormalData<ListData<GrassProduct>>> findGrassRecommendProdList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 主编推荐-推荐品牌
     * https://api.nothing.la/nothing/v1_8/productBox/common/getProdBoxList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"1.9.9.2","boxType":2,"deviceType":"android","sourceType":0,"startRow":0,"sysVersion":"23"}
     */
    @POST("v1_8/productBox/common/getProdBoxList.do")
    Observable<SimpleListResponse<ProdBox>> getProdBoxList(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);


    /**
     * 博主都在穿-推荐单品
     * https://api.nothing.la/nothing/v1_9_5/dynamic/common/findRecommendProdListByType.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"2.0.3","deviceType":"android","queryType":1,"startRow":0,"sysVersion":"23"}
     */
    @POST("v1_9_5/dynamic/common/findRecommendProdListByType.do")
    Observable<NormalData<ListData<WearingMatch>>> findWearingProduct(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);


    /**
     * 博主人气榜
     * https://api.nothing.la/nothing/v1_8/rankinglist/common/findMatchRanklistByType.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"2.0.4","deviceType":"android","sysVersion":"23","type":"3"}
     * 关于type参数 ： 3-月 2-周 1-新
     */
    @POST("v1_8/rankinglist/common/findMatchRanklistByType.do")
    Observable<SimpleListResponse<HotMatch>> findMatchRanklistByType(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 博主总榜
     * https://api.nothing.la/nothing/v1_8/rankinglist/common/findAllRanklist.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"2.0.4","deviceType":"android","sysVersion":"23"}
     */
    @POST("v1_8/rankinglist/common/findAllRanklist.do")
    Observable<SimpleListResponse<RankMaster>> findAllRanklist(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * Detail
     * https://api.nothing.la/nothing/v1_8/dynamic/getDetail.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"2.0.4","deviceType":"android","id":"3f11b01a8cd94e61ab1c60608654277a","sysVersion":"23"}
     */
    @POST("v1_8/dynamic/getDetail.do")
    Observable<NormalData<MatchDetail>> getDetail(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);


    /**
     * 个人界面的发布列表
     * https://api.nothing.la/nothing/dynamic/common/findListByUser.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"2.0.4","deviceType":"android","id":"d7f7ad757584423e89545d5fcc801387","sysVersion":"23"}
     *
     */
    @POST("dynamic/common/findListByUser.do")
    Observable<NormalData<ListData<UserMatch>>> getUserDynamic(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 个人界面赞过搭配
     * https://api.nothing.la/nothing/v1_4/dynamic/common/praise/findList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"2.0.4","deviceType":"android","id":"d7f7ad757584423e89545d5fcc801387","sysVersion":"23"}
     */
    @POST("v1_4/dynamic/common/praise/findList.do")
    Observable<NormalData<ListData<UserMatch>>> getUserPraised(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);


    /**
     * 添加关注
     * https://api.nothing.la/nothing/user/addAttention.do?accessToken=18a480ba87d04e1daac69cc540922703
     *{"appVersion":"2.0.4","byUserId":"80a517869d144e8db4e4edd5986f7cdd","deviceType":"android","sysVersion":"23"}
     */
    @POST("user/addAttention.do")
    Observable<NormalData> addFollow(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);


    /**
     * 取消关注
     * https://api.nothing.la/nothing/user/cancelAttention.do?accessToken=18a480ba87d04e1daac69cc540922703
     *
     */
    @POST("user/cancelAttention.do")
    Observable<NormalData> cancelFollow(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);


    /**
     * 获取关注动态
     * https://api.nothing.la/nothing/v1_9/dynamic/findIndexList.do?accessToken=18a480ba87d04e1daac69cc540922703
     * {"appVersion":"2.0.4","deviceType":"android","isFirstRegister":false,"startRow":"0","sysVersion":"23"}
     */
    @POST("v1_9/dynamic/findIndexList.do")
    Observable<NormalData<SiftsDataBean>> getFollowDynamic(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * 获取childTag
     * https://api.nothing.la/nothing/v1_9_8/tag/findChildTagListForIndexByTag.do?accessToken=18a480ba87d04e1daac69cc540922703
     * id body
     */
    @POST("v1_9_8/tag/findChildTagListForIndexByTag.do")
    Observable<SimpleListResponse<List<ChildTag>>> getChildTags(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

    /**
     * https://api.nothing.la/nothing/v2_1/tag/findDynamicListByTags.do?accessToken=18a480ba87d04e1daac69cc540922703
     *
     */
    @POST("v2_1/tag/findDynamicListByTags.do")
    Observable<NormalData<ListData<ChildTagMatch>>> getDynamicByTag(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);




}
