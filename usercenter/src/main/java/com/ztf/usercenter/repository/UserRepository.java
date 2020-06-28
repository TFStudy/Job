package com.ztf.usercenter.repository;

import androidx.lifecycle.LiveData;
import com.ztf.core.repository.Repository;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.entity.UserEntity;
import com.ztf.usercenter.model.UserModel;

public class UserRepository extends Repository<UserModel> {

    @Override
    protected UserModel createModel() {
        return new UserModel();
    }
    //登录方法
    public LiveData<BaseRespEntity<UserEntity>> login(UserEntity userEntity){
        /**
         * 无网络
         * 可以选择加载本地数据（sqlite  sp  file  lrucache）
         */
         return mModel.login(userEntity);
    }
}