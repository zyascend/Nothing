package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/29 10:50
 * 邮箱：zyascend@qq.com
 */

public class HotMatch {

    /**
     * id : d4979bc4b69b481e895e8fe549be44e3
     * match : {"commCount":0,"forwordCount":0,"hotNum":0,"id":"d4979bc4b69b481e895e8fe549be44e3","isAddMagazine":false,"isPraise":false,"lookCount":0,"maxHonor":5,"maxHonorPic":{"height":74,"key":"match_honor_icon_v2_04.png","url":"http://img.nothing.la/match_honor_icon_v2_04.png","webUrl":"//img.nothing.la/match_honor_icon_v2_04.png","width":74},"picture":{"height":2988,"key":"FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x","url":"http://img.nothing.la/FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x","webUrl":"//img.nothing.la/FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x","width":1681},"pictureCount":1,"praiseCount":0,"recommonedSize":100,"user":{"cover":{"height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125},"description":"","fansNum":497,"finishType":1,"gender":-1,"head":{"height":600,"key":"head_50ec3d20d2004a8d85ad0c3097742356.png","url":"http://img.nothing.la/head_50ec3d20d2004a8d85ad0c3097742356.png","webUrl":"//img.nothing.la/head_50ec3d20d2004a8d85ad0c3097742356.png","width":600},"id":"4891d133b18a4bccb3fa5e0a798b2bac","matchNum":6,"name":"陈乐乐的陈乐乐","praise":0,"praiseNum":468,"type":2,"userTitleDesc":""}}
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
        /**
         * commCount : 0
         * forwordCount : 0
         * hotNum : 0
         * id : d4979bc4b69b481e895e8fe549be44e3
         * isAddMagazine : false
         * isPraise : false
         * lookCount : 0
         * maxHonor : 5
         * maxHonorPic : {"height":74,"key":"match_honor_icon_v2_04.png","url":"http://img.nothing.la/match_honor_icon_v2_04.png","webUrl":"//img.nothing.la/match_honor_icon_v2_04.png","width":74}
         * picture : {"height":2988,"key":"FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x","url":"http://img.nothing.la/FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x","webUrl":"//img.nothing.la/FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x","width":1681}
         * pictureCount : 1
         * praiseCount : 0
         * recommonedSize : 100
         * user : {"cover":{"height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125},"description":"","fansNum":497,"finishType":1,"gender":-1,"head":{"height":600,"key":"head_50ec3d20d2004a8d85ad0c3097742356.png","url":"http://img.nothing.la/head_50ec3d20d2004a8d85ad0c3097742356.png","webUrl":"//img.nothing.la/head_50ec3d20d2004a8d85ad0c3097742356.png","width":600},"id":"4891d133b18a4bccb3fa5e0a798b2bac","matchNum":6,"name":"陈乐乐的陈乐乐","praise":0,"praiseNum":468,"type":2,"userTitleDesc":""}
         */

        private int commCount;
        private int forwordCount;
        private int hotNum;
        private String id;
        private boolean isAddMagazine;
        private boolean isPraise;
        private int lookCount;
        private int maxHonor;
        private MaxHonorPicBean maxHonorPic;
        private PictureBean picture;
        private int pictureCount;
        private int praiseCount;
        private int recommonedSize;
        private UserBean user;

        public int getCommCount() {
            return commCount;
        }

        public void setCommCount(int commCount) {
            this.commCount = commCount;
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

        public MaxHonorPicBean getMaxHonorPic() {
            return maxHonorPic;
        }

        public void setMaxHonorPic(MaxHonorPicBean maxHonorPic) {
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

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class MaxHonorPicBean {
            /**
             * height : 74
             * key : match_honor_icon_v2_04.png
             * url : http://img.nothing.la/match_honor_icon_v2_04.png
             * webUrl : //img.nothing.la/match_honor_icon_v2_04.png
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
             * height : 2988
             * key : FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x
             * url : http://img.nothing.la/FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x
             * webUrl : //img.nothing.la/FiBtz_l04wrWAxlYGtxzWomD6uDM?imageMogr2/thumbnail/600x
             * width : 1681
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

        public static class UserBean {
            /**
             * cover : {"height":2001,"key":"default_cover.png","url":"http://img.nothing.la/default_cover.png","webUrl":"//img.nothing.la/default_cover.png","width":1125}
             * description :
             * fansNum : 497
             * finishType : 1
             * gender : -1
             * head : {"height":600,"key":"head_50ec3d20d2004a8d85ad0c3097742356.png","url":"http://img.nothing.la/head_50ec3d20d2004a8d85ad0c3097742356.png","webUrl":"//img.nothing.la/head_50ec3d20d2004a8d85ad0c3097742356.png","width":600}
             * id : 4891d133b18a4bccb3fa5e0a798b2bac
             * matchNum : 6
             * name : 陈乐乐的陈乐乐
             * praise : 0
             * praiseNum : 468
             * type : 2
             * userTitleDesc :
             */

            private CoverBean cover;
            private String description;
            private int fansNum;
            private int finishType;
            private int gender;
            private HeadBean head;
            private String id;
            private int matchNum;
            private String name;
            private int praise;
            private int praiseNum;
            private int type;
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
                 * height : 600
                 * key : head_50ec3d20d2004a8d85ad0c3097742356.png
                 * url : http://img.nothing.la/head_50ec3d20d2004a8d85ad0c3097742356.png
                 * webUrl : //img.nothing.la/head_50ec3d20d2004a8d85ad0c3097742356.png
                 * width : 600
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
