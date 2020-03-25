package com.maomipuzi.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.Goods;
import com.maomipuzi.goods.SkuGoods;
import com.maomipuzi.goods.SpuGoods;
import com.maomipuzi.goods.Type;
import com.maomipuzi.goods.dao.SkuGoodsMapper;
import com.maomipuzi.goods.dao.SpuGoodsMapper;
import com.maomipuzi.goods.dao.TypeMapper;
import com.maomipuzi.goods.service.SpuGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 14:47
 **/
@Service
public class SpuGoodsServiceImpl implements SpuGoodsService {

    @Autowired
    private SpuGoodsMapper spuGoodsMapper;

    @Autowired
    private SkuGoodsMapper skuGoodsMapper;

    @Autowired
    private TypeMapper typeMapper;


    /**
     * 批量上架
     * @param ids  spu的id
     */
    @Override
    public void putMany(Integer[] ids) {
        //构建条件
        Example example = new Example(SpuGoods.class);
        Example.Criteria criteria = example.createCriteria();
        //ids
        criteria.andIn("id",Arrays.asList(ids));
        //未删除的商品(1)
        criteria.andEqualTo("isDelete","1");
        //已审核的商品(1)
        criteria.andEqualTo("status","1");
        //修改的数据
        SpuGoods spuGoods = new SpuGoods();
        spuGoods.setIsMarketable("1");//上架
        spuGoodsMapper.updateByExampleSelective(spuGoods,example);
    }

    /**
     * 上架
     */
    @Override
    public void put(Integer id) {
        SpuGoods spuGoods = spuGoodsMapper.selectByPrimaryKey(id);
        //商品删除了，不能上架
        if(spuGoods.getIsDelete().equalsIgnoreCase("0")){
            throw  new RuntimeException("商品已删除，不能上架");
        }
        //未审核过（0）的商品，不能上架
        if(spuGoods.getStatus().equalsIgnoreCase("0")){
            throw new RuntimeException("商品未审核，不能上架");
        }
        //修改上架状态
        spuGoods.setIsMarketable("1");
        spuGoodsMapper.updateByPrimaryKeySelective(spuGoods);
    }


    /**
     * 下架
     * @param id
     */
    @Override
    public void pull(Integer id) {
        //查询
        SpuGoods spuGoods = spuGoodsMapper.selectByPrimaryKey(id);
        if(spuGoods == null){
            throw new RuntimeException("当前商品不存在");
        }
        //判断当前商品是否处于删除状态（0）
        if(spuGoods.getIsDelete().equalsIgnoreCase("0")){
            throw new RuntimeException("当前商品处于删除状态");
        }
        //商品处于未删除状态（1）的话，则修改上下架状态为已下架（0）
        spuGoods.setIsMarketable("0");
        spuGoodsMapper.updateByPrimaryKeySelective(spuGoods);
    }


    /**
     * 审核
     * @param id
     */
    @Override
    public void audit(Integer id) {
        //查询spuGoods对象
        SpuGoods spuGoods = spuGoodsMapper.selectByPrimaryKey(id);
        if(spuGoods == null){
            throw  new RuntimeException("当前商品不存在");
        }
        //判断当前spuGoods是否处于删除状态（0）
        if(spuGoods.getIsDelete().equalsIgnoreCase("0")){
            throw new RuntimeException("当前商品处于删除状态");
        }
        //不处于删除状态，修改审核状态为1(审核通过)
        spuGoods.setStatus("1");
        //改为上架状态（1）
        spuGoods.setIsMarketable("1");
        //执行修改操作
        spuGoodsMapper.updateByPrimaryKeySelective(spuGoods);
    }


    /**
     * 修改商品信息
     * @param goods
     */
    @Override
    public void updateGoods(Goods goods) {

        SpuGoods spuGoods = goods.getSpuGoods();
        spuGoodsMapper.updateByPrimaryKeySelective(spuGoods);
        //删除之前的skuGoods列表
        SkuGoods skuGoods = new SkuGoods();
        skuGoods.setSpuId(spuGoods.getId());
        skuGoodsMapper.delete(skuGoods);

        //保存到skuGoods列表
        saveSkuGoodsList(goods);

    }

    /**
     * 根据spuGoods的ID查询商品
     * @param id
     * @return
     */
    @Override
    public Goods findGoodsById(Integer id) {
        //查询spuGoods
        SpuGoods spuGoods = spuGoodsMapper.selectByPrimaryKey(id);

        //查询skuGoods列表
        SkuGoods skuGoods = new SkuGoods();
        skuGoods.setSpuId(id);
        List<SkuGoods> skuGoodsList =skuGoodsMapper.select(skuGoods);

        //返回结果
        Goods goods = new Goods();
        goods.setSpuGoods(spuGoods);
        goods.setSkuGoodsList(skuGoodsList);
        return goods;
    }


    /***
     * 添加商品信息
     * @param goods
     */
    @Override
    public void saveGoods(Goods goods) {
        //SpuGoods是一个
        SpuGoods spuGoods = goods.getSpuGoods();

        spuGoods.setIsMarketable("1");//已上架
        spuGoods.setIsDelete("1");//正常
        spuGoods.setStatus("1");//审核通过

        spuGoodsMapper.insertSelective(spuGoods);

        //保存skuGoods列表
        saveSkuGoodsList(goods);


    }

    /**
     * 保存到skuGoods列表
     * @param goods
     */
    private void saveSkuGoodsList(Goods goods){
        SpuGoods spuGoods = goods.getSpuGoods();
        //保存skuGoods集合数据到数据库中
        //SkuGoods是一个集合

        //设置时间戳作为商品编号
        Long dateLong = new Date().getTime();
        String dateString = "fyq-"+dateLong.toString();
        //获取类型信息
        Type type = typeMapper.selectByPrimaryKey(spuGoods.getTypeId());
        //获取skuGoods集合对象
        List<SkuGoods> skuGoodsList = goods.getSkuGoodsList();
        if(skuGoodsList != null){
            for (SkuGoods skuGoods : skuGoodsList){
                String name = spuGoods.getSpuName();

                //防止规格空指针
                if(StringUtils.isEmpty(skuGoods.getSpec())){
                    skuGoods.setSpec("{}");
                }
                //将spec转成Map
                Map<String ,String> specMap = JSON.parseObject(skuGoods.getSpec(),Map.class);
                if(specMap !=null && specMap.size() >0){
                    for (String value : specMap.values()){
                        name+="  " + value;
                    }
                }

                skuGoods.setGoodsName(name);
                skuGoods.setGoodsNo(dateString);
                skuGoods.setSpuId(spuGoods.getId());
                skuGoods.setCreateTime(new Date());
                skuGoods.setUpdateTime(new Date());
                skuGoods.setTypeName(type.getTypeName());

                skuGoodsMapper.insertSelective(skuGoods);
            }
        }
    }



    /**
     * SpuGoods条件+分页查询
     * @param spuGoods 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SpuGoods> findPage(SpuGoods spuGoods, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(spuGoods);
        //执行搜索
        return new PageInfo<SpuGoods>(spuGoodsMapper.selectByExample(example));
    }

    /**
     * SpuGoods分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SpuGoods> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SpuGoods>(spuGoodsMapper.selectAll());
    }

    /**
     * SpuGoods条件查询
     * @param spuGoods
     * @return
     */
    @Override
    public List<SpuGoods> findList(SpuGoods spuGoods){
        //构建查询条件
        Example example = createExample(spuGoods);
        //根据构建的条件查询数据
        return spuGoodsMapper.selectByExample(example);
    }

    /**
     * SpuGoods构建查询对象
     * @param spuGoods
     * @return
     */
    public Example createExample(SpuGoods spuGoods){
        Example example=new Example(SpuGoods.class);
        Example.Criteria criteria = example.createCriteria();
        if(spuGoods!=null){
            // ID
            if(!StringUtils.isEmpty(spuGoods.getId())){
                criteria.andEqualTo("id",spuGoods.getId());
            }
            // 商品名称
            if(!StringUtils.isEmpty(spuGoods.getSpuName())){
                criteria.andEqualTo("spuName","%"+spuGoods.getSpuName()+"%");
            }
            // 商品编号
            if(!StringUtils.isEmpty(spuGoods.getGoodsNo())){
                criteria.andEqualTo("goodsNo","%"+spuGoods.getGoodsNo()+"%");
            }
            // 副标题
            if(!StringUtils.isEmpty(spuGoods.getCaption())){
                criteria.andEqualTo("caption","%"+spuGoods.getCaption()+"%");
            }
            // 分类ID
            if(!StringUtils.isEmpty(spuGoods.getId())){
                criteria.andEqualTo("typeId","%"+spuGoods.getId()+"%");
            }
            // 地区
            if(!StringUtils.isEmpty(spuGoods.getArea())){
                criteria.andEqualTo("area","%"+spuGoods.getArea()+"%");
            }
            // 描述
            if(!StringUtils.isEmpty(spuGoods.getDescription())){
                criteria.andEqualTo("description","%"+spuGoods.getDescription()+"%");
            }
            // 门店ID
            if(!StringUtils.isEmpty(spuGoods.getStoreId())){
                criteria.andEqualTo("storeId",spuGoods.getStoreId());
            }
            // 销量
            if(!StringUtils.isEmpty(spuGoods.getSaleNum())){
                criteria.andEqualTo("saleNum",spuGoods.getSaleNum());
            }
            // 性格
            if(!StringUtils.isEmpty(spuGoods.getCharacters())){
                criteria.andEqualTo("characters","%"+spuGoods.getCharacters()+"%");
            }
            // 售后服务
            if(!StringUtils.isEmpty(spuGoods.getSaleService())){
                criteria.andEqualTo("saleService","%"+spuGoods.getSaleService()+"%");
            }
            // 规格名称
            if(!StringUtils.isEmpty(spuGoods.getSpecItems())){
                criteria.andEqualTo("specItems","%"+spuGoods.getSpecItems()+"%");
            }
            // 是否上架 0-下架 1-上架
            if(!StringUtils.isEmpty(spuGoods.getIsMarketable())){
                criteria.andEqualTo("isMarketable",spuGoods.getIsMarketable());
            }
            // 是否删除 0-删除 1-正常
            if(!StringUtils.isEmpty(spuGoods.getIsDelete())){
                criteria.andEqualTo("isDelete",spuGoods.getIsDelete());
            }
            // 审核状态 0-未审核 1-审核通过 2-审核未通过
            if(!StringUtils.isEmpty(spuGoods.getStatus())){
                criteria.andEqualTo("status",spuGoods.getStatus());
            }
        }
        return example;
    }

    /**
     * 删除-逻辑删除和物理删除
     * 这是逻辑删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        SpuGoods spuGoods = spuGoodsMapper.selectByPrimaryKey(id);
        //检查是否下架（0）的商品
        if(!spuGoods.getIsMarketable().equalsIgnoreCase("0")){
            throw new RuntimeException("必须先下架才能删除");
        }
        //删除状态(0)
        spuGoods.setIsDelete("0");
        //审核状态改为未审核（0）
        spuGoods.setStatus("0");

        spuGoodsMapper.updateByPrimaryKeySelective(spuGoods);
    }

    /**
     * 恢复被逻辑删除的数据
     * @param id
     */
    @Override
    public void restore(Integer id) {
        SpuGoods spuGoods = spuGoodsMapper.selectByPrimaryKey(id);
        //检查是否为逻辑删除（0）的商品
        if(!spuGoods.getIsDelete().equals("0")){
            throw new RuntimeException("此商品未逻辑删除,不用恢复");
        }
        //改为未删除状态（1）
        spuGoods.setIsDelete("1");
        //改为未审核状态
        spuGoods.setStatus("0");
        spuGoodsMapper.updateByPrimaryKeySelective(spuGoods);
    }

    /**
     * 物理删除，实现真正的删除
     * @param id
     */
    @Override
    public void realDelete(Integer id) {
        SpuGoods spuGoods = spuGoodsMapper.selectByPrimaryKey(id);
        //检查是否为逻辑删除的商品
        if(!spuGoods.getIsDelete().equals("0")){
            throw new RuntimeException("此商品未逻辑删除");
        }
        //实现真正的删除
        spuGoodsMapper.deleteByPrimaryKey(id);
    }


    /**
     * 修改SpuGoods
     * @param spuGoods
     */
    @Override
    public void update(SpuGoods spuGoods){
        spuGoodsMapper.updateByPrimaryKey(spuGoods);
    }

    /**
     * 增加SpuGoods
     * @param spuGoods
     */
    @Override
    public void add(SpuGoods spuGoods){
        spuGoodsMapper.insert(spuGoods);
    }

    /**
     * 根据ID查询SpuGoods
     * @param id
     * @return
     */
    @Override
    public SpuGoods findById(Integer id) {
        //根据ID查询
        return spuGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SpuGoods全部数据
     * @return
     */
    @Override
    public List<SpuGoods> findAll() {
        return spuGoodsMapper.selectAll();
    }
}
