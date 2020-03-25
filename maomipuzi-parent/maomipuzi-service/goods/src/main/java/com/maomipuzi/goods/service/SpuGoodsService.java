package com.maomipuzi.goods.service;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.Goods;
import com.maomipuzi.goods.SpuGoods;
import service.BasicService;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 14:48
 **/
public interface SpuGoodsService extends BasicService<SpuGoods> {
    /**
     * 添加商品信息
     * @param goods
     */
    void saveGoods(Goods goods);

    /**
     * 根据spuGoods的ID查询商品信息
     * @param id
     * @return
     */
    public Goods findGoodsById(Integer id);

    /**
     * 修改商品信息
     * @param goods
     */
    void updateGoods(Goods goods);

    /**
     * 审核
     * @param id
     */
    public void audit(Integer id);

    /**
     * 下架商品
     * @param id
     */
    public void pull(Integer id);

    /**
     * 上架
     * @param id
     */
    public void put(Integer id);

    /**
     * 物理删除，实现真正的删除
     * @param id
     */
    public void realDelete(Integer id);

    /**
     * 恢复被逻辑删除的数据
     * @param id
     */
    public void restore(Integer id);

    /**
     * 批量上架
     * @param ids  spu的id
     */
    void putMany(Integer[] ids);

}
