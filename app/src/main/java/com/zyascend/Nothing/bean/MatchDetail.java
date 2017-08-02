package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/30 10:38
 * 邮箱：zyascend@qq.com
 */

public class MatchDetail {



    private String id;
    private MatchBean match;
    private String shareContent;
    private String shareTitle;

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

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public static class MatchBean {

        private int commCount;
        private String createTime;
        private String description;
        private int forwordCount;
        private int gender;
        private HairBean hair;
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
        private List<?> honorList;
        private List<MatchComments> matchComments;
        private List<PicListBean> picList;
        private List<PraiseUsersBean> praiseUsers;
        private List<ProdListBean> prodList;
        private List<RemindUsersBean> remindUsers;
        private List<?> subjects;
        private List<SysProdsBean> sysProds;
        private List<TagListBean> tagList;

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

        public List<?> getHonorList() {
            return honorList;
        }

        public void setHonorList(List<?> honorList) {
            this.honorList = honorList;
        }

        public List<MatchComments> getMatchComments() {
            return matchComments;
        }

        public void setMatchComments(List<MatchComments> matchComments) {
            this.matchComments = matchComments;
        }

        public List<PicListBean> getPicList() {
            return picList;
        }

        public void setPicList(List<PicListBean> picList) {
            this.picList = picList;
        }

        public List<PraiseUsersBean> getPraiseUsers() {
            return praiseUsers;
        }

        public void setPraiseUsers(List<PraiseUsersBean> praiseUsers) {
            this.praiseUsers = praiseUsers;
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

        public List<?> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<?> subjects) {
            this.subjects = subjects;
        }

        public List<SysProdsBean> getSysProds() {
            return sysProds;
        }

        public void setSysProds(List<SysProdsBean> sysProds) {
            this.sysProds = sysProds;
        }

        public List<TagListBean> getTagList() {
            return tagList;
        }

        public void setTagList(List<TagListBean> tagList) {
            this.tagList = tagList;
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

        public static class PictureBean {
            /**
             * compress : large
             * height : 1125
             * key : nothing_14410c276f0e4a5ab31f01aa20112260.png
             * url : http://img.nothing.la/nothing_14410c276f0e4a5ab31f01aa20112260.png?imageMogr2/thumbnail/1000000@
             * webUrl : //img.nothing.la/nothing_14410c276f0e4a5ab31f01aa20112260.png?imageMogr2/thumbnail/1000000@
             * width : 843
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

        public static class UserBean {
            /**
             * attentionStatus : 1
             * cover : {"compress":"large","height":1140,"key":"cover_e61d5e334097495ab5ba374d4347d1c2.png","url":"http://img.nothing.la/cover_e61d5e334097495ab5ba374d4347d1c2.png?imageMogr2/thumbnail/1000000@","webUrl":"//img.nothing.la/cover_e61d5e334097495ab5ba374d4347d1c2.png?imageMogr2/thumbnail/1000000@","width":641}
             * createTime : 2015-12-02 16:39:32
             * description : Weibo/Taobao：张憔悴
             wechat：Zhangqiaocui717
             * finishType : 3
             * gender : 1
             * hair : {"id":"4","name":"短发"}
             * head : {"height":900,"key":"head_5f6080912058461f82b66ee59eab0801.png","url":"http://img.nothing.la/head_5f6080912058461f82b66ee59eab0801.png","webUrl":"//img.nothing.la/head_5f6080912058461f82b66ee59eab0801.png","width":900}
             * height : 180
             * id : 9c22dbea461b4217ab8b5ada7f7bde46
             * mainType : 1
             * name : 张憔悴
             * praise : 0
             * type : 4
             * userTitleDesc :
             * weight : 64
             */

            private int attentionStatus;
            private CoverBean cover;
            private String createTime;
            private String description;
            private int finishType;
            private int gender;
            private HairBean hair;
            private HeadBean head;
            private String height;
            private String id;
            private int mainType;
            private String name;
            private int praise;
            private int type;
            private String userTitleDesc;
            private String weight;

            public int getAttentionStatus() {
                return attentionStatus;
            }

            public void setAttentionStatus(int attentionStatus) {
                this.attentionStatus = attentionStatus;
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

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public static class CoverBean {


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



            public static class HeadBean {
                /**
                 * height : 900
                 * key : head_5f6080912058461f82b66ee59eab0801.png
                 * url : http://img.nothing.la/head_5f6080912058461f82b66ee59eab0801.png
                 * webUrl : //img.nothing.la/head_5f6080912058461f82b66ee59eab0801.png
                 * width : 900
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


        public static class PicListBean {
            /**
             * compress : large
             * height : 1125
             * key : nothing_14410c276f0e4a5ab31f01aa20112260.png
             * url : http://img.nothing.la/nothing_14410c276f0e4a5ab31f01aa20112260.png?imageMogr2/thumbnail/1000000@
             * webUrl : //img.nothing.la/nothing_14410c276f0e4a5ab31f01aa20112260.png?imageMogr2/thumbnail/1000000@
             * width : 843
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

        public static class PraiseUsersBean {
            /**
             * cover : {"height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125}
             * description :
             * finishType : 1
             * gender : -1
             * head : {"height":0,"key":"http://wx.qlogo.cn/mmopen/O1dAhMERUwUj65pfnvfaW22BFfW0tts37pjKDgIIsH9TiaiajuBLdT0kh7uc6YS0yCgNdQS4laVSnbRw6X38iaO1poLFOl5m2u3/0","url":"http://wx.qlogo.cn/mmopen/O1dAhMERUwUj65pfnvfaW22BFfW0tts37pjKDgIIsH9TiaiajuBLdT0kh7uc6YS0yCgNdQS4laVSnbRw6X38iaO1poLFOl5m2u3/0","webUrl":"//wx.qlogo.cn/mmopen/O1dAhMERUwUj65pfnvfaW22BFfW0tts37pjKDgIIsH9TiaiajuBLdT0kh7uc6YS0yCgNdQS4laVSnbRw6X38iaO1poLFOl5m2u3/0","width":0}
             * id : 4d33c7c0b07b46c1b4f49d0e684a7a80
             * name : 寄宿在眼中的火焰
             * praise : 0
             * type : 1
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
            private int type;
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
                 * height : 0
                 * key : http://wx.qlogo.cn/mmopen/O1dAhMERUwUj65pfnvfaW22BFfW0tts37pjKDgIIsH9TiaiajuBLdT0kh7uc6YS0yCgNdQS4laVSnbRw6X38iaO1poLFOl5m2u3/0
                 * url : http://wx.qlogo.cn/mmopen/O1dAhMERUwUj65pfnvfaW22BFfW0tts37pjKDgIIsH9TiaiajuBLdT0kh7uc6YS0yCgNdQS4laVSnbRw6X38iaO1poLFOl5m2u3/0
                 * webUrl : //wx.qlogo.cn/mmopen/O1dAhMERUwUj65pfnvfaW22BFfW0tts37pjKDgIIsH9TiaiajuBLdT0kh7uc6YS0yCgNdQS4laVSnbRw6X38iaO1poLFOl5m2u3/0
                 * width : 0
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

        public static class ProdListBean {

            private String brandId;
            private String brandName;
            private int buyType;
            private String buyurl;
            private CategoryBean category;
            private String categoryId;
            private String categoryName;
            private String colorId;
            private String colorName;
            private int currency;
            private String description;
            private String id;
            private int isLeft;
            private int matchProdType;
            private String name;
            private PictureBeanX picture;
            private double positionX;
            private double positionY;
            private ShopBean shop;
            private String sourceName;
            private String taobaoCode;
            private int type;
            private String unused_description;

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

            public int getBuyType() {
                return buyType;
            }

            public void setBuyType(int buyType) {
                this.buyType = buyType;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
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

            public PictureBeanX getPicture() {
                return picture;
            }

            public void setPicture(PictureBeanX picture) {
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

            public String getUnused_description() {
                return unused_description;
            }

            public void setUnused_description(String unused_description) {
                this.unused_description = unused_description;
            }

            public static class CategoryBean {
                /**
                 * id : a84da69e86a54ee2aafd81242fc946b0
                 * namePath : 外套/大衣
                 */

                private String id;
                private String namePath;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getNamePath() {
                    return namePath;
                }

                public void setNamePath(String namePath) {
                    this.namePath = namePath;
                }
            }

            public static class PictureBeanX {
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
             * id : 6c494dd785d5430189a191e6f4fcc08d
             * name : NOTHING官方
             * praise : 0
             * userTitleDesc :
             */

            private CoverBeanXXXX cover;
            private String description;
            private int finishType;
            private int gender;
            private HeadBeanXXXX head;
            private String id;
            private String name;
            private int praise;
            private String userTitleDesc;

            public CoverBeanXXXX getCover() {
                return cover;
            }

            public void setCover(CoverBeanXXXX cover) {
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

            public HeadBeanXXXX getHead() {
                return head;
            }

            public void setHead(HeadBeanXXXX head) {
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

            public static class CoverBeanXXXX {
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

            public static class HeadBeanXXXX {
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

        public static class SysProdsBean {
            /**
             * brandId : 968d074c806940e68bf459d86d82ccdc
             * brandName : ZQC#
             * buyType : 1
             * buyurl : http://item.taobao.com/item.htm?ut_sk=1.VQxa3s6j1QgDAKyk%2B6KDMYJr_21380790_1482908976583.Copy.1&id=543795270106&sourceType=item&price=335&suid=71159830-ED25-42C2-8B3D-24C1238DBF8D&un=a0ffd43be93406e146e6040d6f65052e&share_crt_v=1&cpp=1&shareurl=true&spm=a313p.22.1ff.20448450521&short_name=h.cwQ0Pt
             * category : {"id":"a84da69e86a54ee2aafd81242fc946b0","namePath":"外套/大衣"}
             * categoryId : a84da69e86a54ee2aafd81242fc946b0
             * categoryName : 大衣
             * colorId : 6e4d1f4b68d24d4f922f0ca3da641152
             * colorName : 黑色系
             * currency : 1
             * description : 还有三天就要步入2017了
             这些天你们的赞就是我发搭配的动力
             满满的爱藏在这件加厚保暖灯芯绒棉大衣里送给你们
             @NOTHING官方
              * id : 0c854fd4d4d54adb9fea5f398310168c
              * isLeft : 0
              * matchProdType : 1
              * name : Zqc#/大衣/黑色系
              * picture : {"compress":"medium","height":562,"key":"nothing_14410c276f0e4a5ab31f01aa20112260.png?imageMogr2/crop/!843x562a0a281","url":"http://img.nothing.la/nothing_14410c276f0e4a5ab31f01aa20112260.png?imageMogr2/crop/!843x562a0a281/thumbnail/600x","webUrl":"//img.nothing.la/nothing_14410c276f0e4a5ab31f01aa20112260.png?imageMogr2/crop/!843x562a0a281/thumbnail/600x","width":843}
              * positionX : 0.62077296
              * positionY : 0.5
              * shop : {}
              * sourceName : 淘宝
              * taobaoCode : 543795270106
              * type : 2
              * unused_description :
             */

            private String brandId;
            private String brandName;
            private int buyType;
            private String buyurl;
            private CategoryBeanX category;
            private String categoryId;
            private String categoryName;
            private String colorId;
            private String colorName;
            private int currency;
            private String description;
            private String id;
            private int isLeft;
            private int matchProdType;
            private String name;
            private PictureBeanXX picture;
            private double positionX;
            private double positionY;
            private ShopBeanX shop;
            private String sourceName;
            private String taobaoCode;
            private int type;
            private String unused_description;

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

            public int getBuyType() {
                return buyType;
            }

            public void setBuyType(int buyType) {
                this.buyType = buyType;
            }

            public String getBuyurl() {
                return buyurl;
            }

            public void setBuyurl(String buyurl) {
                this.buyurl = buyurl;
            }

            public CategoryBeanX getCategory() {
                return category;
            }

            public void setCategory(CategoryBeanX category) {
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
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

            public PictureBeanXX getPicture() {
                return picture;
            }

            public void setPicture(PictureBeanXX picture) {
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

            public ShopBeanX getShop() {
                return shop;
            }

            public void setShop(ShopBeanX shop) {
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

            public String getUnused_description() {
                return unused_description;
            }

            public void setUnused_description(String unused_description) {
                this.unused_description = unused_description;
            }

            public static class CategoryBeanX {
                /**
                 * id : a84da69e86a54ee2aafd81242fc946b0
                 * namePath : 外套/大衣
                 */

                private String id;
                private String namePath;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getNamePath() {
                    return namePath;
                }

                public void setNamePath(String namePath) {
                    this.namePath = namePath;
                }
            }

            public static class PictureBeanXX {
            }

            public static class ShopBeanX {
            }
        }

        public static class TagListBean {
            /**
             * hotNum : 0
             * hotType : 1
             * id : a6ca2f8e05f111e6afb9525400f87ea9
             * name : 编辑精选
             * picture : {"height":300,"key":"default_tag.png","url":"http://img.nothing.la/default_tag.png","webUrl":"//img.nothing.la/default_tag.png","width":300}
             * shareUrl : https://api.nothing.la/nothing/share/tag.html?id=a6ca2f8e05f111e6afb9525400f87ea9&title=%E7%BC%96%E8%BE%91%E7%B2%BE%E9%80%89
             * type : 4
             */

            private int hotNum;
            private int hotType;
            private String id;
            private String name;
            private PictureBeanXXX picture;
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

            public PictureBeanXXX getPicture() {
                return picture;
            }

            public void setPicture(PictureBeanXXX picture) {
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

            public static class PictureBeanXXX {
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
    }
}
