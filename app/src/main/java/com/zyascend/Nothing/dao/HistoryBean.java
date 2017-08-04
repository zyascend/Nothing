package com.zyascend.Nothing.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 功能：
 * 作者：zyascend on 2017/8/4 16:52
 * 邮箱：zyascend@qq.com
 */
@Entity
public class HistoryBean {
    @Index(unique = true)
    private String word;

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Generated(hash = 1549111627)
    public HistoryBean(String word) {
        this.word = word;
    }

    @Generated(hash = 48590348)
    public HistoryBean() {
    }
}
