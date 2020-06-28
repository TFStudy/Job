package com.ztf.net.retrofit.calladaprwe;

import retrofit2.Call;
import retrofit2.CallAdapter;

import java.lang.reflect.Type;

public class DefaultCallAdaper<R> implements CallAdapter<R,Object> {
    Type type;

    public DefaultCallAdaper(Type type) {
        this.type = type;
    }

    @Override
    public Type responseType() {
        return type;
    }

    @Override
    public Object adapt(Call<R> call) {
        return call;
    }
}
