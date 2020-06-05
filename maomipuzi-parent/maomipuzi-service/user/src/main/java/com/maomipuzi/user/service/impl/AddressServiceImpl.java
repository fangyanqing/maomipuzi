package com.maomipuzi.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.user.dao.AddressMapper;
import com.maomipuzi.user.pojo.Address;
import com.maomipuzi.user.service.AddressService;
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
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    /**
     * Address条件+分页查询
     * @param address 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Address> findPage(Address address, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(address);
        //执行搜索
        return new PageInfo<Address>(addressMapper.selectByExample(example));
    }

    /**
     * Address分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Address> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Address>(addressMapper.selectAll());
    }

    /**
     * Address条件查询
     * @param address
     * @return
     */
    @Override
    public List<Address> findList(Address address){
        //构建查询条件
        Example example = createExample(address);
        //根据构建的条件查询数据
        return addressMapper.selectByExample(example);
    }


    /**
     * Address构建查询对象
     * @param address
     * @return
     */
    public Example createExample(Address address){
        Example example=new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        if(address!=null){
            // 收货地址ID
            if(!StringUtils.isEmpty(address.getAddressId())){
                criteria.andEqualTo("addressId",address.getAddressId());
            }
            // 会员ID
            if(!StringUtils.isEmpty(address.getUserId())){
                criteria.andEqualTo("userId",address.getUserId());
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
        addressMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Address
     * @param address
     */
    @Override
    public void update(Address address){
        addressMapper.updateByPrimaryKey(address);
    }

    /**
     * 增加Address
     * @param address
     */
    @Override
    public void add(Address address){
        addressMapper.insert(address);
    }

    /**
     * 根据ID查询Address
     * @param id
     * @return
     */
    @Override
    public Address findById(Integer id){
        return  addressMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Address全部数据
     * @return
     */
    @Override
    public List<Address> findAll() {
        return addressMapper.selectAll();
    }
}

