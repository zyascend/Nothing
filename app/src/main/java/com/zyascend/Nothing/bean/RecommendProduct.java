package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/7/18 10:43
 * 邮箱：zyascend@qq.com
 */

public class RecommendProduct {

    /**
     * brandId : 146fc956c0fc401993685105a45232f1
     * brandName : square X circle
     * buyurl : https://item.taobao.com/item.htm?spm=a1z10.3-c-s.w4002-16426043917.80.58c565d4KAFd7v&id=552714889157
     * categoryId : 011b762431f742adaf89e71a1f192865
     * categoryName : 连衣裙
     * colorId : f481f09cb32e41e98e21606ef204045d
     * colorName : 白色系
     * currency : 1
     * description :
     * id : 006a7b2cfc854f22aff139014a591d66
     * name : square X circle原创设计 棉麻连衣裙
     * picture : {"compress":"medium","height":750,"key":"39da7ec746384b39ba907a7c911f0ed0","url":"http://img.nothing.la/39da7ec746384b39ba907a7c911f0ed0?imageMogr2/thumbnail/600x","webUrl":"//img.nothing.la/39da7ec746384b39ba907a7c911f0ed0?imageMogr2/thumbnail/600x","width":750}
     * price : 299
     * shop : {}
     * sourceName : 淘宝
     * sourceType : 2
     * taobaoCode : 552714889157
     */

    private String brandId;
    private String brandName;
    private String buyurl;
    private String categoryId;
    private String categoryName;
    private String colorId;
    private String colorName;
    private int currency;
    private String description;
    private String id;
    private String name;
    private PictureBean picture;
    private int price;
    private ShopBean shop;
    private String sourceName;
    private int sourceType;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public String getTaobaoCode() {
        return taobaoCode;
    }

    public void setTaobaoCode(String taobaoCode) {
        this.taobaoCode = taobaoCode;
    }

    public static class PictureBean {
        /**
         * compress : medium
         * height : 750
         * key : 39da7ec746384b39ba907a7c911f0ed0
         * url : http://img.nothing.la/39da7ec746384b39ba907a7c911f0ed0?imageMogr2/thumbnail/600x
         * webUrl : //img.nothing.la/39da7ec746384b39ba907a7c911f0ed0?imageMogr2/thumbnail/600x
         * width : 750
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

    public static class ShopBean {
    }
}
