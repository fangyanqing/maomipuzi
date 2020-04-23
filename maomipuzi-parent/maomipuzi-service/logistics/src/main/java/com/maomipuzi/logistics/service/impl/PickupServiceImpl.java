package com.maomipuzi.logistics.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.logistics.dao.PickupMapper;
import com.maomipuzi.logistics.pojo.Pickup;
import com.maomipuzi.logistics.service.PickupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:10
 **/
@Service
public class PickupServiceImpl implements PickupService {

    @Autowired
    private PickupMapper pickupMapper;


    /**
     * Pickup条件+分页查询
     * @param pickup 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Pickup> findPage(Pickup pickup, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pickup);
        //执行搜索
        return new PageInfo<Pickup>(pickupMapper.selectByExample(example));
    }

    /**
     * Pickup分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Pickup> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Pickup>(pickupMapper.selectAll());
    }

    /**
     * Pickup条件查询
     * @param pickup
     * @return
     */
    @Override
    public List<Pickup> findList(Pickup pickup){
        //构建查询条件
        Example example = createExample(pickup);
        //根据构建的条件查询数据
        return pickupMapper.selectByExample(example);
    }


    /**
     * Pickup构建查询对象
     * @param pickup
     * @return
     */
    public Example createExample(Pickup pickup){
        Example example=new Example(Pickup.class);
        Example.Criteria criteria = example.createCriteria();
        if(pickup!=null){
            // 门店自提ID
            if(!StringUtils.isEmpty(pickup.getPickupId())){
                criteria.andEqualTo("pickupId",pickup.getPickupId());
            }
            // 订单编号
            if(!StringUtils.isEmpty(pickup.getOrderNo())){
                criteria.andEqualTo("orderNo",pickup.getOrderNo());
            }
            // 门店编号
            if(!StringUtils.isEmpty(pickup.getStoreId())){
                criteria.andEqualTo("storeId",pickup.getStoreId());
            }
            // 有效日期
            if(!StringUtils.isEmpty(pickup.getValidTime())){
                criteria.andEqualTo("validTime",pickup.getValidTime());
            }
            // 取货时间
            if(!StringUtils.isEmpty(pickup.getPickupTime())){
                criteria.andEqualTo("pickupTime",pickup.getPickupTime());
            }
            // 取货人
            if(!StringUtils.isEmpty(pickup.getPickupName())){
                criteria.andEqualTo("pickupName",pickup.getPickupName());
            }
            // 手机
            if(!StringUtils.isEmpty(pickup.getPhone())){
                criteria.andEqualTo("phone",pickup.getPhone());
            }
            // 负责人
            if(!StringUtils.isEmpty(pickup.getPrincipals())){
                criteria.andEqualTo("principals",pickup.getPrincipals());
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
        pickupMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Pickup
     * @param pickup
     */
    @Override
    public void update(Pickup pickup){
        pickupMapper.updateByPrimaryKey(pickup);
    }

    /**
     * 增加Pickup
     * @param pickup
     */
    @Override
    public void add(Pickup pickup){
        pickupMapper.insert(pickup);
    }

    /**
     * 根据ID查询Pickup
     * @param id
     * @return
     */
    @Override
    public Pickup findById(Integer id){
        return  pickupMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Pickup全部数据
     * @return
     */
    @Override
    public List<Pickup> findAll() {
        return pickupMapper.selectAll();
    }
}
