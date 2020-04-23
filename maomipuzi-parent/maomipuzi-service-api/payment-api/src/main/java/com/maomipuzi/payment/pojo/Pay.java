package com.maomipuzi.payment.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:59
 **/
@ApiModel(description = "支付类型表",value = "Pay")
@Table(name="pay")
public class Pay implements Serializable {

    @ApiModelProperty(value = "支付ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_id")
    private Integer payId;//支付ID

    @ApiModelProperty(value = "支付类型 1-余额支付 2-微信 3-支付宝 4-银行卡 5-线下支付 6-好友代付",required = false)
    @Column(name = "pay_type")
    private Integer payType;//支付类型 1-余额支付 2-微信 3-支付宝 4-银行卡 5-线下支付 6-好友代付



    //get方法
    public Integer getPayId() {
        return payId;
    }

    //set方法
    public void setPayId(Integer payId) {
        this.payId = payId;
    }
    //get方法
    public Integer getPayType() {
        return payType;
    }

    //set方法
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}
