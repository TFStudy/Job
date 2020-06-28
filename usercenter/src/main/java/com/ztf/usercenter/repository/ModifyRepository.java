package com.ztf.usercenter.repository;

import androidx.lifecycle.LiveData;
import com.ztf.core.repository.Repository;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.entity.Yzm;
import com.ztf.usercenter.model.ModifyModel;

public class ModifyRepository extends Repository<ModifyModel> {
    @Override
    protected ModifyModel createModel() {
        return new ModifyModel();
    }
    //注册方法
    public LiveData<BaseRespEntity> modify(Yzm userEntity){
        /**
         * 无网络
         * 可以选择加载本地数据（sqlite  sp  file  lrucache）
         */
         return mModel.modify(userEntity);
    }
    //注册方法
    public LiveData<BaseRespEntity> yzm(String userEntity){
        /**
         * 无网络
         * 可以选择加载本地数据（sqlite  sp  file  lrucache）
         */
        return mModel.getYzm(userEntity);
    }
}