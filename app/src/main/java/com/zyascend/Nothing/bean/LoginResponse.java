package com.zyascend.Nothing.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 功能：
 * 作者：zyascend on 2017/7/16 11:23
 * 邮箱：zyascend@qq.com
 */

public class LoginResponse {


    private String accessToken;
    private int allRankSort;
    private String bilibiliInfo;
    private String category;
    private int commissionAuditStatus;
    private int commissionBrandAuditStatus;
    private CoverBean cover;
    private String createTime;
    private String description;
    private int finishType;
    private int gender;
    private HairBean hair;
    private HeadBean head;
    private String height;
    private String id;
    private String instagramInfo;
    private int mainType;
    private String name;
    private int praise;
    private String taobaoInfo;
    private int type;
    private String userTitleDesc;
    private int weiboFansNum;
    private String weiboInfo;
    private String weight;
    private String weixinInfo;
    private String youkuInfo;
    private String youtubeInfo;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getAllRankSort() {
        return allRankSort;
    }

    public void setAllRankSort(int allRankSort) {
        this.allRankSort = allRankSort;
    }

    public String getBilibiliInfo() {
        return bilibiliInfo;
    }

    public void setBilibiliInfo(String bilibiliInfo) {
        this.bilibiliInfo = bilibiliInfo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCommissionAuditStatus() {
        return commissionAuditStatus;
    }

    public void setCommissionAuditStatus(int commissionAuditStatus) {
        this.commissionAuditStatus = commissionAuditStatus;
    }

    public int getCommissionBrandAuditStatus() {
        return commissionBrandAuditStatus;
    }

    public void setCommissionBrandAuditStatus(int commissionBrandAuditStatus) {
        this.commissionBrandAuditStatus = commissionBrandAuditStatus;
    }

    public CoverBean getCover() {
        return cover;
    }

    public void setCover(CoverBean cover) {
        this.cover = cover;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFinishType() {
        return finishType;
    }

    public void setFinishType(int finishType) {
        this.finishType = finishType;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public HairBean getHair() {
        return hair;
    }

    public void setHair(HairBean hair) {
        this.hair = hair;
    }

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstagramInfo() {
        return instagramInfo;
    }

    public void setInstagramInfo(String instagramInfo) {
        this.instagramInfo = instagramInfo;
    }

    public int getMainType() {
        return mainType;
    }

    public void setMainType(int mainType) {
        this.mainType = mainType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public String getTaobaoInfo() {
        return taobaoInfo;
    }

    public void setTaobaoInfo(String taobaoInfo) {
        this.taobaoInfo = taobaoInfo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserTitleDesc() {
        return userTitleDesc;
    }

    public void setUserTitleDesc(String userTitleDesc) {
        this.userTitleDesc = userTitleDesc;
    }

    public int getWeiboFansNum() {
        return weiboFansNum;
    }

    public void setWeiboFansNum(int weiboFansNum) {
        this.weiboFansNum = weiboFansNum;
    }

    public String getWeiboInfo() {
        return weiboInfo;
    }

    public void setWeiboInfo(String weiboInfo) {
        this.weiboInfo = weiboInfo;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeixinInfo() {
        return weixinInfo;
    }

    public void setWeixinInfo(String weixinInfo) {
        this.weixinInfo = weixinInfo;
    }

    public String getYoukuInfo() {
        return youkuInfo;
    }

    public void setYoukuInfo(String youkuInfo) {
        this.youkuInfo = youkuInfo;
    }

    public String getYoutubeInfo() {
        return youtubeInfo;
    }

    public void setYoutubeInfo(String youtubeInfo) {
        this.youtubeInfo = youtubeInfo;
    }

    public static class CoverBean {
        /**
         * compress : large
         * height : 1280
         * key : cover_7116af27120546abb88aefeb6130d7a1.jpg
         * url : http://img.nothing.la/cover_7116af27120546abb88aefeb6130d7a1.jpg?imageMogr2/thumbnail/1000000@
         * webUrl : //img.nothing.la/cover_7116af27120546abb88aefeb6130d7a1.jpg?imageMogr2/thumbnail/1000000@
         * width : 720
         */

        private String compress;
        private int height;
        private String key;
        private String url;
        private String webUrl;
        private int width;

        public String getCompress() {
            return compress;
        }

        public void setCompress(String compress) {
            this.compress = compress;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }

    public static class HairBean {
        /**
         * id : 4
         * name : 短发
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class HeadBean {
        /**
         * height : 500
         * key : head_273cd6cd0f6d4f89af4578f3c62f6230.jpg
         * url : http://img.nothing.la/head_273cd6cd0f6d4f89af4578f3c62f6230.jpg
         * webUrl : //img.nothing.la/head_273cd6cd0f6d4f89af4578f3c62f6230.jpg
         * width : 500
         */

        private int height;
        private String key;
        private String url;
        private String webUrl;
        private int width;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
