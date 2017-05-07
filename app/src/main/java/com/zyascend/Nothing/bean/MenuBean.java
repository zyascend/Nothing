package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 16:14
 * 邮箱：zyascend@qq.com
 */

public class MenuBean {

    /**
     * categoryId :
     * clientData : {"type":20}
     * createTime : 2016-08-24 16:05:31
     * description :
     * id : 8a03336dc59811e6b0638cdcd4b1d4f8
     * menuType : 6
     * name : 主编推荐
     * picType : 1
     * picture : {"height":300,"key":"419ae7c1ec3c46648fedab8435125eb9","url":"http://img.nothing.la/419ae7c1ec3c46648fedab8435125eb9","webUrl":"//img.nothing.la/419ae7c1ec3c46648fedab8435125eb9","width":300}
     * sourceType : 0
     * subName : 时髦单品合集
     * updateTime : 2017-05-02 09:57:41
     */

    private String categoryId;
    private String clientData;
    private String createTime;
    private String description;
    private String id;
    private int menuType;
    private String name;
    private int picType;
    private PictureBean picture;
    private int sourceType;
    private String subName;
    private String updateTime;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

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

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicType() {
        return picType;
    }

    public void setPicType(int picType) {
        this.picType = picType;
    }

    public PictureBean getPicture() {
        return picture;
    }

    public void setPicture(PictureBean picture) {
        this.picture = picture;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public static class PictureBean {
        /**
         * height : 300
         * key : 419ae7c1ec3c46648fedab8435125eb9
         * url : http://img.nothing.la/419ae7c1ec3c46648fedab8435125eb9
         * webUrl : //img.nothing.la/419ae7c1ec3c46648fedab8435125eb9
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
