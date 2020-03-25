package com.maomipuzi.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.pojo.SkuGoods;
import com.maomipuzi.goods.dao.SkuGoodsMapper;
import com.maomipuzi.goods.service.SkuGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 14:56
 **/
@Service
public class SkuGoodsServiceImpl implements SkuGoodsService {

    @Autowired
    private SkuGoodsMapper skuGoodsMapper;


    /**
     * SkuGoods条件+分页查询
     * @param skuGoods 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SkuGoods> findPage(SkuGoods skuGoods, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(skuGoods);
        //执行搜索
        return new PageInfo<SkuGoods>(skuGoodsMapper.selectByExample(example));
    }

    /**
     * SkuGoods分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SkuGoods> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SkuGoods>(skuGoodsMapper.selectAll());
    }

    /**
     * SkuGoods条件查询
     * @param skuGoods
     * @return
     */
    @Override
    public List<SkuGoods> findList(SkuGoods skuGoods){
        //构建查询条件
        Example example = createExample(skuGoods);
        //根据构建的条件查询数据
        return skuGoodsMapper.selectByExample(example);
    }


    /**
     * SkuGoods构建查询对象
     * @param skuGoods
     * @return
     */
    public Example createExample(SkuGoods skuGoods){
        Example example=new Example(SkuGoods.class);
        Example.Criteria criteria = example.createCriteria();
        if(skuGoods!=null){
            // 商品ID
            if(!StringUtils.isEmpty(skuGoods.getId())){
                criteria.andEqualTo("id",skuGoods.getId());
            }
            // 商品编号
            if(!StringUtils.isEmpty(skuGoods.getGoodsNo())){
                criteria.andEqualTo("%"+skuGoods.getGoodsNo()+"%");
            }
            // 商品名称
            if(!StringUtils.isEmpty(skuGoods.getGoodsName())){
                criteria.andEqualTo("goodsName","%"+skuGoods.getGoodsName()+"%");
            }
            // 类型名称
            if(!StringUtils.isEmpty(skuGoods.getTypeName())){
                criteria.andEqualTo("typeName","%"+skuGoods.getTypeName()+"%");
            }
            // 颜色
            if(!StringUtils.isEmpty(skuGoods.getColour())){
                criteria.andEqualTo("colour","%"+skuGoods.getColour()+"%");
            }
            // 体重
            if(!StringUtils.isEmpty(skuGoods.getWeight())){
                criteria.andEqualTo("weight","%"+skuGoods.getWeight()+"%");
            }

            // 体型
            if(!StringUtils.isEmpty(skuGoods.getSize())){
                criteria.andEqualTo("size",skuGoods.getSize());
            }

            // 性别
            if(!StringUtils.isEmpty(skuGoods.getSex())){
                criteria.andEqualTo("sex",skuGoods.getSex());
            }
            // 出生日期
            if(!StringUtils.isEmpty(skuGoods.getBirthday())){
                criteria.andEqualTo("birthday","%"+skuGoods.getBirthday()+"%");
            }
            // 上架日期
            if(!StringUtils.isEmpty(skuGoods.getShelvesTime())){
                criteria.andEqualTo("shelvesTime","%"+skuGoods.getShelvesTime()+"%");
            }
            // 年龄
            if(!StringUtils.isEmpty(skuGoods.getAge())){
                criteria.andEqualTo("age",skuGoods.getAge());
            }
            // 寿命
            if(!StringUtils.isEmpty(skuGoods.getLifetime())){
                criteria.andEqualTo("lifetime",skuGoods.getLifetime());
            }
            // 商品价格
            if(!StringUtils.isEmpty(skuGoods.getPrice())){
                criteria.andEqualTo("price",skuGoods.getPrice());
            }
            // vip价格
            if(!StringUtils.isEmpty(skuGoods.getVipPrice())){
                criteria.andEqualTo("vipPrice",skuGoods.getVipPrice());
            }
            // 市场价格
            if(!StringUtils.isEmpty(skuGoods.getMarketPrice())){
                criteria.andEqualTo("marketPrice",skuGoods.getMarketPrice());
            }
            // 成本
            if(!StringUtils.isEmpty(skuGoods.getCost())){
                criteria.andEqualTo("cost",skuGoods.getCost());
            }
            // 优惠
            if(!StringUtils.isEmpty(skuGoods.getDiscount())){
                criteria.andEqualTo("discount",skuGoods.getDiscount());
            }
            // 图片
            if(!StringUtils.isEmpty(skuGoods.getImage())){
                criteria.andEqualTo("image",skuGoods.getImage());
            }
            // 图片列表
            if(!StringUtils.isEmpty(skuGoods.getImages())){
                criteria.andEqualTo("images",skuGoods.getImages());
            }
            // 状态 0-正常 1-已下架 2-已删除
            if(!StringUtils.isEmpty(skuGoods.getStatus())){
                criteria.andEqualTo("status",skuGoods.getStatus());
            }
            // 销量
            if(!StringUtils.isEmpty(skuGoods.getSaleNum())){
                criteria.andEqualTo("saleNum",skuGoods.getSaleNum());
            }
            // 库存数量
            if(!StringUtils.isEmpty(skuGoods.getStockNum())){
                criteria.andEqualTo("stockNum",skuGoods.getStockNum());
            }
            // 库存预警数
            if(!StringUtils.isEmpty(skuGoods.getAlertNum())){
                criteria.andEqualTo("alertNum",skuGoods.getAlertNum());
            }
            // 规格名称
            if(!StringUtils.isEmpty(skuGoods.getSpec())){
                criteria.andEqualTo("spec","%"+skuGoods.getSpec()+"%");
            }
            // 商品公共属性ID
            if(!StringUtils.isEmpty(skuGoods.getSpuId())){
                criteria.andEqualTo("spuId",skuGoods.getSpuId());
            }
            // 创建时间
            if(!StringUtils.isEmpty(skuGoods.getCreateTime())){
                criteria.andEqualTo("createTime",skuGoods.getCreateTime());
            }
            // 创建人
            if(!StringUtils.isEmpty(skuGoods.getCreator())){
                criteria.andEqualTo("creator",skuGoods.getCreator());
            }
            // 更新时间
            if(!StringUtils.isEmpty(skuGoods.getUpdateTime())){
                criteria.andEqualTo("updateTime",skuGoods.getUpdateTime());
            }
            // 更新人
            if(!StringUtils.isEmpty(skuGoods.getUpdatePerson())){
                criteria.andEqualTo("updatePerson",skuGoods.getUpdatePerson());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        skuGoodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SkuGoods
     * @param skuGoods
     */
    @Override
    public void update(SkuGoods skuGoods){
        skuGoodsMapper.updateByPrimaryKey(skuGoods);
    }

    /**
     * 增加SkuGoods
     * @param skuGoods
     */
    @Override
    public void add(SkuGoods skuGoods){
        skuGoodsMapper.insert(skuGoods);
    }

    /**
     * 根据ID查询SkuGoods
     * @param id
     * @return
     */
    @Override
    public SkuGoods findById(Integer id){
        return  skuGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SkuGoods全部数据
     * @return
     */
    @Override
    public List<SkuGoods> findAll() {
        return skuGoodsMapper.selectAll();
    }
}
