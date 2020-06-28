package com.ztf.storage.core;

import com.ztf.storage.core.impl.FileStorage;
import com.ztf.storage.core.impl.SPStorage;

public class StorageManager {
    private static StorageManager instance= new StorageManager();
    private IStorage storage;
    private StorageManager(){
        storage=new SPStorage();
    }

    public static StorageManager getInstance() {
        return instance;
    }
    //切换存储工具类型
    public void init(int storageType){
        if (storageType==StorageType.SP){
            storage=new SPStorage();
        }else if (storageType==StorageType.FILE){
            storage=new FileStorage();
        }
    }
    //存储
    public <T> boolean save(String key,T value){
        return storage.save(key,value);
    }
    //获取
    public <T> T get(String key){
        return storage.get(key);
    }
}