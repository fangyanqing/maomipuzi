package com.maomipuzi.logistics.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:03
 **/
@ApiModel(description = "快递公司表",value = "Express")
@Table(name="express")
public class Express implements Serializable {

    @ApiModelProperty(value = "快递公司ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//快递公司ID

    @ApiModelProperty(value = "快递公司编号",required = false)
    @Column(name = "express_no")
    private String expressNo;//快递公司编号

    @ApiModelProperty(value = "快递公司简称",required = false)
    @Column(name = "express_code")
    private String expressCode;//快递公司简称

    @ApiModelProperty(value = "快递公司全称",required = false)
    @Column(name = "express_name")
    private String expressName;//快递公司全称

    @ApiModelProperty(value = "是否显示  0-不显示 1-显示（默认）",required = false)
    @Column(name = "is_show")
    private Integer isShow;//是否显示  0-不显示 1-显示（默认）



    //get方法
    public Integer getId() {
        return id;
    }

    //set方法
    public void setId(Integer id) {
        this.id = id;
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
    public String getExpressCode() {
        return expressCode;
    }

    //set方法
    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
    //get方法
    public String getExpressName() {
        return expressName;
    }

    //set方法
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }
    //get方法
    public Integer getIsShow() {
        return isShow;
    }

    //set方法
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
}
