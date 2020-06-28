package com.ztf.storage.core;

public interface IStorage {
    <T> boolean save(String key,T value);
    <T> T get(String key);
}
