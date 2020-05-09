package com.maomipuzi.cart.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.cart.dao.CartInfoMapper;
import com.maomipuzi.cart.pojo.CartInfo;
import com.maomipuzi.cart.service.CartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:08
 **/
@Service
public class CartInfoServiceImpl implements CartInfoService {

    @Autowired
    private CartInfoMapper cartInfoMapper;


    /**
     * CartInfo条件+分页查询
     * @param cartInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<CartInfo> findPage(CartInfo cartInfo, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(cartInfo);
        //执行搜索
        return new PageInfo<CartInfo>(cartInfoMapper.selectByExample(example));
    }

    /**
     * CartInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<CartInfo> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<CartInfo>(cartInfoMapper.selectAll());
    }

    /**
     * CartInfo条件查询
     * @param cartInfo
     * @return
     */
    @Override
    public List<CartInfo> findList(CartInfo cartInfo){
        //构建查询条件
        Example example = createExample(cartInfo);
        //根据构建的条件查询数据
        return cartInfoMapper.selectByExample(example);
    }


    /**
     * CartInfo构建查询对象
     * @param cartInfo
     * @return
     */
    public Example createExample(CartInfo cartInfo){
        Example example=new Example(CartInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(cartInfo!=null){
            // 购物车详情ID
            if(!StringUtils.isEmpty(cartInfo.getCartInfoId())){
                criteria.andEqualTo("cartInfoId",cartInfo.getCartInfoId());
            }
            // 购物车ID
            if(!StringUtils.isEmpty(cartInfo.getCartId())){
                criteria.andEqualTo("cartId",cartInfo.getCartId());
            }
            // 商品编号
            if(!StringUtils.isEmpty(cartInfo.getGoodsNo())){
                criteria.andEqualTo("goodsNo",cartInfo.getGoodsNo());
            }
            // 数量
            if(!StringUtils.isEmpty(cartInfo.getQuantity())){
                criteria.andEqualTo("quantity",cartInfo.getQuantity());
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
        cartInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改CartInfo
     * @param cartInfo
     */
    @Override
    public void update(CartInfo cartInfo){
        cartInfoMapper.updateByPrimaryKey(cartInfo);
    }

    /**
     * 增加CartInfo
     * @param cartInfo
     */
    @Override
    public void add(CartInfo cartInfo){
        cartInfoMapper.insert(cartInfo);
    }

    /**
     * 根据ID查询CartInfo
     * @param id
     * @return
     */
    @Override
    public CartInfo findById(Integer id){
        return  cartInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询CartInfo全部数据
     * @return
     */
    @Override
    public List<CartInfo> findAll() {
        return cartInfoMapper.selectAll();
    }
}
