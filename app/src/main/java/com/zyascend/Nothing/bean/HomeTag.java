package com.zyascend.Nothing.bean;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 13:06
 * 邮箱：zyascend@qq.com
 */

public class HomeTag {
            private int hotNum;
            private int hotType;
            private String id;
            private String name;
            private PictureBean picture;
            private String shareUrl;

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

            public static class PictureBean {
                /**
                 * height : 620
                 * key : tag_rixi.jpg
                 * url : http://img.nothing.la/tag_rixi.jpg
                 * webUrl : //img.nothing.la/tag_rixi.jpg
                 * width : 620
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
