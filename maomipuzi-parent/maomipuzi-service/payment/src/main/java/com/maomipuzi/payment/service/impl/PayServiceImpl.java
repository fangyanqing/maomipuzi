package com.maomipuzi.payment.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.payment.dao.PayMapper;
import com.maomipuzi.payment.pojo.Pay;
import com.maomipuzi.payment.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 18:01
 **/
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayMapper payMapper;


    /**
     * Pay条件+分页查询
     * @param pay 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Pay> findPage(Pay pay, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pay);
        //执行搜索
        return new PageInfo<Pay>(payMapper.selectByExample(example));
    }

    /**
     * Pay分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Pay> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Pay>(payMapper.selectAll());
    }

    /**
     * Pay条件查询
     * @param pay
     * @return
     */
    @Override
    public List<Pay> findList(Pay pay){
        //构建查询条件
        Example example = createExample(pay);
        //根据构建的条件查询数据
        return payMapper.selectByExample(example);
    }


    /**
     * Pay构建查询对象
     * @param pay
     * @return
     */
    public Example createExample(Pay pay){
        Example example=new Example(Pay.class);
        Example.Criteria criteria = example.createCriteria();
        if(pay!=null){
            // 支付ID
            if(!StringUtils.isEmpty(pay.getPayId())){
                criteria.andEqualTo("payId",pay.getPayId());
            }
            // 支付类型 1-余额支付 2-微信 3-支付宝 4-银行卡 5-线下支付 6-好友代付
            if(!StringUtils.isEmpty(pay.getPayType())){
                criteria.andEqualTo("payType",pay.getPayType());
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
        payMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Pay
     * @param pay
     */
    @Override
    public void update(Pay pay){
        payMapper.updateByPrimaryKey(pay);
    }

    /**
     * 增加Pay
     * @param pay
     */
    @Override
    public void add(Pay pay){
        payMapper.insert(pay);
    }

    /**
     * 根据ID查询Pay
     * @param id
     * @return
     */
    @Override
    public Pay findById(Integer id){
        return  payMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Pay全部数据
     * @return
     */
    @Override
    public List<Pay> findAll() {
        return payMapper.selectAll();
    }
}
