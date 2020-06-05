package com.maomipuzi.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.order.dao.OrderInfoMapper;
import com.maomipuzi.order.pojo.OrderInfo;
import com.maomipuzi.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 15:28
 **/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;


    /**
     * OrderInfo条件+分页查询
     * @param orderInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OrderInfo> findPage(OrderInfo orderInfo, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(orderInfo);
        //执行搜索
        return new PageInfo<OrderInfo>(orderInfoMapper.selectByExample(example));
    }

    /**
     * OrderInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OrderInfo> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OrderInfo>(orderInfoMapper.selectAll());
    }

    /**
     * OrderInfo条件查询
     * @param orderInfo
     * @return
     */
    @Override
    public List<OrderInfo> findList(OrderInfo orderInfo){
        //构建查询条件
        Example example = createExample(orderInfo);
        //根据构建的条件查询数据
        return orderInfoMapper.selectByExample(example);
    }


    /**
     * OrderInfo构建查询对象
     * @param orderInfo
     * @return
     */
    public Example createExample(OrderInfo orderInfo){
        Example example=new Example(OrderInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(orderInfo!=null){
            // 订单ID
            if(!StringUtils.isEmpty(orderInfo.getId())){
                criteria.andEqualTo("id",orderInfo.getId());
            }
            // 订单编号
            if(!StringUtils.isEmpty(orderInfo.getOrderNo())){
                criteria.andEqualTo("orderNo",orderInfo.getOrderNo());
            }
            // 商品编号
            if(!StringUtils.isEmpty(orderInfo.getGoodsNo())){
                criteria.andEqualTo("goodsNo",orderInfo.getGoodsNo());
            }
            // 运费金额
            if(!StringUtils.isEmpty(orderInfo.getFreightPrice())){
                criteria.andEqualTo("freightPrice",orderInfo.getFreightPrice());
            }
            // 订单商品总数
            if(!StringUtils.isEmpty(orderInfo.getTotalNum())){
                criteria.andEqualTo("totalNum",orderInfo.getTotalNum());
            }
            // 订单总价
            if(!StringUtils.isEmpty(orderInfo.getTotalPrice())){
                criteria.andEqualTo("totalPrice",orderInfo.getTotalPrice());
            }
            // 邮费
            if(!StringUtils.isEmpty(orderInfo.getTotalPostage())){
                criteria.andEqualTo("totalPostage",orderInfo.getTotalPostage());
            }
            // 实际支付金额
            if(!StringUtils.isEmpty(orderInfo.getPayPrice())){
                criteria.andEqualTo("payPrice",orderInfo.getPayPrice());
            }
            // 优惠劵金额
            if(!StringUtils.isEmpty(orderInfo.getCouponPrice())){
                criteria.andEqualTo("couponPrice",orderInfo.getCouponPrice());
            }
            // 支付ID
            if(!StringUtils.isEmpty(orderInfo.getPayId())){
                criteria.andEqualTo("payId",orderInfo.getPayId());
            }
            // 支付时间
            if(!StringUtils.isEmpty(orderInfo.getPayTime())){
                criteria.andEqualTo("payTime",orderInfo.getPayTime());
            }
            // 支付状态 0-未付款  1-已付款  2-支付失败
            if(!StringUtils.isEmpty(orderInfo.getPayStatus())){
                criteria.andEqualTo("payStatus",orderInfo.getPayStatus());
            }
            // 快递公司编码
            if(!StringUtils.isEmpty(orderInfo.getExpressNo())){
                criteria.andEqualTo("expressNo",orderInfo.getExpressNo());
            }
            // 快递名称/送货人名称
            if(!StringUtils.isEmpty(orderInfo.getDeliveryName())){
                criteria.andEqualTo("deliveryName",orderInfo.getDeliveryName());
            }
            // 快递单号
            if(!StringUtils.isEmpty(orderInfo.getDeliveryId())){
                criteria.andEqualTo("deliveryId",orderInfo.getDeliveryId());
            }
            // 发货时间
            if(!StringUtils.isEmpty(orderInfo.getDeliveryTime())){
                criteria.andEqualTo("deliveryTime",orderInfo.getDeliveryTime());
            }
            // 收货地址
            if(!StringUtils.isEmpty(orderInfo.getAddress())){
                criteria.andEqualTo("address",orderInfo.getAddress());
            }
            // 配送方式  0-快递（默认）  1-门店自取
            if(!StringUtils.isEmpty(orderInfo.getDeliveryType())){
                criteria.andEqualTo("deliveryType",orderInfo.getDeliveryType());
            }
            // 管理员备注
            if(!StringUtils.isEmpty(orderInfo.getRemark())){
                criteria.andEqualTo("remark",orderInfo.getRemark());
            }
            // 发货状态  0-发货 1-未发货（默认） 2-已收货 3-未收货
            if(!StringUtils.isEmpty(orderInfo.getDeliveryStatus())){
                criteria.andEqualTo("deliveryStatus",orderInfo.getDeliveryStatus());
            }
            // 订单状态  0-正常（默认）  1-退款中
            if(!StringUtils.isEmpty(orderInfo.getOrderInfoStatus())){
                criteria.andEqualTo("orderInfoStatus",orderInfo.getOrderInfoStatus());
            }
            if(!StringUtils.isEmpty(orderInfo.getUserId())){
                criteria.andEqualTo("userId",orderInfo.getUserId());
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
        orderInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OrderInfo
     * @param orderInfo
     */
    @Override
    public void update(OrderInfo orderInfo){
        orderInfoMapper.updateByPrimaryKey(orderInfo);
    }

    /**
     * 增加OrderInfo
     * @param orderInfo
     */
    @Override
    public void add(OrderInfo orderInfo){
        orderInfoMapper.insert(orderInfo);
    }

    /**
     * 根据ID查询OrderInfo
     * @param id
     * @return
     */
    @Override
    public OrderInfo findById(Integer id){
        return  orderInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OrderInfo全部数据
     * @return
     */
    @Override
    public List<OrderInfo> findAll() {
        return orderInfoMapper.selectAll();
    }



    /**
     * OrderInfo构建查询对象
     * @param orderInfo
     * @return
     */
    public Example findByUserId(OrderInfo orderInfo){
        Example example=new Example(OrderInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(orderInfo!=null){
            if(!StringUtils.isEmpty(orderInfo.getUserId())){
                criteria.andEqualTo("userId",orderInfo.getUserId());
            }
        }
        return example;
    }

    @Override
    public List<OrderInfo> findByUserId(Integer userId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userId);
        //构建查询条件
        Example example = findByUserId(orderInfo);
        //根据构建的条件查询数据
        return orderInfoMapper.selectByExample(example);
    }
}
