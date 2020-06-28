package com.ztf.usercenter.viewmodel;

import androidx.lifecycle.LiveData;
import com.ztf.core.viewmodel.BaseViewModel;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.entity.Yzm;
import com.ztf.usercenter.repository.ModifyRepository;

public class ModifyViewModel extends BaseViewModel {
    public Yzm userEntity=new Yzm();
    public ModifyViewModel() {
        registerRepository(ModifyRepository.class.getSimpleName(),new ModifyRepository());
    }
    //注册方法
    public LiveData<BaseRespEntity> modify(){
        ModifyRepository regRepository = getRepositroy(ModifyRepository.class.getSimpleName());
        return regRepository.modify(userEntity);
    }
    //登陆方法
    public LiveData<BaseRespEntity> yams(String m){
        ModifyRepository regRepository = getRepositroy(ModifyRepository.class.getSimpleName());
        return regRepository.yzm(m);
    }
}
