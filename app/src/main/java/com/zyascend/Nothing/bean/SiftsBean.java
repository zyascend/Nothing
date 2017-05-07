package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/3 10:57
 * 邮箱：zyascend@qq.com
 */

public class SiftsBean {


    private DynamicBean dynamic;
    private int type;

    public DynamicBean getDynamic() {
        return dynamic;
    }

    public void setDynamic(DynamicBean dynamic) {
        this.dynamic = dynamic;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static class DynamicBean {


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
            private HeightTagBean heightTag;
            private int hotNum;
            private String id;
            private boolean isAddMagazine;
            private boolean isPraise;
            private String linkUrl;
            private int lookCount;
            private PictureBeanX picture;
            private int pictureCount;
            private int praiseCount;
            private String pushTime;
            private int recommonedSize;
            private String showTime;
            private SiftTagBean siftTag;
            private UserBean user;
            private String weight;
            private List<MatchCommentsBean> matchComments;
            private List<ProdListBean> prodList;
            private List<RemindUsersBean> remindUsers;

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

            public HeightTagBean getHeightTag() {
                return heightTag;
            }

            public void setHeightTag(HeightTagBean heightTag) {
                this.heightTag = heightTag;
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

            public PictureBeanX getPicture() {
                return picture;
            }

            public void setPicture(PictureBeanX picture) {
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

            public String getPushTime() {
                return pushTime;
            }

            public void setPushTime(String pushTime) {
                this.pushTime = pushTime;
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

            public SiftTagBean getSiftTag() {
                return siftTag;
            }

            public void setSiftTag(SiftTagBean siftTag) {
                this.siftTag = siftTag;
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

            public List<MatchCommentsBean> getMatchComments() {
                return matchComments;
            }

            public void setMatchComments(List<MatchCommentsBean> matchComments) {
                this.matchComments = matchComments;
            }

            public List<ProdListBean> getProdList() {
                return prodList;
            }

            public void setProdList(List<ProdListBean> prodList) {
                this.prodList = prodList;
            }

            public List<RemindUsersBean> getRemindUsers() {
                return remindUsers;
            }

            public void setRemindUsers(List<RemindUsersBean> remindUsers) {
                this.remindUsers = remindUsers;
            }

            public static class HeightTagBean {


                private int hotNum;
                private int hotType;
                private String id;
                private String name;
                private PictureBean picture;
                private String shareUrl;
                private int type;

                public int getHotNum() {
                    return hotNum;
                }

                public void setHotNum(int hotNum) {
                    this.hotNum = hotNum;
                }

                public int getHotType() {
                    return hotType;
                }

                public void setHotType(int hotType) {
                    this.hotType = hotType;
                }

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

                public PictureBean getPicture() {
                    return picture;
                }

                public void setPicture(PictureBean picture) {
                    this.picture = picture;
                }

                public String getShareUrl() {
                    return shareUrl;
                }

                public void setShareUrl(String shareUrl) {
                    this.shareUrl = shareUrl;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public static class PictureBean {

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

            public static class PictureBeanX {


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

            public static class SiftTagBean {

                private int hotNum;
                private int hotType;
                private String id;
                private String name;
                private PictureBeanXX picture;
                private String shareUrl;
                private int type;

                public int getHotNum() {
                    return hotNum;
                }

                public void setHotNum(int hotNum) {
                    this.hotNum = hotNum;
                }

                public int getHotType() {
                    return hotType;
                }

                public void setHotType(int hotType) {
                    this.hotType = hotType;
                }

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

                public PictureBeanXX getPicture() {
                    return picture;
                }

                public void setPicture(PictureBeanXX picture) {
                    this.picture = picture;
                }

                public String getShareUrl() {
                    return shareUrl;
                }

                public void setShareUrl(String shareUrl) {
                    this.shareUrl = shareUrl;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public static class PictureBeanXX {
                    /**
                     * height : 300
                     * key : default_tag.png
                     * url : http://img.nothing.la/default_tag.png
                     * webUrl : //img.nothing.la/default_tag.png
                     * width : 300
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

            public static class UserBean {


                private int age;
                private int allRankSort;
                private AreaBean area;
                private String areaId;
                private String bilibiliInfo;
                private String blogUrl;
                private String category;
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
                private String userTitle;
                private String userTitleDesc;
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

                public String getUserTitle() {
                    return userTitle;
                }

                public void setUserTitle(String userTitle) {
                    this.userTitle = userTitle;
                }

                public String getUserTitleDesc() {
                    return userTitleDesc;
                }

                public void setUserTitleDesc(String userTitleDesc) {
                    this.userTitleDesc = userTitleDesc;
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


                    private String compress;
                    private String format;
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

                    public String getFormat() {
                        return format;
                    }

                    public void setFormat(String format) {
                        this.format = format;
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
                     * format : webp
                     * height : 900
                     * key : head_1a9faa7b88604f6fa51d2b4e2c18dec0.png
                     * url : http://img.nothing.la/head_1a9faa7b88604f6fa51d2b4e2c18dec0.png
                     * webUrl : //img.nothing.la/head_1a9faa7b88604f6fa51d2b4e2c18dec0.png
                     * width : 900
                     */

                    private String format;
                    private int height;
                    private String key;
                    private String url;
                    private String webUrl;
                    private int width;

                    public String getFormat() {
                        return format;
                    }

                    public void setFormat(String format) {
                        this.format = format;
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
            }

            public static class MatchCommentsBean {


                private String content;
                private String createTime;
                private String id;
                private String matchId;
                private String showTime;
                private int type;
                private UserBeanX user;
                private String replyId;
                private ReplyUserBean replyUser;
                private List<?> remindUsers;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getMatchId() {
                    return matchId;
                }

                public void setMatchId(String matchId) {
                    this.matchId = matchId;
                }

                public String getShowTime() {
                    return showTime;
                }

                public void setShowTime(String showTime) {
                    this.showTime = showTime;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public UserBeanX getUser() {
                    return user;
                }

                public void setUser(UserBeanX user) {
                    this.user = user;
                }

                public String getReplyId() {
                    return replyId;
                }

                public void setReplyId(String replyId) {
                    this.replyId = replyId;
                }

                public ReplyUserBean getReplyUser() {
                    return replyUser;
                }

                public void setReplyUser(ReplyUserBean replyUser) {
                    this.replyUser = replyUser;
                }

                public List<?> getRemindUsers() {
                    return remindUsers;
                }

                public void setRemindUsers(List<?> remindUsers) {
                    this.remindUsers = remindUsers;
                }

                public static class UserBeanX {


                    private CoverBeanX cover;
                    private String description;
                    private int finishType;
                    private int gender;
                    private HeadBeanX head;
                    private String id;
                    private String name;
                    private int praise;
                    private int type;
                    private String userTitleDesc;

                    public CoverBeanX getCover() {
                        return cover;
                    }

                    public void setCover(CoverBeanX cover) {
                        this.cover = cover;
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

                    public HeadBeanX getHead() {
                        return head;
                    }

                    public void setHead(HeadBeanX head) {
                        this.head = head;
                    }

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

                    public int getPraise() {
                        return praise;
                    }

                    public void setPraise(int praise) {
                        this.praise = praise;
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

                    public static class CoverBeanX {
                        /**
                         * height : 2001
                         * key : default_cover.png
                         * url : http://img.nothing.la/default_cover.png
                         * webUrl : //img.nothing.la/default_cover.png
                         * width : 1125
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

                    public static class HeadBeanX {


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

                public static class ReplyUserBean {
                    /**
                     * cover : {"height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125}
                     * description :
                     * finishType : 1
                     * gender : -1
                     * head : {"height":120,"key":"default_head.png","url":"http://img.nothing.la/default_head.png","webUrl":"//img.nothing.la/default_head.png","width":120}
                     * id : 6f26f24c7ba0457db901e9cd80718a0d
                     * name : 爱恨交加
                     * praise : 0
                     * userTitleDesc :
                     */

                    private CoverBeanXX cover;
                    private String description;
                    private int finishType;
                    private int gender;
                    private HeadBeanXX head;
                    private String id;
                    private String name;
                    private int praise;
                    private String userTitleDesc;

                    public CoverBeanXX getCover() {
                        return cover;
                    }

                    public void setCover(CoverBeanXX cover) {
                        this.cover = cover;
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

                    public HeadBeanXX getHead() {
                        return head;
                    }

                    public void setHead(HeadBeanXX head) {
                        this.head = head;
                    }

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

                    public int getPraise() {
                        return praise;
                    }

                    public void setPraise(int praise) {
                        this.praise = praise;
                    }

                    public String getUserTitleDesc() {
                        return userTitleDesc;
                    }

                    public void setUserTitleDesc(String userTitleDesc) {
                        this.userTitleDesc = userTitleDesc;
                    }

                    public static class CoverBeanXX {
                        /**
                         * height : 2001
                         * key : default_cover.png
                         * url : http://img.nothing.la/default_cover.png
                         * webUrl : //img.nothing.la/default_cover.png
                         * width : 1125
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

                    public static class HeadBeanXX {
                        /**
                         * height : 120
                         * key : default_head.png
                         * url : http://img.nothing.la/default_head.png
                         * webUrl : //img.nothing.la/default_head.png
                         * width : 120
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

            public static class ProdListBean {
                /**
                 * brandId : 4243a04a8dc24870a24391ba49afbd9a
                 * brandName : GUESSANY
                 * buyurl : https://item.taobao.com/item.htm?ut_sk=1.WGvoUmCDQOIDADP8dKUrklae_21380790_1493742366317.Copy.1&id=549856963712&sourceType=item&price=59&suid=1B8014B6-CC2A-462F-8649-1B8F18B66532&cpp=1&shareurl=true&spm=a313p.22.17r.36967812122&short_name=h.TXBzeb
                 * category : {"id":"c507af9bd5dc4833bc906c8bfa374fc2","name":"墨镜"}
                 * categoryId : c507af9bd5dc4833bc906c8bfa374fc2
                 * categoryName : 墨镜
                 * colorId : 1b08f143faec48ba80d9bb0654242911
                 * colorName : 蓝色系
                 * currency : 1
                 * id : 0cbfde77bbe34e6e961bfaba2de94cf4
                 * isLeft : 1
                 * matchProdType : 1
                 * name : GUESSANY/墨镜/蓝色系
                 * picture : {"compress":"medium","height":1070,"key":"FqPQGosZMjZOtfMbS3iVByNX2bsT?imageMogr2/crop/!1605x1070a0a0","url":"http://img.nothing.la/FqPQGosZMjZOtfMbS3iVByNX2bsT?imageMogr2/crop/!1605x1070a0a0/thumbnail/600x","webUrl":"//img.nothing.la/FqPQGosZMjZOtfMbS3iVByNX2bsT?imageMogr2/crop/!1605x1070a0a0/thumbnail/600x","width":1605}
                 * positionX : 0.35507247
                 * positionY : 0.23550725
                 * shop : {}
                 * sourceName : 淘宝
                 * taobaoCode : 549856963712
                 * type : 2
                 */

                private String brandId;
                private String brandName;
                private String buyurl;
                private CategoryBean category;
                private String categoryId;
                private String categoryName;
                private String colorId;
                private String colorName;
                private int currency;
                private String id;
                private int isLeft;
                private int matchProdType;
                private String name;
                private PictureBeanXXX picture;
                private double positionX;
                private double positionY;
                private ShopBean shop;
                private String sourceName;
                private String taobaoCode;
                private int type;

                public String getBrandId() {
                    return brandId;
                }

                public void setBrandId(String brandId) {
                    this.brandId = brandId;
                }

                public String getBrandName() {
                    return brandName;
                }

                public void setBrandName(String brandName) {
                    this.brandName = brandName;
                }

                public String getBuyurl() {
                    return buyurl;
                }

                public void setBuyurl(String buyurl) {
                    this.buyurl = buyurl;
                }

                public CategoryBean getCategory() {
                    return category;
                }

                public void setCategory(CategoryBean category) {
                    this.category = category;
                }

                public String getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(String categoryId) {
                    this.categoryId = categoryId;
                }

                public String getCategoryName() {
                    return categoryName;
                }

                public void setCategoryName(String categoryName) {
                    this.categoryName = categoryName;
                }

                public String getColorId() {
                    return colorId;
                }

                public void setColorId(String colorId) {
                    this.colorId = colorId;
                }

                public String getColorName() {
                    return colorName;
                }

                public void setColorName(String colorName) {
                    this.colorName = colorName;
                }

                public int getCurrency() {
                    return currency;
                }

                public void setCurrency(int currency) {
                    this.currency = currency;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getIsLeft() {
                    return isLeft;
                }

                public void setIsLeft(int isLeft) {
                    this.isLeft = isLeft;
                }

                public int getMatchProdType() {
                    return matchProdType;
                }

                public void setMatchProdType(int matchProdType) {
                    this.matchProdType = matchProdType;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public PictureBeanXXX getPicture() {
                    return picture;
                }

                public void setPicture(PictureBeanXXX picture) {
                    this.picture = picture;
                }

                public double getPositionX() {
                    return positionX;
                }

                public void setPositionX(double positionX) {
                    this.positionX = positionX;
                }

                public double getPositionY() {
                    return positionY;
                }

                public void setPositionY(double positionY) {
                    this.positionY = positionY;
                }

                public ShopBean getShop() {
                    return shop;
                }

                public void setShop(ShopBean shop) {
                    this.shop = shop;
                }

                public String getSourceName() {
                    return sourceName;
                }

                public void setSourceName(String sourceName) {
                    this.sourceName = sourceName;
                }

                public String getTaobaoCode() {
                    return taobaoCode;
                }

                public void setTaobaoCode(String taobaoCode) {
                    this.taobaoCode = taobaoCode;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public static class CategoryBean {
                    /**
                     * id : c507af9bd5dc4833bc906c8bfa374fc2
                     * name : 墨镜
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

                public static class PictureBeanXXX {
                }

                public static class ShopBean {
                }
            }

            public static class RemindUsersBean {
                /**
                 * cover : {"height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125}
                 * description :
                 * finishType : 1
                 * gender : -1
                 * head : {"height":120,"key":"default_head.png","url":"http://img.nothing.la/default_head.png","webUrl":"//img.nothing.la/default_head.png","width":120}
                 * id : f0b6c5c5106c4866b589dcc2d96ba186
                 * name : GUESSANY
                 * praise : 0
                 * userTitleDesc :
                 */

                private CoverBeanXXX cover;
                private String description;
                private int finishType;
                private int gender;
                private HeadBeanXXX head;
                private String id;
                private String name;
                private int praise;
                private String userTitleDesc;

                public CoverBeanXXX getCover() {
                    return cover;
                }

                public void setCover(CoverBeanXXX cover) {
                    this.cover = cover;
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

                public HeadBeanXXX getHead() {
                    return head;
                }

                public void setHead(HeadBeanXXX head) {
                    this.head = head;
                }

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

                public int getPraise() {
                    return praise;
                }

                public void setPraise(int praise) {
                    this.praise = praise;
                }

                public String getUserTitleDesc() {
                    return userTitleDesc;
                }

                public void setUserTitleDesc(String userTitleDesc) {
                    this.userTitleDesc = userTitleDesc;
                }

                public static class CoverBeanXXX {
                    /**
                     * height : 2001
                     * key : default_cover.png
                     * url : http://img.nothing.la/default_cover.png
                     * webUrl : //img.nothing.la/default_cover.png
                     * width : 1125
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

                public static class HeadBeanXXX {
                    /**
                     * height : 120
                     * key : default_head.png
                     * url : http://img.nothing.la/default_head.png
                     * webUrl : //img.nothing.la/default_head.png
                     * width : 120
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




}
