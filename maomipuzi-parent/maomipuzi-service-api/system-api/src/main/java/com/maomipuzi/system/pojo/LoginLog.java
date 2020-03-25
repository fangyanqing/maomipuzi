package com.maomipuzi.system.pojo;

import io.swagger.annotations.ApiModel;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-16 15:31
 **/
@ApiModel(description = "登录日志表",value = "LoginLog")
@Table(name="login_log")
public class LoginLog implements Serializable {
    //登录ID
    private Integer id;

    //登录名
    private String loginName;

    //IP地址
    private String ip;

    //浏览器
    private String browserName;

    //地区
    private String location;

    //登录时间
    private Date loginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", ip='" + ip + '\'' +
                ", browserName='" + browserName + '\'' +
                ", location='" + location + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
