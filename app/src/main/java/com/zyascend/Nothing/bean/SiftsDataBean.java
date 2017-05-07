package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/3 10:56
 * 邮箱：zyascend@qq.com
 */

public class SiftsDataBean {

    /**
     * firstTime : 2017-05-03 10:39:44
     * hasNextPage : true
     * list : []
     * pageSize : 15
     * updateCount : 14
     */

    private String firstTime;
    private boolean hasNextPage;
    private int pageSize;
    private int updateCount;
    private List<SiftsBean> list;

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    public List<SiftsBean> getList() {
        return list;
    }

    public void setList(List<SiftsBean> list) {
        this.list = list;
    }
}
