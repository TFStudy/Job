package com.example.usercenter;

import com.ztf.common.utils.app.BaseAppcation;
import com.ztf.storage.core.StorageManager;
import com.ztf.storage.core.StorageType;

public class UserCenterApp extends BaseAppcation {
    @Override
    protected void initOtherConfig() {
        //初始化存储位置为SP
        StorageManager.getInstance().init(StorageType.SP);
    }
}
