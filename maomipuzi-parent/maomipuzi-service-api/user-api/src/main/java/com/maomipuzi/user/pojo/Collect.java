package com.maomipuzi.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-05 20:07
 **/
@ApiModel(description = "Collect",value = "Collect")
@Table(name="collect")
public class Collect implements Serializable {

    @ApiModelProperty(value = "收藏ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collect_id")
    private Integer collectId;//收藏ID

    @ApiModelProperty(value = "会员ID",required = false)
    @Column(name = "user_id")
    private Integer userId;//会员ID

    @ApiModelProperty(value = "商品编号",required = false)
    @Column(name = "goods_no")
    private String goodsNo;//商品编号

    @ApiModelProperty(value = "收藏时间",required = false)
    @Column(name = "collect_time")
    private Date collectTime;//收藏时间

    @ApiModelProperty(value = "商品名称", required = false)
    @Column(name = "goods_name")
    private String goodsName;//商品名称

    @ApiModelProperty(value = "图片", required = false)
    @Column(name = "image")
    private String image;//图片


    @ApiModelProperty(value = "商品价格", required = false)
    @Column(name = "price")
    private String price;//商品价格



    //get方法
    public Integer getCollectId() {
        return collectId;
    }

    //set方法
    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }
    //get方法
    public Integer getUserId() {
        return userId;
    }

    //set方法
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    public Date getCollectTime() {
        return collectTime;
    }

    //set方法
    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
