package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/26 14:39
 * 邮箱：zyascend@qq.com
 */

public class ProdBox {



    private String createTime;
    private String description;
    private String id;
    private String name;
    private PictureBean picture;
    private List<ProductsBean> products;

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

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public static class PictureBean {
        /**
         * compress : large
         * height : 360
         * key : 4bbfde9a05b14712ab30b092d7984803
         * url : http://img.nothing.la/4bbfde9a05b14712ab30b092d7984803?imageMogr2/thumbnail/1000000@
         * webUrl : //img.nothing.la/4bbfde9a05b14712ab30b092d7984803?imageMogr2/thumbnail/1000000@
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

    public static class ProductsBean {


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
        private int numId;
        private PictureBean picture;
        private int price;
        private ShopBean shop;
        private String sourceName;
        private String taobaoCode;
        private int type;
        private String subName;

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

        public int getNumId() {
            return numId;
        }

        public void setNumId(int numId) {
            this.numId = numId;
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

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public static class PictureBeanX {
        }

        public static class ShopBean {
        }
    }
}
