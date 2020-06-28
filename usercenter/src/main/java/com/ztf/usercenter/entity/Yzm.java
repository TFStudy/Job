package com.ztf.usercenter.entity;

import androidx.databinding.BaseObservable;
public class Yzm extends BaseObservable {

    /**
     * userid : 161
     * pwd : 123
     */

    private String userid;
    private String pwd;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
