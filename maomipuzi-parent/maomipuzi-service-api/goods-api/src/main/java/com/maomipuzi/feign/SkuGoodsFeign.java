package com.maomipuzi.feign;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.SkuGoods;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 15:03
 **/
@FeignClient(name= "com/maomipuzi/goods")
@RequestMapping("/skuGoods")
public interface SkuGoodsFeign {

    /***
     * SkuGoods分页条件搜索实现
     * @param skuGoods
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SkuGoods skuGoods, @PathVariable  int page, @PathVariable  int size);

    /***
     * SkuGoods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索数据
     * @param skuGoods
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SkuGoods>> findList(@RequestBody(required = false) SkuGoods skuGoods);

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SkuGoods数据
     * @param skuGoods
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SkuGoods skuGoods, @PathVariable Integer id);

    /***
     * 新增SkuGoods数据
     * @param skuGoods
     * @return
     */
    @PostMapping
    Result add(@RequestBody SkuGoods skuGoods);

    /***
     * 根据ID查询SkuGoods数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SkuGoods> findById(@PathVariable Integer id);

    /***
     * 查询SkuGoods全部数据
     * @return
     */
    @GetMapping
    Result<List<SkuGoods>> findAll();
}
