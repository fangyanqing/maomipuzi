package com.maomipuzi.cart.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.cart.dao.CartMapper;
import com.maomipuzi.cart.pojo.Cart;
import com.maomipuzi.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:07
 **/
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;


    /**
     * Cart条件+分页查询
     * @param cart 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Cart> findPage(Cart cart, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(cart);
        //执行搜索
        return new PageInfo<Cart>(cartMapper.selectByExample(example));
    }

    /**
     * Cart分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Cart> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Cart>(cartMapper.selectAll());
    }

    /**
     * Cart条件查询
     * @param cart
     * @return
     */
    @Override
    public List<Cart> findList(Cart cart){
        //构建查询条件
        Example example = createExample(cart);
        //根据构建的条件查询数据
        return cartMapper.selectByExample(example);
    }


    /**
     * Cart构建查询对象
     * @param cart
     * @return
     */
    public Example createExample(Cart cart){
        Example example=new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        if(cart!=null){
            // 购物车ID
            if(!StringUtils.isEmpty(cart.getCartId())){
                criteria.andEqualTo("cartId",cart.getCartId());
            }
            // 会员ID
            if(!StringUtils.isEmpty(cart.getUserId())){
                criteria.andEqualTo("userId",cart.getUserId());
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
        cartMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Cart
     * @param cart
     */
    @Override
    public void update(Cart cart){
        cartMapper.updateByPrimaryKey(cart);
    }

    /**
     * 增加Cart
     * @param cart
     */
    @Override
    public void add(Cart cart){
        cartMapper.insert(cart);
    }

    /**
     * 根据ID查询Cart
     * @param id
     * @return
     */
    @Override
    public Cart findById(Integer id){
        return  cartMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Cart全部数据
     * @return
     */
    @Override
    public List<Cart> findAll() {
        return cartMapper.selectAll();
    }

}
