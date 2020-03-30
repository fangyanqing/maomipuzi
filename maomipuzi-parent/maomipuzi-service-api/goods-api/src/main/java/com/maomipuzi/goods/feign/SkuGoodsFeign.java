package com.maomipuzi.goods.feign;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.pojo.SkuGoods;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 15:03
 **/
@FeignClient(name = "goods")
@RequestMapping("/skuGoods")
public interface SkuGoodsFeign {

    /***
     * 查询SkuGoods全部数据
     * @return
     */
    @GetMapping
    Result<List<SkuGoods>> findAll();
}
