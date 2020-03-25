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

@ApiModel(description = "角色表",value = "Role")
@Table(name="role")
public class Role extends Base implements Serializable {
    @Id
    //角色ID
    private Integer id;

   //角色类型
    private Integer roleType;

    //功能权限
    private String permission;

    //角色级别
    private Integer level;

    //备注
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
