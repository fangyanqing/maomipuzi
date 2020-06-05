package com.maomipuzi.order.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 15:14
 **/
@ApiModel(description = "订单信息表",value = "OrderInfo")
@Table(name="order_info")
public class OrderInfo  implements Serializable {
    @ApiModelProperty(value = "订单ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//订单ID

    @ApiModelProperty(value = "订单编号",required = false)
    @Column(name = "order_no")
    private String orderNo;//订单编号

    @ApiModelProperty(value = "商品编号",required = false)
    @Column(name = "goods_no")
    private String goodsNo;//商品编号

    @ApiModelProperty(value = "运费金额",required = false)
    @Column(name = "freight_price")
    private String freightPrice;//运费金额

    @ApiModelProperty(value = "订单商品总数",required = false)
    @Column(name = "total_num")
    private Integer totalNum;//订单商品总数

    @ApiModelProperty(value = "订单总价",required = false)
    @Column(name = "total_price")
    private String totalPrice;//订单总价

    @ApiModelProperty(value = "邮费",required = false)
    @Column(name = "total_postage")
    private String totalPostage;//邮费

    @ApiModelProperty(value = "实际支付金额",required = false)
    @Column(name = "pay_price")
    private String payPrice;//实际支付金额

    @ApiModelProperty(value = "优惠劵金额",required = false)
    @Column(name = "coupon_price")
    private String couponPrice;//优惠劵金额

    @ApiModelProperty(value = "支付ID",required = false)
    @Column(name = "pay_id")
    private Integer payId;//支付ID

    @ApiModelProperty(value = "支付时间",required = false)
    @Column(name = "pay_time")
    private Date payTime;//支付时间

    @ApiModelProperty(value = "支付状态 0-未付款  1-已付款  2-支付失败",required = false)
    @Column(name = "pay_status")
    private Integer payStatus;//支付状态 0-未付款  1-已付款  2-支付失败

    @ApiModelProperty(value = "快递公司编码",required = false)
    @Column(name = "express_no")
    private String expressNo;//快递公司编码

    @ApiModelProperty(value = "快递名称/送货人名称",required = false)
    @Column(name = "delivery_name")
    private String deliveryName;//快递名称/送货人名称

    @ApiModelProperty(value = "快递单号",required = false)
    @Column(name = "delivery_id")
    private String deliveryId;//快递单号

    @ApiModelProperty(value = "发货时间",required = false)
    @Column(name = "delivery_time")
    private Date deliveryTime;//发货时间

    @ApiModelProperty(value = "收货地址",required = false)
    @Column(name = "address")
    private String address;//收货地址

    @ApiModelProperty(value = "配送方式  0-快递（默认）  1-门店自取",required = false)
    @Column(name = "delivery_type")
    private Integer deliveryType;//配送方式  0-快递（默认）  1-门店自取

    @ApiModelProperty(value = "管理员备注",required = false)
    @Column(name = "remark")
    private String remark;//管理员备注

    @ApiModelProperty(value = "发货状态  0-发货 1-未发货（默认） 2-已收货 3-未收货",required = false)
    @Column(name = "delivery_status")
    private Integer deliveryStatus;//发货状态  0-发货 1-未发货（默认） 2-已收货 3-未收货

    @ApiModelProperty(value = "订单状态  0-正常（默认）  1-退款中",required = false)
    @Column(name = "order_info_status")
    private Integer orderInfoStatus;//订单状态  0-正常（默认）  1-退款中

    @ApiModelProperty(value = "会员Id",required = false)
    @Column(name = "user_id")
    private Integer userId;



    //get方法
    public Integer getId() {
        return id;
    }

    //set方法
    public void setId(Integer id) {
        this.id = id;
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
    public String getGoodsNo() {
        return goodsNo;
    }

    //set方法
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
    //get方法
    public String getFreightPrice() {
        return freightPrice;
    }

    //set方法
    public void setFreightPrice(String freightPrice) {
        this.freightPrice = freightPrice;
    }
    //get方法
    public Integer getTotalNum() {
        return totalNum;
    }

    //set方法
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
    //get方法
    public String getTotalPrice() {
        return totalPrice;
    }

    //set方法
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
    //get方法
    public String getTotalPostage() {
        return totalPostage;
    }

    //set方法
    public void setTotalPostage(String totalPostage) {
        this.totalPostage = totalPostage;
    }
    //get方法
    public String getPayPrice() {
        return payPrice;
    }

    //set方法
    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }
    //get方法
    public String getCouponPrice() {
        return couponPrice;
    }

    //set方法
    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }
    //get方法
    public Integer getPayId() {
        return payId;
    }

    //set方法
    public void setPayId(Integer payId) {
        this.payId = payId;
    }
    //get方法
    public Date getPayTime() {
        return payTime;
    }

    //set方法
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    //get方法
    public Integer getPayStatus() {
        return payStatus;
    }

    //set方法
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
    //get方法
    public String getExpressNo() {
        return expressNo;
    }

    //set方法
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
    //get方法
    public String getDeliveryName() {
        return deliveryName;
    }

    //set方法
    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }
    //get方法
    public String getDeliveryId() {
        return deliveryId;
    }

    //set方法
    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }
    //get方法
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    //set方法
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    //get方法
    public String getAddress() {
        return address;
    }

    //set方法
    public void setAddress(String address) {
        this.address = address;
    }
    //get方法
    public Integer getDeliveryType() {
        return deliveryType;
    }

    //set方法
    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }
    //get方法
    public String getRemark() {
        return remark;
    }

    //set方法
    public void setRemark(String remark) {
        this.remark = remark;
    }
    //get方法
    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    //set方法
    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    //get方法
    public Integer getOrderInfoStatus() {
        return orderInfoStatus;
    }

    //set方法
    public void setOrderInfoStatus(Integer orderInfoStatus) {
        this.orderInfoStatus = orderInfoStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
