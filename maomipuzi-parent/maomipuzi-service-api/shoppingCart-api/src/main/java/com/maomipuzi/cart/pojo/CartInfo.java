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
    @Column(name = "cart_info_id")
    private Integer cartInfoId;//购物车详情ID

    @ApiModelProperty(value = "购物车ID",required = false)
    @Column(name = "cart_id")
    private Integer cartId;//购物车ID

    @ApiModelProperty(value = "商品编号",required = false)
    @Column(name = "goods_no")
    private String goodsNo;//商品编号

    @ApiModelProperty(value = "数量",required = false)
    @Column(name = "quantity")
    private Integer quantity;//数量

    @ApiModelProperty(value = "商品名称",required = false)
    @Column(name = "goods_name")
    private String goodsName;

    @ApiModelProperty(value = "价格",required = false)
    @Column(name = "price")
    private String price;

    @ApiModelProperty(value = "商品ID",required = false)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "image",required = false)
    @Column(name = "image")
    private String image;






    //get方法
    public Integer getCartInfoId() {
        return cartInfoId;
    }

    //set方法
    public void setCartInfoId(Integer cartInfoId) {
        this.cartInfoId = cartInfoId;
    }
    //get方法
    public Integer getCartId() {
        return cartId;
    }

    //set方法
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
