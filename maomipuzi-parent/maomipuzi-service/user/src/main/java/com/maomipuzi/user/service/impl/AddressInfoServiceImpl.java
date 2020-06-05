package com.maomipuzi.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.user.dao.AddressInfoMapper;
import com.maomipuzi.user.pojo.AddressInfo;
import com.maomipuzi.user.service.AddressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-05 20:19
 **/
@Service
public class AddressInfoServiceImpl implements AddressInfoService {

    @Autowired
    private AddressInfoMapper addressInfoMapper;


    /**
     * AddressInfo条件+分页查询
     * @param addressInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<AddressInfo> findPage(AddressInfo addressInfo, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(addressInfo);
        //执行搜索
        return new PageInfo<AddressInfo>(addressInfoMapper.selectByExample(example));
    }

    /**
     * AddressInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<AddressInfo> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<AddressInfo>(addressInfoMapper.selectAll());
    }

    /**
     * AddressInfo条件查询
     * @param addressInfo
     * @return
     */
    @Override
    public List<AddressInfo> findList(AddressInfo addressInfo){
        //构建查询条件
        Example example = createExample(addressInfo);
        //根据构建的条件查询数据
        return addressInfoMapper.selectByExample(example);
    }


    /**
     * AddressInfo构建查询对象
     * @param addressInfo
     * @return
     */
    public Example createExample(AddressInfo addressInfo){
        Example example=new Example(AddressInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(addressInfo!=null){
            // 收货地址详情ID
            if(!StringUtils.isEmpty(addressInfo.getAddressInfoId())){
                criteria.andEqualTo("addressInfoId",addressInfo.getAddressInfoId());
            }
            // 收货地址ID
            if(!StringUtils.isEmpty(addressInfo.getAddressId())){
                criteria.andEqualTo("addressId",addressInfo.getAddressId());
            }
            // 收货人所在省
            if(!StringUtils.isEmpty(addressInfo.getProvince())){
                criteria.andEqualTo("province",addressInfo.getProvince());
            }
            // 收货人所在市
            if(!StringUtils.isEmpty(addressInfo.getCity())){
                criteria.andEqualTo("city",addressInfo.getCity());
            }
            // 收货人所在区
            if(!StringUtils.isEmpty(addressInfo.getDistrict())){
                criteria.andEqualTo("district",addressInfo.getDistrict());
            }
            // 收货人详细地址
            if(!StringUtils.isEmpty(addressInfo.getDetailAddress())){
                criteria.andEqualTo("detailAddress",addressInfo.getDetailAddress());
            }
            // 是否为默认地址 0-默认地址 1-非默认地址
            if(!StringUtils.isEmpty(addressInfo.getAddressType())){
                criteria.andEqualTo("addressType",addressInfo.getAddressType());
            }
            // 收货人姓名
            if(!StringUtils.isEmpty(addressInfo.getConsignee())){
                criteria.andEqualTo("consignee",addressInfo.getConsignee());
            }
            // 收货人手机号码
            if(!StringUtils.isEmpty(addressInfo.getPhone())){
                criteria.andEqualTo("phone",addressInfo.getPhone());
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
        addressInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改AddressInfo
     * @param addressInfo
     */
    @Override
    public void update(AddressInfo addressInfo){
        addressInfoMapper.updateByPrimaryKey(addressInfo);
    }

    /**
     * 增加AddressInfo
     * @param addressInfo
     */
    @Override
    public void add(AddressInfo addressInfo){
        addressInfoMapper.insert(addressInfo);
    }

    /**
     * 根据ID查询AddressInfo
     * @param id
     * @return
     */
    @Override
    public AddressInfo findById(Integer id){
        return  addressInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询AddressInfo全部数据
     * @return
     */
    @Override
    public List<AddressInfo> findAll() {
        return addressInfoMapper.selectAll();
    }
}

