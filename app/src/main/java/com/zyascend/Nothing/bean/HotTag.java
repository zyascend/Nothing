package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/24 15:46
 * 邮箱：zyascend@qq.com
 */

public class HotTag {

    private String content;
    private CoverPictureBean coverPicture;
    private int hotNum;
    private int hotType;
    private String id;
    private String name;
    private PictureBean picture;
    private String shareUrl;
    private int type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CoverPictureBean getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(CoverPictureBean coverPicture) {
        this.coverPicture = coverPicture;
    }

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

    public static class CoverPictureBean {
        /**
         * height : 0
         * key : tag_51a49d18eb714e0cb62b882e76ff2106.png
         * url : http://img.nothing.la/tag_51a49d18eb714e0cb62b882e76ff2106.png
         * webUrl : //img.nothing.la/tag_51a49d18eb714e0cb62b882e76ff2106.png
         * width : 750
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
         * height : 300
         * key : tag_c09a8a981c694821b9626af31180e6ef.png
         * rgb : #9e271d
         * url : http://img.nothing.la/tag_c09a8a981c694821b9626af31180e6ef.png
         * webUrl : //img.nothing.la/tag_c09a8a981c694821b9626af31180e6ef.png
         * width : 300
         */

        private int height;
        private String key;
        private String rgb;
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

        public String getRgb() {
            return rgb;
        }

        public void setRgb(String rgb) {
            this.rgb = rgb;
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
