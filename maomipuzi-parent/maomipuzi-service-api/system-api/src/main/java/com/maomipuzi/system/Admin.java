package com.maomipuzi.system;

import io.swagger.annotations.ApiModel;
import pojo.Base;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/

@ApiModel(description = "管理员表",value = "Admin")
@Table(name="admin")
public class Admin extends Base implements Serializable {

    @Id
    //管理员ID
    private Integer adminId;

   //管理员姓名
    private String adminName;

   //密码
    private String password;

   //性别 1-男（默认） 2-女
    private Integer gender;

    //头像
    private String avatar;

   //电话
    private String phone;

    //邮箱
    private String email;

    //身份证
    private String identification;

    //住址
    private String address;

    //角色类型 0-超级管理员 1-管理员(默认） 2-审核员  3-会员
    private Integer roleType;

    //状态 1-启用（默认） 0-禁用
    private Integer enable;

    //最后修改密码时间
    private String lastPasswordResetTime;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getLastPasswordResetTime() {
        return lastPasswordResetTime;
    }

    public void setLastPasswordResetTime(String lastPasswordResetTime) {
        this.lastPasswordResetTime = lastPasswordResetTime;
    }
}
