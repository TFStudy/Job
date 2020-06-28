package com.ztf.net.common;

import com.example.net.BuildConfig;

public class Config {
    public final static String AUTH_CODE="2916811413f19216315816a1e11941d01e91c91f51a915a1" ;
    /**
     * 网络请求超时时长
     */
    public final static int TIMEOUT=10;
    public final static String BASE_URL= BuildConfig.baseUrl;

    /**
     * 测试业务服务器地址
     */
    public final static String TEST_SERVER_URL=BuildConfig.testServerUrl;

    public final static String  NewUrlHeaderKey="newUrl";
    public final static String NewUrlHeaderValue="testServerUrl";
}
