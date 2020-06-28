package com.ztf.usercenter.api;

import androidx.lifecycle.LiveData;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.entity.UserEntity;
import com.ztf.usercenter.entity.Yzm;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("api/User/login")
    LiveData<BaseRespEntity<UserEntity>> login(@Body UserEntity userEntity);
    @POST("api/User/register")
    LiveData<BaseRespEntity<UserEntity>> reg(@Body UserEntity userEntity);
    @POST("api/User/modifyPwd")
    LiveData<BaseRespEntity> modify(@Body Yzm yzm);

    @GET("api/User/getAuthCode")
    LiveData<BaseRespEntity> getyzm(@Query("phoneNumber") String phoneNumber);
}
