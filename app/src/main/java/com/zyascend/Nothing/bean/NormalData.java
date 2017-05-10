package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 13:26
 * 邮箱：zyascend@qq.com
 */

public class NormalData<T> extends BaseResponse{

    /**
     * DATA : {"accessToken":"18a480ba87d04e1daac69cc540922703","allRankSort":0,"attentionNum":1,"bilibiliInfo":"","binds":[{"accName":"","accType":1,"headUrl":"","userNo":"15754302311"}],"category":"37df05e81e774e318a3df06eeaae84a1","cover":{"compress":"large","height":1280,"key":"cover_7116af27120546abb88aefeb6130d7a1.jpg","url":"http://img.nothing.la/cover_7116af27120546abb88aefeb6130d7a1.jpg?imageMogr2/thumbnail/1000000@","webUrl":"//img.nothing.la/cover_7116af27120546abb88aefeb6130d7a1.jpg?imageMogr2/thumbnail/1000000@","width":720},"createTime":"2017-04-18 23:22:41","description":"","fansNum":0,"finishType":3,"gender":1,"hair":{"id":"4","name":"短发"},"head":{"height":500,"key":"head_273cd6cd0f6d4f89af4578f3c62f6230.jpg","url":"http://img.nothing.la/head_273cd6cd0f6d4f89af4578f3c62f6230.jpg","webUrl":"//img.nothing.la/head_273cd6cd0f6d4f89af4578f3c62f6230.jpg","width":500},"height":"178","id":"0236b7681e8848d39259d494b6507c05","instagramInfo":"","magazineNum":1,"mainType":1,"matchNum":0,"name":"Rxjava","praise":0,"praiseNum":0,"subjectNum":0,"type":1,"unUsedNum":0,"userOperationNum":6,"userTitleDesc":"","weiboFansNum":0,"weight":"70","youkuInfo":"","youtubeInfo":""}
     * MESSAGE : 成功
     * STATUS : 1
     */

    private T DATA;


    public T getDATA() {
        return DATA;
    }

    public void setDATA(T DATA) {
        this.DATA = DATA;
    }

}
