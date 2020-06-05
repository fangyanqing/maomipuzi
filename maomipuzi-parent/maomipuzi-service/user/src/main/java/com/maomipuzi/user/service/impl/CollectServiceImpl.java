package com.maomipuzi.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.pojo.SkuGoods;
import com.maomipuzi.goods.service.SkuGoodsService;
import com.maomipuzi.user.dao.CollectMapper;
import com.maomipuzi.user.pojo.Collect;
import com.maomipuzi.user.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-05 20:10
 **/
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private SkuGoodsService skuGoodsService;

    /**
     * Collect条件+分页查询
     * @param collect 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Collect> findPage(Collect collect, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(collect);
        //执行搜索
        return new PageInfo<Collect>(collectMapper.selectByExample(example));
    }

    /**
     * Collect分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Collect> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Collect>(collectMapper.selectAll());
    }

    /**
     * Collect条件查询
     * @param collect
     * @return
     */
    @Override
    public List<Collect> findList(Collect collect){
        //构建查询条件
        Example example = createExample(collect);
        //根据构建的条件查询数据
        return collectMapper.selectByExample(example);
    }


    /**
     * Collect构建查询对象
     * @param collect
     * @return
     */
    public Example createExample(Collect collect){
        Example example=new Example(Collect.class);
        Example.Criteria criteria = example.createCriteria();
        if(collect!=null){
            // 收藏ID
            if(!StringUtils.isEmpty(collect.getCollectId())){
                criteria.andEqualTo("collectId",collect.getCollectId());
            }
            // 会员ID
            if(!StringUtils.isEmpty(collect.getUserId())){
                criteria.andEqualTo("userId",collect.getUserId());
            }
            // 商品编号
            if(!StringUtils.isEmpty(collect.getGoodsNo())){
                criteria.andEqualTo("goodsNo",collect.getGoodsNo());
            }
            // 收藏时间
            if(!StringUtils.isEmpty(collect.getCollectTime())){
                criteria.andEqualTo("collectTime",collect.getCollectTime());
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
        collectMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Collect
     * @param collect
     */
    @Override
    public void update(Collect collect){
        collectMapper.updateByPrimaryKey(collect);
    }

    /**
     * 增加Collect
     * @param collect
     */
    @Override
    public void add(Collect collect){
        collectMapper.insert(collect);
    }

    /**
     * 根据ID查询Collect
     * @param id
     * @return
     */
    @Override
    public Collect findById(Integer id){
        return  collectMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Collect全部数据
     * @return
     */
    @Override
    public List<Collect> findAll() {
        return collectMapper.selectAll();
    }

    /**
     * Collect构建查询对象
     * @param collect
     * @return
     */
    public Example findCollect(Collect collect){
        Example example=new Example(Collect.class);
        Example.Criteria criteria = example.createCriteria();
        if(collect!=null){
            // 会员ID
            if(!StringUtils.isEmpty(collect.getUserId())){
                criteria.andEqualTo("userId",collect.getUserId());
            }
        }
        return example;
    }

    @Override
    public List<Collect> findAll(Integer userId) {
        Collect collect = new Collect();
//
//        SkuGoods skuGoods = skuGoodsService.findById(userId);
        collect.setUserId(userId);
        //构建查询条件
        Example example = findCollect(collect);
        //根据构建的条件查询数据
        return collectMapper.selectByExample(example);
    }
}

