package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/26 14:21
 * 邮箱：zyascend@qq.com
 */

public class ProductMenu {

    /**
     * categoryId : 6310b10e019447468992a96d8635bfc0
     * clientData : {"did":"ad213811841549cfa9f2b851b1a537c0","name":"裤装","type":21}
     * createTime : 2016-08-24 10:35:47
     * description :
     * id : ad213811841549cfa9f2b851b1a537c0
     * menuType : 2
     * name : 裤装
     * picType : 1
     * picture : {"height":300,"key":"e1eaacaf1c43425b951ea3341c96d405","url":"http://img.nothing.la/e1eaacaf1c43425b951ea3341c96d405","webUrl":"//img.nothing.la/e1eaacaf1c43425b951ea3341c96d405","width":300}
     * sourceType : 0
     * subName : 裤装
     * updateTime : 2017-05-10 18:51:17
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
         * key : e1eaacaf1c43425b951ea3341c96d405
         * url : http://img.nothing.la/e1eaacaf1c43425b951ea3341c96d405
         * webUrl : //img.nothing.la/e1eaacaf1c43425b951ea3341c96d405
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
