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

@ApiModel(description = "订单操作表",value = "OrderOperation")
@Table(name="Order_operation")
public class OrderOperation implements Serializable {

    @ApiModelProperty(value = "订单操作记录ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//订单操作记录ID

    @ApiModelProperty(value = "订单编号",required = false)
    @Column(name = "order_no")
    private String orderNo;//订单编号

    @ApiModelProperty(value = "操作类型 0-订单生成（默认） 1-用户付款成功 2-已发货 3-修改实际支付金额 4-退款给用户",required = false)
    @Column(name = "operation_type")
    private Integer operationType;//操作类型 0-订单生成（默认） 1-用户付款成功 2-已发货 3-修改实际支付金额 4-退款给用户

    @ApiModelProperty(value = "操作人 （默认系统生成）",required = false)
    @Column(name = "operator")
    private String operator;//操作人 （默认系统生成）

    @ApiModelProperty(value = "操作备注",required = false)
    @Column(name = "operation_message")
    private String operationMessage;//操作备注

    @ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
    private Date createTime;//创建时间

    @ApiModelProperty(value = "操作时间",required = false)
    @Column(name = "operation_time")
    private Date operationTime;//操作时间



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
    public Integer getOperationType() {
        return operationType;
    }

    //set方法
    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }
    //get方法
    public String getOperator() {
        return operator;
    }

    //set方法
    public void setOperator(String operator) {
        this.operator = operator;
    }
    //get方法
    public String getOperationMessage() {
        return operationMessage;
    }

    //set方法
    public void setOperationMessage(String operationMessage) {
        this.operationMessage = operationMessage;
    }
    //get方法
    public Date getCreateTime() {
        return createTime;
    }

    //set方法
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    //get方法
    public Date getOperationTime() {
        return operationTime;
    }

    //set方法
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

}
