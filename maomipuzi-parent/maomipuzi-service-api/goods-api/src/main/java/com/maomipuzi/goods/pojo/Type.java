package com.maomipuzi.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pojo.Base;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/

@ApiModel(description = "类型表",value = "Type")
@Table(name="type")
public class Type extends Base implements Serializable {
    @ApiModelProperty(value = "类型ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer typeId;

    @ApiModelProperty(value = "类型名称",required = false)
    @Column(name = "type_name")
    private String typeName;

    @ApiModelProperty(value = "类型图片",required = false)
    @Column(name = "type_picture")
    private String typePicture;

    @ApiModelProperty(value = "类型状态  0-已弃用 1-可用（默认）",required = false)
    @Column(name = "type_status")
    private Integer typeStatus;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypePicture() {
        return typePicture;
    }

    public void setTypePicture(String typePicture) {
        this.typePicture = typePicture;
    }

    public Integer getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(Integer typeStatus) {
        this.typeStatus = typeStatus;
    }
}
