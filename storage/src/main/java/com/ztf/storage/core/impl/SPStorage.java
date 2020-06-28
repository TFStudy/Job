package com.ztf.storage.core.impl;

import com.ztf.common.utils.LogUtils;
import com.ztf.common.utils.app.BaseAppcation;
import com.ztf.storage.core.IStorage;
import com.ztf.storage.utils.SharePreferenceUtils;

public class SPStorage implements IStorage {
    private static final String TAG = "TFData";

    @Override
    public <T> boolean save(String key, T value) {
        try {
            SharePreferenceUtils.put(BaseAppcation.getAppContext(),key,value);
        }
        catch (Exception ex){
            LogUtils.INSTANCE.e(TAG,ex.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public <T> T get(String key) {
        T result = (T) SharePreferenceUtils.get(BaseAppcation.getAppContext(), key, "");
        return result;
    }
}