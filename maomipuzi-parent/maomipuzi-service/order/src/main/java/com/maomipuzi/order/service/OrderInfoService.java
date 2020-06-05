package com.maomipuzi.order.service;

import com.maomipuzi.order.pojo.OrderInfo;
import service.BasicService;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 15:27
 **/
public interface OrderInfoService extends BasicService<OrderInfo> {

    /**
     * 根据userId查询
     * @return
     */
    List<OrderInfo> findByUserId(Integer userId);
}
