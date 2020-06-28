package com.ztf.core.repository;

import com.ztf.core.model.IModel;
/*
数据仓库的基类
 */
public abstract class Repository<T extends IModel> {
    protected T mModel;
    //业务Model
    public Repository() {
        mModel = createModel();
    }
    //创建业务Model
    protected abstract T createModel();
}
