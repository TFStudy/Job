package com.ztf.usercenter.viewmodel;

import androidx.lifecycle.LiveData;
import com.ztf.core.viewmodel.BaseViewModel;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.entity.UserEntity;
import com.ztf.usercenter.repository.UserRepository;

public class UserViewModel extends BaseViewModel {
    public UserEntity userEntity=new UserEntity();
    public UserViewModel() {
        registerRepository(UserRepository.class.getSimpleName(),new UserRepository());
    }
    //登陆方法
    public LiveData<BaseRespEntity<UserEntity>> login(){
        UserRepository userRepository = getRepositroy(UserRepository.class.getSimpleName());
        return userRepository.login(userEntity);
    }

}
