package com.maomipuzi.order.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 15:57
 **/
@ApiModel(description = "退款表",value = "Refund")
@Table(name="refund")
public class Refund implements Serializable {

    @ApiModelProperty(value = "退款ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//退款ID

    @ApiModelProperty(value = "订单编号",required = false)
    @Column(name = "order_no")
    private String orderNo;//订单编号

    @ApiModelProperty(value = "退款方式  0-线上退款  1-线下退款",required = false)
    @Column(name = "refund_way")
    private Integer refundWay;//退款方式  0-线上退款  1-线下退款

    @ApiModelProperty(value = "退款原因 0-拍错/不喜欢 1-实际与商品不符 2-卖家发错货 3-其他",required = false)
    @Column(name = "refund_reason")
    private Integer refundReason;//退款原因 0-拍错/不喜欢 1-实际与商品不符 2-卖家发错货 3-其他

    @ApiModelProperty(value = "退款说明",required = false)
    @Column(name = "refund_instructions")
    private String refundInstructions;//退款说明

    @ApiModelProperty(value = "货物状态 0-未收到货  1-已收到货",required = false)
    @Column(name = "goods_status")
    private Integer goodsStatus;//货物状态 0-未收到货  1-已收到货

    @ApiModelProperty(value = "退款状态 0-审核中  1-未审核（默认） 2-退款失败 3-退款成功",required = false)
    @Column(name = "status")
    private Integer status;//退款状态 0-审核中  1-未审核（默认） 2-退款失败 3-退款成功

    @ApiModelProperty(value = "退款申请时间",required = false)
    @Column(name = "application_time")
    private Date applicationTime;//退款申请时间

    @ApiModelProperty(value = "退款成功时间",required = false)
    @Column(name = "success_time")
    private Date successTime;//退款成功时间

    @ApiModelProperty(value = "操作人",required = false)
    @Column(name = "operator")
    private String operator;//操作人



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
    public Integer getRefundWay() {
        return refundWay;
    }

    //set方法
    public void setRefundWay(Integer refundWay) {
        this.refundWay = refundWay;
    }
    //get方法
    public Integer getRefundReason() {
        return refundReason;
    }

    //set方法
    public void setRefundReason(Integer refundReason) {
        this.refundReason = refundReason;
    }
    //get方法
    public String getRefundInstructions() {
        return refundInstructions;
    }

    //set方法
    public void setRefundInstructions(String refundInstructions) {
        this.refundInstructions = refundInstructions;
    }
    //get方法
    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    //set方法
    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }
    //get方法
    public Integer getStatus() {
        return status;
    }

    //set方法
    public void setStatus(Integer status) {
        this.status = status;
    }
    //get方法
    public Date getApplicationTime() {
        return applicationTime;
    }

    //set方法
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }
    //get方法
    public Date getSuccessTime() {
        return successTime;
    }

    //set方法
    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }
    //get方法
    public String getOperator() {
        return operator;
    }

    //set方法
    public void setOperator(String operator) {
        this.operator = operator;
    }

}
