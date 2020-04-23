package com.maomipuzi.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.order.dao.OrderOperationMapper;
import com.maomipuzi.order.pojo.OrderOperation;
import com.maomipuzi.order.service.OrderOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 15:27
 **/
@Service
public class OrderOperationServiceImpl implements OrderOperationService {
    @Autowired
    private OrderOperationMapper orderOperationMapper;


    /**
     * OrderOperation条件+分页查询
     * @param orderOperation 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OrderOperation> findPage(OrderOperation orderOperation, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(orderOperation);
        //执行搜索
        return new PageInfo<OrderOperation>(orderOperationMapper.selectByExample(example));
    }

    /**
     * OrderOperation分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OrderOperation> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OrderOperation>(orderOperationMapper.selectAll());
    }

    /**
     * OrderOperation条件查询
     * @param orderOperation
     * @return
     */
    @Override
    public List<OrderOperation> findList(OrderOperation orderOperation){
        //构建查询条件
        Example example = createExample(orderOperation);
        //根据构建的条件查询数据
        return orderOperationMapper.selectByExample(example);
    }

    /**
     * OrderOperation构建查询对象
     * @param orderOperation
     * @return
     */
    public Example createExample(OrderOperation orderOperation){
        Example example=new Example(OrderOperation.class);
        Example.Criteria criteria = example.createCriteria();
        if(orderOperation!=null){
            // 订单操作记录ID
            if(!StringUtils.isEmpty(orderOperation.getId())){
                criteria.andEqualTo("id",orderOperation.getId());
            }
            // 订单编号
            if(!StringUtils.isEmpty(orderOperation.getOrderNo())){
                criteria.andEqualTo("orderNo",orderOperation.getOrderNo());
            }
            // 操作类型 0-订单生成（默认） 1-用户付款成功 2-已发货 3-修改实际支付金额 4-退款给用户
            if(!StringUtils.isEmpty(orderOperation.getOperationType())){
                criteria.andEqualTo("operationType",orderOperation.getOperationType());
            }
            // 操作人 （默认系统生成）
            if(!StringUtils.isEmpty(orderOperation.getOperator())){
                criteria.andEqualTo("operator",orderOperation.getOperator());
            }
            // 操作备注
            if(!StringUtils.isEmpty(orderOperation.getOperationMessage())){
                criteria.andEqualTo("operationMessage",orderOperation.getOperationMessage());
            }
            // 创建时间
            if(!StringUtils.isEmpty(orderOperation.getCreateTime())){
                criteria.andEqualTo("createTime",orderOperation.getCreateTime());
            }
            // 操作时间
            if(!StringUtils.isEmpty(orderOperation.getOperationTime())){
                criteria.andEqualTo("operationTime",orderOperation.getOperationTime());
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
        orderOperationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OrderOperation
     * @param orderOperation
     */
    @Override
    public void update(OrderOperation orderOperation){
        orderOperationMapper.updateByPrimaryKey(orderOperation);
    }

    /**
     * 增加OrderOperation
     * @param orderOperation
     */
    @Override
    public void add(OrderOperation orderOperation){
        orderOperationMapper.insert(orderOperation);
    }

    /**
     * 根据ID查询OrderOperation
     * @param id
     * @return
     */
    @Override
    public OrderOperation findById(Integer id){
        return  orderOperationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OrderOperation全部数据
     * @return
     */
    @Override
    public List<OrderOperation> findAll() {
        return orderOperationMapper.selectAll();
    }
}
