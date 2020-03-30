package com.maomipuzi.search.pojo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-25 18:33
 **/
@Document(indexName = "skugoodsinfo",type = "docs")
public class SkuGoodsInfo implements Serializable {
    @Id
    private Integer id;//商品ID

    private String goodsNo;//商品编号

    /**
     * type = FieldType.Text  类型，Text支持分词
     * analyzer = "ik_smark"  创建索引的分词器
     * index = true  添加数据的时候，是否分词
     * store = false 是否储存
     * searchAnalyzer = "ik_smark"  搜索时使用的分词器
     */
    @Field(type = FieldType.Text,analyzer = "ik_smart",index = true,store = false,searchAnalyzer = "ik_smart")
    private String goodsName;//商品名称

    /**
     * type = FieldType.Keyword  不分词
     */
    @Field(type = FieldType.Keyword)
    private String typeName;//类型名称

    private String colour;//颜色

    private String weight;//体重

    private String size;//体型

    private String sex;//性别

    private Date birthday;//出生日期

    private Date shelvesTime;//上架日期

    private String age;//年龄

    private String lifetime;//寿命

    private String price;//商品价格

    private String vipPrice;//vip价格

    private String marketPrice;//市场价格

    private String cost;//成本

    private String discount;//优惠

    private String image;//图片

    private String images;//图片列表

    private String status;//状态 0-正常 1-已下架 2-已删除

    private Integer saleNum;//销量

    private Integer stockNum;//库存数量

    private Integer alertNum;//库存预警数

    private String spec;//规格

    private Map<String ,Object> specMap;//规格参数

    private Integer spuId;//商品公共属性ID

    private Date createTime;//创建时间

    private String creator;//创建人

    private Date updateTime;//更新时间

    private String updatePerson;//更新人

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

    public Map<String, Object> getSpecMap() {
        return specMap;
    }

    public void setSpecMap(Map<String, Object> specMap) {
        this.specMap = specMap;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }
}
