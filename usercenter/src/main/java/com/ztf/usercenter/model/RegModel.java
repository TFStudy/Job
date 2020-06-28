package com.ztf.usercenter.model;

import androidx.lifecycle.LiveData;
import com.ztf.core.model.IModel;
import com.ztf.net.RetrofitFactory;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.api.Api;
import com.ztf.usercenter.entity.UserEntity;
import io.reactivex.disposables.Disposable;

public class RegModel implements IModel {
    private final String TAG= RegModel.class.getSimpleName();
    Disposable disposable=null;
    //登陆方法
    public LiveData<BaseRespEntity<UserEntity>> reg(final UserEntity userEntity){
        Api api = RetrofitFactory.getInstance().create(Api.class);
        LiveData<BaseRespEntity<UserEntity>> result = api.reg(userEntity);
        return result;
    }
    public LiveData<BaseRespEntity> getYzm(final String phoneNumber){
        Api api = RetrofitFactory.getInstance().create(Api.class);
        LiveData<BaseRespEntity> result = api.getyzm(phoneNumber);
        return result;
    }
}