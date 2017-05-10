 package com.zyascend.Nothing.mvp.http;

import com.zyascend.Nothing.bean.BannerBean;
import com.zyascend.Nothing.bean.BaseResponse;
import com.zyascend.Nothing.bean.HomeTag;
import com.zyascend.Nothing.bean.MenuBean;
import com.zyascend.Nothing.bean.NormalData;
import com.zyascend.Nothing.bean.Notice;
import com.zyascend.Nothing.bean.RankingUser;

import com.zyascend.Nothing.bean.SiftsDataBean;
import com.zyascend.Nothing.bean.SimpleListResponse;
import com.zyascend.Nothing.bean.SimpleResponse;
import com.zyascend.Nothing.bean.UserBean;


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
    Observable<SimpleListResponse<Notice>> getNotice(@Query(ACCESS_TOKEN)String accessToken, @Body RequestBody body);

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
     * 获取用户信息
     * url=https://api.nothing.la/nothing/user/getUser.do?accessToken=18a480ba87d04e1daac69cc540922703
     * body=simple版
     */
    @POST("user/getUser.do")
    Observable<NormalData<UserBean>> getUser(@Query(ACCESS_TOKEN)String accessToken,@Body RequestBody body);

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




}
