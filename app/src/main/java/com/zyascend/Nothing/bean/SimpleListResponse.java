package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/2 12:34
 * 邮箱：zyascend@qq.com
 */

public class SimpleListResponse<T> extends BaseResponse{


    /**
     * DATA : {"list":[{"hotNum":0,"hotType":1,"id":"77dc5e1c71b011e59199ecf4bbd6a89c","name":"日系","picture":{"height":620,"key":"tag_rixi.jpg","url":"http://img.nothing.la/tag_rixi.jpg","webUrl":"//img.nothing.la/tag_rixi.jpg","width":620},"shareUrl":"http://api.nothing.la/nothing/share/tag.html?id=77dc5e1c71b011e59199ecf4bbd6a89c&title=%E6%97%A5%E7%B3%BB"},{"hotNum":0,"hotType":1,"id":"c91d9e9e8d6a4cfd98cfcf23aafe218a","name":"中性","picture":{"height":480,"key":"tag_zhongxin.jpg","url":"http://img.nothing.la/tag_zhongxin.jpg","webUrl":"//img.nothing.la/tag_zhongxin.jpg","width":480},"shareUrl":"http://api.nothing.la/nothing/share/tag.html?id=c91d9e9e8d6a4cfd98cfcf23aafe218a&title=%E4%B8%AD%E6%80%A7"},{"hotNum":0,"hotType":1,"id":"2711be8ae64c421da97a03fc72ed3bb2","name":"极简","picture":{"height":500,"key":"tag_b2a0c53172d44130ac5133b43a6458d6.png","url":"http://img.nothing.la/tag_b2a0c53172d44130ac5133b43a6458d6.png","webUrl":"//img.nothing.la/tag_b2a0c53172d44130ac5133b43a6458d6.png","width":200},"shareUrl":"http://api.nothing.la/nothing/share/tag.html?id=2711be8ae64c421da97a03fc72ed3bb2&title=%E6%9E%81%E7%AE%80"}]}
     */

    private Data<T> DATA;

    public Data<T> getDATA() {
        return DATA;
    }

    public void setDATA(Data<T> DATA) {
        this.DATA = DATA;
    }

    public static class Data<T> {
        private List<T> list;

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }

    }
}
