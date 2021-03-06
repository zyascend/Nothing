package com.zyascend.Nothing.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.zyascend.Nothing.dao.CacheBean;
import com.zyascend.Nothing.dao.HistoryBean;

import com.zyascend.Nothing.dao.CacheBeanDao;
import com.zyascend.Nothing.dao.HistoryBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cacheBeanDaoConfig;
    private final DaoConfig historyBeanDaoConfig;

    private final CacheBeanDao cacheBeanDao;
    private final HistoryBeanDao historyBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cacheBeanDaoConfig = daoConfigMap.get(CacheBeanDao.class).clone();
        cacheBeanDaoConfig.initIdentityScope(type);

        historyBeanDaoConfig = daoConfigMap.get(HistoryBeanDao.class).clone();
        historyBeanDaoConfig.initIdentityScope(type);

        cacheBeanDao = new CacheBeanDao(cacheBeanDaoConfig, this);
        historyBeanDao = new HistoryBeanDao(historyBeanDaoConfig, this);

        registerDao(CacheBean.class, cacheBeanDao);
        registerDao(HistoryBean.class, historyBeanDao);
    }
    
    public void clear() {
        cacheBeanDaoConfig.clearIdentityScope();
        historyBeanDaoConfig.clearIdentityScope();
    }

    public CacheBeanDao getCacheBeanDao() {
        return cacheBeanDao;
    }

    public HistoryBeanDao getHistoryBeanDao() {
        return historyBeanDao;
    }

}
