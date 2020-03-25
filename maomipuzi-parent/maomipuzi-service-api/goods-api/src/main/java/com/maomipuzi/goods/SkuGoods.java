package com.maomipuzi.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pojo.Base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 14:40
 **/
@ApiModel(description = "商品表",value = "SkuGoods")
@Table(name="sku_goods")
public class SkuGoods extends Base implements Serializable {

    @ApiModelProperty(value = "商品ID", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//商品ID


    @ApiModelProperty(value = "商品编号", required = false)
    @Column(name = "goods_no")
    private String goodsNo;//商品编号

    @ApiModelProperty(value = "商品名称", required = false)
    @Column(name = "goods_name")
    private String goodsName;//商品名称

    @ApiModelProperty(value = "类型名称", required = false)
    @Column(name = "type_name")
    private String typeName;//类型名称

    @ApiModelProperty(value = "颜色", required = false)
    @Column(name = "colour")
    private String colour;//颜色

    @ApiModelProperty(value = "体重", required = false)
    @Column(name = "weight")
    private String weight;//体重

    @ApiModelProperty(value = "体型",required = false)
    @Column(name = "size")
    private String size;//体型

    @ApiModelProperty(value = "性别",required = false)
    @Column(name = "sex")
    private String sex;//性别

    @ApiModelProperty(value = "出生日期", required = false)
    @Column(name = "birthday")
    private Date birthday;//出生日期

    @ApiModelProperty(value = "上架日期", required = false)
    @Column(name = "shelves_time")
    private Date shelvesTime;//上架日期

    @ApiModelProperty(value = "年龄", required = false)
    @Column(name = "age")
    private String age;//年龄

    @ApiModelProperty(value = "寿命", required = false)
    @Column(name = "lifetime")
    private String lifetime;//寿命

    @ApiModelProperty(value = "商品价格", required = false)
    @Column(name = "price")
    private String price;//商品价格

    @ApiModelProperty(value = "vip价格", required = false)
    @Column(name = "vip_price")
    private String vipPrice;//vip价格

    @ApiModelProperty(value = "市场价格", required = false)
    @Column(name = "market_price")
    private String marketPrice;//市场价格

    @ApiModelProperty(value = "成本", required = false)
    @Column(name = "cost")
    private String cost;//成本

    @ApiModelProperty(value = "优惠", required = false)
    @Column(name = "discount")
    private String discount;//优惠

    @ApiModelProperty(value = "图片", required = false)
    @Column(name = "image")
    private String image;//图片

    @ApiModelProperty(value = "图片列表", required = false)
    @Column(name = "images")
    private String images;//图片列表

    @ApiModelProperty(value = "状态 0-正常 1-已下架 2-已删除", required = false)
    @Column(name = "status")
    private String status;//状态 0-正常 1-已下架 2-已删除

    @ApiModelProperty(value = "销量", required = false)
    @Column(name = "sale_num")
    private Integer saleNum;//销量

    @ApiModelProperty(value = "库存数量", required = false)
    @Column(name = "stock_num")
    private Integer stockNum;//库存数量

    @ApiModelProperty(value = "库存预警数", required = false)
    @Column(name = "alert_num")
    private Integer alertNum;//库存预警数

    @ApiModelProperty(value = "规格", required = false)
    @Column(name = "spec")
    private String spec;//规格

    @ApiModelProperty(value = "商品公共属性ID", required = false)
    @Column(name = "spu_id")
    private Integer spuId;//商品公共属性ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getShelvesTime() {
        return shelvesTime;
    }

    public void setShelvesTime(Date shelvesTime) {
        this.shelvesTime = shelvesTime;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLifetime() {
        return lifetime;
    }

    public void setLifetime(String lifetime) {
        this.lifetime = lifetime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(String vipPrice) {
        this.vipPrice = vipPrice;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getAlertNum() {
        return alertNum;
    }

    public void setAlertNum(Integer alertNum) {
        this.alertNum = alertNum;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }
}
