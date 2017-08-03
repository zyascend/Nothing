package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/7/18 10:52
 * 邮箱：zyascend@qq.com
 */

public class RecommendMatch {

    /**
     * id : 56e8613f400a474681755bbe0dd904a2
     * match : {"commCount":0,"createTime":"2017-08-03 14:33:23","description":"@NOTHING官方 \n\n咬一口🥕","forwordCount":0,"height":"163","hotNum":0,"id":"56e8613f400a474681755bbe0dd904a2","isAddMagazine":false,"isPraise":false,"linkUrl":"https://api.nothing.la/nothing/share/detail-posts.html?id=56e8613f400a474681755bbe0dd904a2","lookCount":655,"picture":{"compress":"large","height":2176,"key":"FmlaIV1GsTsHMlCzQH1MzB9-4P3N","url":"http://img.nothing.la/FmlaIV1GsTsHMlCzQH1MzB9-4P3N?imageMogr2/thumbnail/1000000@","webUrl":"//img.nothing.la/FmlaIV1GsTsHMlCzQH1MzB9-4P3N?imageMogr2/thumbnail/1000000@","width":1632},"pictureCount":1,"praiseCount":33,"recommonedSize":100,"showTime":"今天 14:33","user":{"age":24,"allRankSort":0,"area":{"id":"709ca54a733311e586736476bab0cf04","name":"杭州市"},"areaId":"709ca54a733311e586736476bab0cf04","bilibiliInfo":"","blogUrl":"http://blog.nothing.la/rare","category":"e3d3bea8783c4b948c43a0c4b0ca8a90","commissionAuditStatus":1,"commissionBrandAuditStatus":1,"cover":{"compress":"large","height":3264,"key":"cover_e7648cd092914564bab550a0aa4598c0.png","url":"http://img.nothing.la/cover_e7648cd092914564bab550a0aa4598c0.png?imageMogr2/thumbnail/1000000@","webUrl":"//img.nothing.la/cover_e7648cd092914564bab550a0aa4598c0.png?imageMogr2/thumbnail/1000000@","width":1836},"createTime":"2017-01-02 12:53:45","description":"店铺：稀有rare\n微博：@RARE稀有","deviceId":"0FC93B00-607C-4448-80DC-9F35E5579AC3","finishType":3,"gender":2,"hair":{"id":"4","name":"短发"},"head":{"height":1000,"key":"head_03098dbb6773469e86b5321dce1c73ec.png","url":"http://img.nothing.la/head_03098dbb6773469e86b5321dce1c73ec.png","webUrl":"//img.nothing.la/head_03098dbb6773469e86b5321dce1c73ec.png","width":1000},"height":"163","id":"f49d0bd074ff4a7a9c1d7d2271385dd6","instagramInfo":"","mainType":1,"name":"稀有RARE","praise":0,"taobaoInfo":"http://shop.m.taobao.com/shop/shop_index.htm?ut_sk=1.VtZeQ9grW6gDAMW6detN4GrN_21380790_1483340269882.Copy.54&user_id=1119565811&sourceType=shop&suid=2E88861A-A654-45FC-94F1-C311E18F5D3D&un=1a689353ed4dcebee7c4cca5375f99dd&share_crt_v=1&cpp=1&shareurl=true&spm=a313p.22.e7.20929670137&short_name=h.XWmKIF","themeTemplateId":"001de87c25514a6a9d12c0bd4e681f06","type":4,"userTitleDesc":"","weiboFansNum":0,"weiboInfo":"http://weibo.com/u/1964352925","weight":"45","weixinInfo":"微信：jimu217","youkuInfo":"","youtubeInfo":""},"weight":"45"}
     */

    private String id;
    private MatchBean match;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MatchBean getMatch() {
        return match;
    }

    public void setMatch(MatchBean match) {
        this.match = match;
    }

    public static class MatchBean {


        private int commCount;
        private String createTime;
        private String description;
        private int forwordCount;
        private String height;
        private int hotNum;
        private String id;
        private boolean isAddMagazine;
        private boolean isPraise;
        private String linkUrl;
        private int lookCount;
        private PictureBean picture;
        private int pictureCount;
        private int praiseCount;
        private int recommonedSize;
        private String showTime;
        private UserBean user;
        private String weight;

        public int getCommCount() {
            return commCount;
        }

        public void setCommCount(int commCount) {
            this.commCount = commCount;
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

        public int getForwordCount() {
            return forwordCount;
        }

        public void setForwordCount(int forwordCount) {
            this.forwordCount = forwordCount;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public int getHotNum() {
            return hotNum;
        }

        public void setHotNum(int hotNum) {
            this.hotNum = hotNum;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsAddMagazine() {
            return isAddMagazine;
        }

        public void setIsAddMagazine(boolean isAddMagazine) {
            this.isAddMagazine = isAddMagazine;
        }

        public boolean isIsPraise() {
            return isPraise;
        }

        public void setIsPraise(boolean isPraise) {
            this.isPraise = isPraise;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public int getLookCount() {
            return lookCount;
        }

        public void setLookCount(int lookCount) {
            this.lookCount = lookCount;
        }

        public PictureBean getPicture() {
            return picture;
        }

        public void setPicture(PictureBean picture) {
            this.picture = picture;
        }

        public int getPictureCount() {
            return pictureCount;
        }

        public void setPictureCount(int pictureCount) {
            this.pictureCount = pictureCount;
        }

        public int getPraiseCount() {
            return praiseCount;
        }

        public void setPraiseCount(int praiseCount) {
            this.praiseCount = praiseCount;
        }

        public int getRecommonedSize() {
            return recommonedSize;
        }

        public void setRecommonedSize(int recommonedSize) {
            this.recommonedSize = recommonedSize;
        }

        public String getShowTime() {
            return showTime;
        }

        public void setShowTime(String showTime) {
            this.showTime = showTime;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public static class PictureBean {


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

        public static class UserBean {

            private int age;
            private int allRankSort;
            private AreaBean area;
            private String areaId;
            private String bilibiliInfo;
            private String blogUrl;
            private String category;
            private int commissionAuditStatus;
            private int commissionBrandAuditStatus;
            private CoverBean cover;
            private String createTime;
            private String description;
            private String deviceId;
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
            private String themeTemplateId;
            private int type;
            private String userTitleDesc;
            private int weiboFansNum;
            private String weiboInfo;
            private String weight;
            private String weixinInfo;
            private String youkuInfo;
            private String youtubeInfo;

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public int getAllRankSort() {
                return allRankSort;
            }

            public void setAllRankSort(int allRankSort) {
                this.allRankSort = allRankSort;
            }

            public AreaBean getArea() {
                return area;
            }

            public void setArea(AreaBean area) {
                this.area = area;
            }

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getBilibiliInfo() {
                return bilibiliInfo;
            }

            public void setBilibiliInfo(String bilibiliInfo) {
                this.bilibiliInfo = bilibiliInfo;
            }

            public String getBlogUrl() {
                return blogUrl;
            }

            public void setBlogUrl(String blogUrl) {
                this.blogUrl = blogUrl;
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

            public String getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(String deviceId) {
                this.deviceId = deviceId;
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

            public String getThemeTemplateId() {
                return themeTemplateId;
            }

            public void setThemeTemplateId(String themeTemplateId) {
                this.themeTemplateId = themeTemplateId;
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

            public static class AreaBean {
                /**
                 * id : 709ca54a733311e586736476bab0cf04
                 * name : 杭州市
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

            public static class CoverBean {
                /**
                 * compress : large
                 * height : 3264
                 * key : cover_e7648cd092914564bab550a0aa4598c0.png
                 * url : http://img.nothing.la/cover_e7648cd092914564bab550a0aa4598c0.png?imageMogr2/thumbnail/1000000@
                 * webUrl : //img.nothing.la/cover_e7648cd092914564bab550a0aa4598c0.png?imageMogr2/thumbnail/1000000@
                 * width : 1836
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
                 * height : 1000
                 * key : head_03098dbb6773469e86b5321dce1c73ec.png
                 * url : http://img.nothing.la/head_03098dbb6773469e86b5321dce1c73ec.png
                 * webUrl : //img.nothing.la/head_03098dbb6773469e86b5321dce1c73ec.png
                 * width : 1000
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
    }
}
