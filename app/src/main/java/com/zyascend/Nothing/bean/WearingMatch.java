package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/28 11:29
 * 邮箱：zyascend@qq.com
 */

public class WearingMatch {
    /**
     * id : 06619e729dfc4246885086cf3217d620
     * match : {"commCount":0,"createTime":"2017-05-28 09:17:07","description":"双层拉链圆环短裤","forwordCount":0,"height":"183","hotNum":0,"hotSort":0,"id":"06619e729dfc4246885086cf3217d620","isAddMagazine":false,"isPraise":false,"linkUrl":"https://api.nothing.la/nothing/share/detail-posts.html?id=06619e729dfc4246885086cf3217d620","lookCount":341,"picture":{"compress":"large","height":2000,"key":"Fqm_G-Tbz8L-K7cF1eGb55ns3luh","url":"http://img.nothing.la/Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/thumbnail/1000000@","webUrl":"//img.nothing.la/Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/thumbnail/1000000@","width":2000},"pictureCount":6,"praiseCount":13,"prodCount":1,"prodId":"526e1d3fa3e14789bdc31d18c9740357","prodList":[{"brandId":"a195fe54e9194106ba7791af01169a40","brandName":"查理UNCLE","buyType":1,"buyurl":"https://item.taobao.com/item.htm?ut_sk=1.VXtxN5rjjUwDAIO1ooCLwGDU_21380790_1495934066606.Copy.1&id=551734599864&sourceType=item&price=138&suid=E83441AB-4C21-4EDC-B1AF-7B38FB1E963D&un=dae6cde2d3519ac87a811649f8da3e26&share_crt_v=1&cpp=1&shareurl=true&spm=a313p.22.mj.40744908294&short_name=h.ShtNJE","categoryId":"b99e86d3c4444546b06da8535cee16a8","categoryName":"短裤","colorId":"6e4d1f4b68d24d4f922f0ca3da641152","colorName":"黑色系","currency":1,"id":"526e1d3fa3e14789bdc31d18c9740357","name":"查理uncle/短裤/黑色系","picture":{"compress":"medium","height":1000,"key":"Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/crop/!2000x1000a0a475","url":"http://img.nothing.la/Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/crop/!2000x1000a0a475/thumbnail/600x","webUrl":"//img.nothing.la/Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/crop/!2000x1000a0a475/thumbnail/600x","width":2000},"shop":{},"sourceName":"淘宝","taobaoCode":"551734599864"}],"recommonedSize":100,"showTime":"今天 09:17","user":{"allRankSort":0,"attentionNum":2,"bilibiliInfo":"","binds":[{"accName":"长腿七哥","accType":3,"headUrl":"http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg","userNo":"1823458132"}],"category":"762066dfa93f4f79a64a9b14770e0da9","cover":{"format":"webp","height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125},"createTime":"2017-01-16 16:42:28","description":"淘宝店铺：查理uncle / 微信：ctqg007","deviceId":"7CA7DE6E-C93E-47F1-BC83-80EADA6F9178","fansNum":2109,"finishType":3,"gender":1,"hair":{"id":"4","name":"短发"},"head":{"format":"webp","height":0,"key":"http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg","url":"http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg","webUrl":"//tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg","width":0},"height":"183","id":"0d665809a26845a6923df2a7bb288b38","instagramInfo":"","magazineNum":1,"mainType":3,"matchNum":51,"name":"it-7","praise":0,"praiseNum":2,"subjectNum":0,"taobaoInfo":"","type":4,"unUsedNum":0,"userOperationNum":9,"userTitle":"6","userTitleDesc":"品牌主理人","weiboFansNum":0,"weiboInfo":"http://m.weibo.cn/u/1823458132","weight":"63","weixinInfo":"ctqg007","youkuInfo":"","youtubeInfo":""},"weight":"63"}
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
        private int hotSort;
        private String id;
        private boolean isAddMagazine;
        private boolean isPraise;
        private String linkUrl;
        private int lookCount;
        private PictureBean picture;
        private int pictureCount;
        private int praiseCount;
        private int prodCount;
        private String prodId;
        private int recommonedSize;
        private String showTime;
        private UserBean user;
        private String weight;
        private List<ProdListBean> prodList;

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

        public int getHotSort() {
            return hotSort;
        }

        public void setHotSort(int hotSort) {
            this.hotSort = hotSort;
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

        public int getProdCount() {
            return prodCount;
        }

        public void setProdCount(int prodCount) {
            this.prodCount = prodCount;
        }

        public String getProdId() {
            return prodId;
        }

        public void setProdId(String prodId) {
            this.prodId = prodId;
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

        public List<ProdListBean> getProdList() {
            return prodList;
        }

        public void setProdList(List<ProdListBean> prodList) {
            this.prodList = prodList;
        }

        public static class PictureBean {
            /**
             * compress : large
             * height : 2000
             * key : Fqm_G-Tbz8L-K7cF1eGb55ns3luh
             * url : http://img.nothing.la/Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/thumbnail/1000000@
             * webUrl : //img.nothing.la/Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/thumbnail/1000000@
             * width : 2000
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
             * allRankSort : 0
             * attentionNum : 2
             * bilibiliInfo :
             * binds : [{"accName":"长腿七哥","accType":3,"headUrl":"http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg","userNo":"1823458132"}]
             * category : 762066dfa93f4f79a64a9b14770e0da9
             * cover : {"format":"webp","height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125}
             * createTime : 2017-01-16 16:42:28
             * description : 淘宝店铺：查理uncle / 微信：ctqg007
             * deviceId : 7CA7DE6E-C93E-47F1-BC83-80EADA6F9178
             * fansNum : 2109
             * finishType : 3
             * gender : 1
             * hair : {"id":"4","name":"短发"}
             * head : {"format":"webp","height":0,"key":"http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg","url":"http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg","webUrl":"//tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg","width":0}
             * height : 183
             * id : 0d665809a26845a6923df2a7bb288b38
             * instagramInfo :
             * magazineNum : 1
             * mainType : 3
             * matchNum : 51
             * name : it-7
             * praise : 0
             * praiseNum : 2
             * subjectNum : 0
             * taobaoInfo :
             * type : 4
             * unUsedNum : 0
             * userOperationNum : 9
             * userTitle : 6
             * userTitleDesc : 品牌主理人
             * weiboFansNum : 0
             * weiboInfo : http://m.weibo.cn/u/1823458132
             * weight : 63
             * weixinInfo : ctqg007
             * youkuInfo :
             * youtubeInfo :
             */

            private int allRankSort;
            private int attentionNum;
            private String bilibiliInfo;
            private String category;
            private CoverBean cover;
            private String createTime;
            private String description;
            private String deviceId;
            private int fansNum;
            private int finishType;
            private int gender;
            private HairBean hair;
            private HeadBean head;
            private String height;
            private String id;
            private String instagramInfo;
            private int magazineNum;
            private int mainType;
            private int matchNum;
            private String name;
            private int praise;
            private int praiseNum;
            private int subjectNum;
            private String taobaoInfo;
            private int type;
            private int unUsedNum;
            private int userOperationNum;
            private String userTitle;
            private String userTitleDesc;
            private int weiboFansNum;
            private String weiboInfo;
            private String weight;
            private String weixinInfo;
            private String youkuInfo;
            private String youtubeInfo;
            private List<BindsBean> binds;

            public int getAllRankSort() {
                return allRankSort;
            }

            public void setAllRankSort(int allRankSort) {
                this.allRankSort = allRankSort;
            }

            public int getAttentionNum() {
                return attentionNum;
            }

            public void setAttentionNum(int attentionNum) {
                this.attentionNum = attentionNum;
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

            public int getFansNum() {
                return fansNum;
            }

            public void setFansNum(int fansNum) {
                this.fansNum = fansNum;
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

            public int getMagazineNum() {
                return magazineNum;
            }

            public void setMagazineNum(int magazineNum) {
                this.magazineNum = magazineNum;
            }

            public int getMainType() {
                return mainType;
            }

            public void setMainType(int mainType) {
                this.mainType = mainType;
            }

            public int getMatchNum() {
                return matchNum;
            }

            public void setMatchNum(int matchNum) {
                this.matchNum = matchNum;
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

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getSubjectNum() {
                return subjectNum;
            }

            public void setSubjectNum(int subjectNum) {
                this.subjectNum = subjectNum;
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

            public int getUnUsedNum() {
                return unUsedNum;
            }

            public void setUnUsedNum(int unUsedNum) {
                this.unUsedNum = unUsedNum;
            }

            public int getUserOperationNum() {
                return userOperationNum;
            }

            public void setUserOperationNum(int userOperationNum) {
                this.userOperationNum = userOperationNum;
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

            public List<BindsBean> getBinds() {
                return binds;
            }

            public void setBinds(List<BindsBean> binds) {
                this.binds = binds;
            }

            public static class CoverBean {
                /**
                 * format : webp
                 * height : 2001
                 * key : default_cover.png
                 * url : http://img.nothing.la/default_cover.png
                 * webUrl : //img.nothing.la/default_cover.png
                 * width : 1125
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
                 * height : 0
                 * key : http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg
                 * url : http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg
                 * webUrl : //tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg
                 * width : 0
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

            public static class BindsBean {
                /**
                 * accName : 长腿七哥
                 * accType : 3
                 * headUrl : http://tva2.sinaimg.cn/crop.2.0.508.508.180/6cafc354jw8f82f7t9eqkj20e80e4jrn.jpg
                 * userNo : 1823458132
                 */

                private String accName;
                private int accType;
                private String headUrl;
                private String userNo;

                public String getAccName() {
                    return accName;
                }

                public void setAccName(String accName) {
                    this.accName = accName;
                }

                public int getAccType() {
                    return accType;
                }

                public void setAccType(int accType) {
                    this.accType = accType;
                }

                public String getHeadUrl() {
                    return headUrl;
                }

                public void setHeadUrl(String headUrl) {
                    this.headUrl = headUrl;
                }

                public String getUserNo() {
                    return userNo;
                }

                public void setUserNo(String userNo) {
                    this.userNo = userNo;
                }
            }
        }

        public static class ProdListBean {
            /**
             * brandId : a195fe54e9194106ba7791af01169a40
             * brandName : 查理UNCLE
             * buyType : 1
             * buyurl : https://item.taobao.com/item.htm?ut_sk=1.VXtxN5rjjUwDAIO1ooCLwGDU_21380790_1495934066606.Copy.1&id=551734599864&sourceType=item&price=138&suid=E83441AB-4C21-4EDC-B1AF-7B38FB1E963D&un=dae6cde2d3519ac87a811649f8da3e26&share_crt_v=1&cpp=1&shareurl=true&spm=a313p.22.mj.40744908294&short_name=h.ShtNJE
             * categoryId : b99e86d3c4444546b06da8535cee16a8
             * categoryName : 短裤
             * colorId : 6e4d1f4b68d24d4f922f0ca3da641152
             * colorName : 黑色系
             * currency : 1
             * id : 526e1d3fa3e14789bdc31d18c9740357
             * name : 查理uncle/短裤/黑色系
             * picture : {"compress":"medium","height":1000,"key":"Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/crop/!2000x1000a0a475","url":"http://img.nothing.la/Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/crop/!2000x1000a0a475/thumbnail/600x","webUrl":"//img.nothing.la/Fqm_G-Tbz8L-K7cF1eGb55ns3luh?imageMogr2/crop/!2000x1000a0a475/thumbnail/600x","width":2000}
             * shop : {}
             * sourceName : 淘宝
             * taobaoCode : 551734599864
             */

            private String brandId;
            private String brandName;
            private int buyType;
            private String buyurl;
            private String categoryId;
            private String categoryName;
            private String colorId;
            private String colorName;
            private int currency;
            private String id;
            private String name;
            private PictureBean picture;
            private ShopBean shop;
            private String sourceName;
            private String taobaoCode;

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

            public static class PictureBeanX {
            }

            public static class ShopBean {
            }
        }
    }
}
