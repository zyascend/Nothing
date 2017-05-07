package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 16:10
 * 邮箱：zyascend@qq.com
 */

public class BannerBean {

    /**
     * clientData : {"type":8,"url":"http://api.nothing.la/other/banner.html?id=90cf701c13c84010a9db85c2567e2388&title=%E8%AF%9D%E9%A2%98%E6%B4%BB%E5%8A%A8%E8%8E%B7%E5%A5%96%E5%90%8D%E5%8D%95+%23%E7%96%AF%E5%90%83%E6%97%B6%E4%BB%A3&sourcemodel=banner"}
     * createTime : 2017-05-02 16:01:35
     * id : 1b69c0c3b54b43d49bac65561506561e
     * picture : {"height":360,"key":"5a27de56567740ac9d5f638781f982f2","url":"http://img.nothing.la/5a27de56567740ac9d5f638781f982f2","webUrl":"//img.nothing.la/5a27de56567740ac9d5f638781f982f2","width":750}
     * title : 话题活动获奖名单 #疯吃时代
     */

    private String clientData;
    private String createTime;
    private String id;
    private PictureBean picture;
    private String title;

    public String getClientData() {
        return clientData;
    }

    public void setClientData(String clientData) {
        this.clientData = clientData;
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

    public PictureBean getPicture() {
        return picture;
    }

    public void setPicture(PictureBean picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class PictureBean {
        /**
         * height : 360
         * key : 5a27de56567740ac9d5f638781f982f2
         * url : http://img.nothing.la/5a27de56567740ac9d5f638781f982f2
         * webUrl : //img.nothing.la/5a27de56567740ac9d5f638781f982f2
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
}
