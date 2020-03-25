package com.maomipuzi.goods;

import java.io.Serializable;
import java.util.List;
/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/

/**
 * 商品信息组合对象
 */

public class Goods implements Serializable {

    //SkuGoods集合信息（商品独有属性表）
    private List<SkuGoods> skuGoodsList;

    //SpuGoods信息（商品信息公有属性）
    private SpuGoods spuGoods;

    public List<SkuGoods> getSkuGoodsList() {
        return skuGoodsList;
    }

    public void setSkuGoodsList(List<SkuGoods> skuGoodsList) {
        this.skuGoodsList = skuGoodsList;
    }

    public SpuGoods getSpuGoods() {
        return spuGoods;
    }

    public void setSpuGoods(SpuGoods spuGoods) {
        this.spuGoods = spuGoods;
    }
}
