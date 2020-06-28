package com.ztf.usercenter.repository;

import androidx.lifecycle.LiveData;
import com.ztf.core.repository.Repository;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.entity.UserEntity;
import com.ztf.usercenter.model.RegModel;

public class RegRepository extends Repository<RegModel> {
    @Override
    protected RegModel createModel() {
        return new RegModel();
    }
    //注册方法
    public LiveData<BaseRespEntity<UserEntity>> reg(UserEntity userEntity){
        /**
         * 无网络
         * 可以选择加载本地数据（sqlite  sp  file  lrucache）
         */
         return mModel.reg(userEntity);
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