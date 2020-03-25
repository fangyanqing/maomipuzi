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

@ApiModel(description = "库存表",value = "Stock")
@Table(name="Stock")
public class Stock extends Base implements Serializable {
    @ApiModelProperty(value = "库存ID", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Integer stockId;

    @ApiModelProperty(value = "商品编号", required = false)
    @Column(name = "goods_no")
    private String goodsNo;

    @ApiModelProperty(value = "库存数量", required = false)
    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @ApiModelProperty(value = "库存预警", required = false)
    @Column(name = "stock_warn")
    private Integer stockWarn;

    @ApiModelProperty(value = "库存告警", required = false)
    @Column(name = "stock_alert")
    private Integer stockAlert;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getStockWarn() {
        return stockWarn;
    }

    public void setStockWarn(Integer stockWarn) {
        this.stockWarn = stockWarn;
    }

    public Integer getStockAlert() {
        return stockAlert;
    }

    public void setStockAlert(Integer stockAlert) {
        this.stockAlert = stockAlert;
    }
}
