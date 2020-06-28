package com.ztf.usercenter.model;

import androidx.lifecycle.LiveData;
import com.ztf.core.model.IModel;
import com.ztf.net.RetrofitFactory;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.api.Api;
import com.ztf.usercenter.entity.Yzm;
import io.reactivex.disposables.Disposable;

public class ModifyModel implements IModel {
    private final String TAG= ModifyModel.class.getSimpleName();
    Disposable disposable=null;
    //登陆方法
    public LiveData<BaseRespEntity> modify(final Yzm yzm){
        Api api = RetrofitFactory.getInstance().create(Api.class);
        LiveData<BaseRespEntity> result = api.modify(yzm);
        return result;
    }
    public LiveData<BaseRespEntity> getYzm(final String phoneNumber){
        Api api = RetrofitFactory.getInstance().create(Api.class);
        LiveData<BaseRespEntity> result = api.getyzm(phoneNumber);
        return result;
    }
}