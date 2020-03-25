package com.maomipuzi.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 14:43
 **/
@ApiModel(description = "商品公共属性表",value = "SpuGoods")
@Table(name="spu_goods")
public class SpuGoods implements Serializable {

    @ApiModelProperty(value = "ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "商品名称", required = false)
    @Column(name = "spu_name")
    private String spuName;//商品名称

    @ApiModelProperty(value = "商品编号", required = false)
    @Column(name = "goods_no")
    private String goodsNo;//商品编号

    @ApiModelProperty(value = "副标题", required = false)
    @Column(name = "caption")
    private String caption;//副标题

    @ApiModelProperty(value = "分类ID", required = false)
    @Column(name = "type_id")
    private String typeId;//分类ID

    @ApiModelProperty(value = "地区", required = false)
    @Column(name = "area")
    private String area;//地区

    @ApiModelProperty(value = "描述", required = false)
    @Column(name = "description")
    private String description;//描述

    @ApiModelProperty(value = "门店ID", required = false)
    @Column(name = "store_id")
    private Integer storeId;//门店ID

    @ApiModelProperty(value = "销量", required = false)
    @Column(name = "sale_num")
    private Integer saleNum;//销量

    @ApiModelProperty(value = "性格", required = false)
    @Column(name = "characters")
    private String characters;//性格

    @ApiModelProperty(value = "售后服务", required = false)
    @Column(name = "sale_service")
    private String saleService;//售后服务

    @ApiModelProperty(value = "规格列表", required = false)
    @Column(name = "spec_items")
    private String specItems;//规格列表

    @ApiModelProperty(value = "是否上架 0-下架 1-上架", required = false)
    @Column(name = "is_marketable")
    private String isMarketable;//是否上架 0-下架 1-上架

    @ApiModelProperty(value = "是否删除 0-删除 1-正常", required = false)
    @Column(name = "is_delete")
    private String isDelete;//是否删除 0-删除 1-正常

    @ApiModelProperty(value = "审核状态 0-未审核 1-审核通过 2-审核未通过", required = false)
    @Column(name = "status")
    private String status;//审核状态 0-未审核 1-审核通过 2-审核未通过

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService;
    }

    public String getSpecItems() {
        return specItems;
    }

    public void setSpecItems(String specItems) {
        this.specItems = specItems;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SpuGoods{" +
                "id=" + id +
                ", spuName='" + spuName + '\'' +
                ", goodsNo='" + goodsNo + '\'' +
                ", caption='" + caption + '\'' +
                ", typeId='" + typeId + '\'' +
                ", area='" + area + '\'' +
                ", description='" + description + '\'' +
                ", storeId=" + storeId +
                ", saleNum=" + saleNum +
                ", characters='" + characters + '\'' +
                ", saleService='" + saleService + '\'' +
                ", specItems='" + specItems + '\'' +
                ", isMarketable='" + isMarketable + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
