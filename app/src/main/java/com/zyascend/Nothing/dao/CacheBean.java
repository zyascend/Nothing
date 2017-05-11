package com.zyascend.Nothing.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 功能：
 * 作者：zyascend on 2017/5/10 23:04
 * 邮箱：zyascend@qq.com
 */
@Entity
public class CacheBean {

    /**
     * 缓存有效时间一小时
     */
    private static final long EXPIRE_LIMIT = 60 * 60 * 1000;

    @Index(unique = true)
    private String cache_type;
    private String json_content;
    private long create_time;

    public CacheBean(String cache_type, String json_content) {
        this.cache_type = cache_type;
        this.json_content = json_content;
        this.create_time = System.currentTimeMillis();
    }

    @Generated(hash = 352799345)
    public CacheBean(String cache_type, String json_content, long create_time) {
        this.cache_type = cache_type;
        this.json_content = json_content;
        this.create_time = create_time;
    }

    @Generated(hash = 573552170)
    public CacheBean() {
    }

    /**
     * 在{@link #EXPIRE_LIMIT}时间之内有效，过期作废
     * @return true 表示过期
     */
    public boolean isExpire() {
        return System.currentTimeMillis() - create_time > EXPIRE_LIMIT;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public String getJson_content() {
        return this.json_content;
    }

    public void setJson_content(String json_content) {
        this.json_content = json_content;
    }

    public String getCache_type() {
        return this.cache_type;
    }

    public void setCache_type(String cache_type) {
        this.cache_type = cache_type;
    }
}
