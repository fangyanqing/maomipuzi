package com.maomipuzi.logistics.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:03
 **/
@ApiModel(description = "门店自提表",value = "Pickup")
@Table(name="pickup")
public class Pickup implements Serializable {

    @ApiModelProperty(value = "门店自提ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pickup_id")
    private Integer pickupId;//门店自提ID

    @ApiModelProperty(value = "订单编号",required = false)
    @Column(name = "order_no")
    private String orderNo;//订单编号

    @ApiModelProperty(value = "门店编号",required = false)
    @Column(name = "store_id")
    private Integer storeId;//门店编号

    @ApiModelProperty(value = "有效日期",required = false)
    @Column(name = "valid_time")
    private Date validTime;//有效日期

    @ApiModelProperty(value = "取货时间",required = false)
    @Column(name = "pickup_time")
    private Date pickupTime;//取货时间

    @ApiModelProperty(value = "取货人",required = false)
    @Column(name = "pickup_name")
    private String pickupName;//取货人

    @ApiModelProperty(value = "手机",required = false)
    @Column(name = "phone")
    private String phone;//手机

    @ApiModelProperty(value = "负责人",required = false)
    @Column(name = "principals")
    private String principals;//负责人



    //get方法
    public Integer getPickupId() {
        return pickupId;
    }

    //set方法
    public void setPickupId(Integer pickupId) {
        this.pickupId = pickupId;
    }
    //get方法
    public String getOrderNo() {
        return orderNo;
    }

    //set方法
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    //get方法
    public Integer getStoreId() {
        return storeId;
    }

    //set方法
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    //get方法
    public Date getValidTime() {
        return validTime;
    }

    //set方法
    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }
    //get方法
    public Date getPickupTime() {
        return pickupTime;
    }

    //set方法
    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }
    //get方法
    public String getPickupName() {
        return pickupName;
    }

    //set方法
    public void setPickupName(String pickupName) {
        this.pickupName = pickupName;
    }
    //get方法
    public String getPhone() {
        return phone;
    }

    //set方法
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //get方法
    public String getPrincipals() {
        return principals;
    }

    //set方法
    public void setPrincipals(String principals) {
        this.principals = principals;
    }

}
