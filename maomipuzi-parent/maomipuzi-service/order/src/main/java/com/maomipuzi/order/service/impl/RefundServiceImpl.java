package com.maomipuzi.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.order.dao.RefundMapper;
import com.maomipuzi.order.pojo.Refund;
import com.maomipuzi.order.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 16:00
 **/
@Service
public class RefundServiceImpl implements RefundService {
    @Autowired
    private RefundMapper refundMapper;


    /**
     * Refund条件+分页查询
     * @param refund 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Refund> findPage(Refund refund, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(refund);
        //执行搜索
        return new PageInfo<Refund>(refundMapper.selectByExample(example));
    }

    /**
     * Refund分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Refund> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Refund>(refundMapper.selectAll());
    }

    /**
     * Refund条件查询
     * @param refund
     * @return
     */
    @Override
    public List<Refund> findList(Refund refund){
        //构建查询条件
        Example example = createExample(refund);
        //根据构建的条件查询数据
        return refundMapper.selectByExample(example);
    }


    /**
     * Refund构建查询对象
     * @param refund
     * @return
     */
    public Example createExample(Refund refund){
        Example example=new Example(Refund.class);
        Example.Criteria criteria = example.createCriteria();
        if(refund!=null){
            // 退款ID
            if(!StringUtils.isEmpty(refund.getId())){
                criteria.andEqualTo("id",refund.getId());
            }
            // 订单编号
            if(!StringUtils.isEmpty(refund.getOrderNo())){
                criteria.andEqualTo("orderNo",refund.getOrderNo());
            }
            // 退款方式  0-线上退款  1-线下退款
            if(!StringUtils.isEmpty(refund.getRefundWay())){
                criteria.andEqualTo("refundWay",refund.getRefundWay());
            }
            // 退款原因 0-拍错/不喜欢 1-实际与商品不符 2-卖家发错货 3-其他
            if(!StringUtils.isEmpty(refund.getRefundReason())){
                criteria.andEqualTo("refundReason",refund.getRefundReason());
            }
            // 退款说明
            if(!StringUtils.isEmpty(refund.getRefundInstructions())){
                criteria.andEqualTo("refundInstructions",refund.getRefundInstructions());
            }
            // 货物状态 0-未收到货  1-已收到货
            if(!StringUtils.isEmpty(refund.getGoodsStatus())){
                criteria.andEqualTo("goodsStatus",refund.getGoodsStatus());
            }
            // 退款状态 0-审核中  1-未审核（默认） 2-退款失败 3-退款成功
            if(!StringUtils.isEmpty(refund.getStatus())){
                criteria.andEqualTo("status",refund.getStatus());
            }
            // 退款申请时间
            if(!StringUtils.isEmpty(refund.getApplicationTime())){
                criteria.andEqualTo("applicationTime",refund.getApplicationTime());
            }
            // 退款成功时间
            if(!StringUtils.isEmpty(refund.getSuccessTime())){
                criteria.andEqualTo("successTime",refund.getSuccessTime());
            }
            // 操作人
            if(!StringUtils.isEmpty(refund.getOperator())){
                criteria.andEqualTo("operator",refund.getOperator());
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
        refundMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Refund
     * @param refund
     */
    @Override
    public void update(Refund refund){
        refundMapper.updateByPrimaryKey(refund);
    }

    /**
     * 增加Refund
     * @param refund
     */
    @Override
    public void add(Refund refund){
        refundMapper.insert(refund);
    }

    /**
     * 根据ID查询Refund
     * @param id
     * @return
     */
    @Override
    public Refund findById(Integer id){
        return  refundMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Refund全部数据
     * @return
     */
    @Override
    public List<Refund> findAll() {
        return refundMapper.selectAll();
    }

}
