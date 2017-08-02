package com.zyascend.Nothing.bean;

import com.alibaba.fastjson.JSON;

/**
 * 功能：首页便签页面
 * 作者：zyascend on 2017/7/15 09:38
 * 邮箱：zyascend@qq.com
 */

public class ChildTag {

    /**
     * id : 363327e3ca634608a76c1b0974467602
     * name : 衬衫依赖症
     * showLine : 1
     */

    private String id;
    private String name;
    private int showLine;

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

    public int getShowLine() {
        return showLine;
    }

    public void setShowLine(int showLine) {
        this.showLine = showLine;
    }

    //
    @Override
    public String toString() {
        return "{\"id\":\"" +
                id +
                "\",\"line\":" +
                showLine +
                ",\"name\":\"" +
                name +
                "\"}";
    }
}
