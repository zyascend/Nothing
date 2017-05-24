package com.zyascend.Nothing.bean;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/24 16:06
 * 邮箱：zyascend@qq.com
 */

public class ListData<T> {

    private boolean hasNextPage;
    private int pageSize;
    private List<T> list;

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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
