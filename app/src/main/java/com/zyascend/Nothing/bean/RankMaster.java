package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 11:00
 * 邮箱：zyascend@qq.com
 */

public class RankMaster {


    private int attentionStatus;
    private CoverBean cover;
    private String description;
    private int fansNum;
    private int finishType;
    private int gender;
    private HeadBean head;
    private String id;
    private int matchNum;
    private int maxHonor;
    private MaxHonorPicBean maxHonorPic;
    private String name;
    private int praise;
    private int praiseNum;
    private int type;
    private String userTitleDesc;
    private List<DynamicsBean> dynamics;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    public int getMaxHonor() {
        return maxHonor;
    }

    public void setMaxHonor(int maxHonor) {
        this.maxHonor = maxHonor;
    }

    public MaxHonorPicBean getMaxHonorPic() {
        return maxHonorPic;
    }

    public void setMaxHonorPic(MaxHonorPicBean maxHonorPic) {
        this.maxHonorPic = maxHonorPic;
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

    public List<DynamicsBean> getDynamics() {
        return dynamics;
    }

    public void setDynamics(List<DynamicsBean> dynamics) {
        this.dynamics = dynamics;
    }

    public static class CoverBean {
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

    public static class HeadBean {
        /**
         * height : 900
         * key : head_3398228020604fdda0bf152a1aa706f2.png
         * url : http://img.nothing.la/head_3398228020604fdda0bf152a1aa706f2.png
         * webUrl : //img.nothing.la/head_3398228020604fdda0bf152a1aa706f2.png
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

    public static class MaxHonorPicBean {
        /**
         * height : 74
         * key : match_honor_icon_v2_01.png
         * url : http://img.nothing.la/match_honor_icon_v2_01.png
         * webUrl : //img.nothing.la/match_honor_icon_v2_01.png
         * width : 74
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

    public static class DynamicsBean {
        /**
         * createTime : 2016-07-29 13:19:43
         * id : e2f299d3f68449e698ada99717a08506
         * match : {"commCount":0,"createTime":"2016-07-29 13:19:43","description":"小黄人","forwordCount":0,"hotNum":0,"id":"e2f299d3f68449e698ada99717a08506","isAddMagazine":false,"isPraise":false,"lookCount":0,"maxHonor":2,"maxHonorPic":{"height":74,"key":"match_honor_icon_v2_02.png","url":"http://img.nothing.la/match_honor_icon_v2_02.png","webUrl":"//img.nothing.la/match_honor_icon_v2_02.png","width":74},"picture":{"compress":"medium","height":2901,"key":"null_2b44111ee66044f6a8720b3dc634375e.png","url":"http://img.nothing.la/null_2b44111ee66044f6a8720b3dc634375e.png?imageMogr2/thumbnail/600x","webUrl":"//img.nothing.la/null_2b44111ee66044f6a8720b3dc634375e.png?imageMogr2/thumbnail/600x","width":2176},"pictureCount":1,"praiseCount":301,"recommonedSize":100,"showTime":"2016-07-29 13:19","user":{"cover":{"height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125},"description":"","finishType":1,"gender":-1,"head":{"height":120,"key":"default_head.png","url":"http://img.nothing.la/default_head.png","webUrl":"//img.nothing.la/default_head.png","width":120},"id":"e4d56806f62f4c2d8aeae82be0f6ca5e","name":"","praise":0,"userTitleDesc":""}}
         * type : 1
         */

        private String createTime;
        private String id;
        private MatchBean match;
        private int type;

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

        public MatchBean getMatch() {
            return match;
        }

        public void setMatch(MatchBean match) {
            this.match = match;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public static class MatchBean {


            private int commCount;
            private String createTime;
            private String description;
            private int forwordCount;
            private int hotNum;
            private String id;
            private boolean isAddMagazine;
            private boolean isPraise;
            private int lookCount;
            private int maxHonor;
            private MaxHonorPicBeanX maxHonorPic;
            private PictureBean picture;
            private int pictureCount;
            private int praiseCount;
            private int recommonedSize;
            private String showTime;
            private UserBean user;

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

            public int getLookCount() {
                return lookCount;
            }

            public void setLookCount(int lookCount) {
                this.lookCount = lookCount;
            }

            public int getMaxHonor() {
                return maxHonor;
            }

            public void setMaxHonor(int maxHonor) {
                this.maxHonor = maxHonor;
            }

            public MaxHonorPicBeanX getMaxHonorPic() {
                return maxHonorPic;
            }

            public void setMaxHonorPic(MaxHonorPicBeanX maxHonorPic) {
                this.maxHonorPic = maxHonorPic;
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

            public static class MaxHonorPicBeanX {
                /**
                 * height : 74
                 * key : match_honor_icon_v2_02.png
                 * url : http://img.nothing.la/match_honor_icon_v2_02.png
                 * webUrl : //img.nothing.la/match_honor_icon_v2_02.png
                 * width : 74
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

            public static class PictureBean {
                /**
                 * compress : medium
                 * height : 2901
                 * key : null_2b44111ee66044f6a8720b3dc634375e.png
                 * url : http://img.nothing.la/null_2b44111ee66044f6a8720b3dc634375e.png?imageMogr2/thumbnail/600x
                 * webUrl : //img.nothing.la/null_2b44111ee66044f6a8720b3dc634375e.png?imageMogr2/thumbnail/600x
                 * width : 2176
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

                private CoverBean cover;
                private String description;
                private int finishType;
                private int gender;
                private HeadBean head;
                private String id;
                private String name;
                private int praise;
                private String userTitleDesc;

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
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

                public HeadBean getHead() {
                    return head;
                }

                public void setHead(HeadBean head) {
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

            }
        }
    }
}
