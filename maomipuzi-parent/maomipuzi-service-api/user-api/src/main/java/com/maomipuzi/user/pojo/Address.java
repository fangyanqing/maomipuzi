package com.maomipuzi.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-05 20:16
 **/
@ApiModel(description = "Address",value = "Address")
@Table(name="address")
public class Address implements Serializable {

    @ApiModelProperty(value = "收货地址ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;//收货地址ID

    @ApiModelProperty(value = "会员ID",required = false)
    @Column(name = "user_id")
    private Integer userId;//会员ID



    //get方法
    public Integer getAddressId() {
        return addressId;
    }

    //set方法
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    //get方法
    public Integer getUserId() {
        return userId;
    }

    //set方法
    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}

