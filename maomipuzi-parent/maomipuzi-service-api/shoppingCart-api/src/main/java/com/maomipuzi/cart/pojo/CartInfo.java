package com.maomipuzi.cart.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:01
 **/
@ApiModel(description = "购物车详情",value = "CartInfo")
@Table(name="cart_info")
public class CartInfo implements Serializable {

    @ApiModelProperty(value = "购物车详情ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_info_id")
    private Integer carInfoId;//购物车详情ID

    @ApiModelProperty(value = "购物车ID",required = false)
    @Column(name = "car_id")
    private Integer carId;//购物车ID

    @ApiModelProperty(value = "商品编号",required = false)
    @Column(name = "goods_no")
    private String goodsNo;//商品编号

    @ApiModelProperty(value = "数量",required = false)
    @Column(name = "quantity")
    private Integer quantity;//数量



    //get方法
    public Integer getCarInfoId() {
        return carInfoId;
    }

    //set方法
    public void setCarInfoId(Integer carInfoId) {
        this.carInfoId = carInfoId;
    }
    //get方法
    public Integer getCarId() {
        return carId;
    }

    //set方法
    public void setCarId(Integer carId) {
        this.carId = carId;
    }
    //get方法
    public String getGoodsNo() {
        return goodsNo;
    }

    //set方法
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
    //get方法
    public Integer getQuantity() {
        return quantity;
    }

    //set方法
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
