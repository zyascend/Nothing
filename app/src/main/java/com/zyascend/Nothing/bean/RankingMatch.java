package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/25 15:17
 * 邮箱：zyascend@qq.com
 */

public class RankingMatch {

    /**
     * id : 13d7b41cf090486686e218397d60c8a7
     * match : {"commCount":0,"forwordCount":0,"hotNum":87,"id":"13d7b41cf090486686e218397d60c8a7","isAddMagazine":false,"isPraise":false,"lookCount":0,"picture":{"compress":"medium","height":2666,"key":"Fntq3qy3jdSrIzdgAXQ3jU4hJf2t","url":"http://img.nothing.la/Fntq3qy3jdSrIzdgAXQ3jU4hJf2t?imageMogr2/thumbnail/600x","webUrl":"//img.nothing.la/Fntq3qy3jdSrIzdgAXQ3jU4hJf2t?imageMogr2/thumbnail/600x","width":2000},"pictureCount":1,"praiseCount":0,"recommonedSize":100,"userId":"38e4fd335f1a49338e469f31814d9277","vPraiseCount":26}
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
        private int forwordCount;
        private int hotNum;
        private String id;
        private boolean isAddMagazine;
        private boolean isPraise;
        private int lookCount;
        private PictureBean picture;
        private int pictureCount;
        private int praiseCount;
        private int recommonedSize;
        private String userId;
        private int vPraiseCount;

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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getVPraiseCount() {
            return vPraiseCount;
        }

        public void setVPraiseCount(int vPraiseCount) {
            this.vPraiseCount = vPraiseCount;
        }

        public static class PictureBean {
            /**
             * compress : medium
             * height : 2666
             * key : Fntq3qy3jdSrIzdgAXQ3jU4hJf2t
             * url : http://img.nothing.la/Fntq3qy3jdSrIzdgAXQ3jU4hJf2t?imageMogr2/thumbnail/600x
             * webUrl : //img.nothing.la/Fntq3qy3jdSrIzdgAXQ3jU4hJf2t?imageMogr2/thumbnail/600x
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
    }
}
