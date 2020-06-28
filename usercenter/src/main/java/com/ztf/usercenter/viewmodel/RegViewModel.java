package com.ztf.usercenter.viewmodel;

import androidx.lifecycle.LiveData;
import com.ztf.core.viewmodel.BaseViewModel;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.entity.UserEntity;
import com.ztf.usercenter.repository.RegRepository;

public class RegViewModel extends BaseViewModel {
    public UserEntity userEntity=new UserEntity();
    public RegViewModel() {
        registerRepository(RegRepository.class.getSimpleName(),new RegRepository());
    }
    //注册方法
    public LiveData<BaseRespEntity<UserEntity>> reg(){
        RegRepository regRepository = getRepositroy(RegRepository.class.getSimpleName());
        return regRepository.reg(userEntity);
    }
    //登陆方法
    public LiveData<BaseRespEntity> yams(String m){
        RegRepository regRepository = getRepositroy(RegRepository.class.getSimpleName());
        return regRepository.yzm(m);
    }
}
