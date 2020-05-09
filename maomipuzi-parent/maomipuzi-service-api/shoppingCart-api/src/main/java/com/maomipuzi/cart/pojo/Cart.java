package com.maomipuzi.cart.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 16:59
 **/
@ApiModel(description = "购物车",value = "Cart")
@Table(name="cart")
public class Cart implements Serializable {

    @ApiModelProperty(value = "购物车ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;//购物车ID

    @ApiModelProperty(value = "会员ID",required = false)
    @Column(name = "user_id")
    private Integer userId;//会员ID



    //get方法
    public Integer getCartId() {
        return cartId;
    }

    //set方法
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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
