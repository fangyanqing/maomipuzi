package com.maomipuzi.goods.feign;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.pojo.SpuGoods;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 15:04
 **/
//@FeignClient(name= "goods")
@RequestMapping("/spuGoods")
public interface SpuGoodsFeign {

    /***
     * SpuGoods分页条件搜索实现
     * @param spuGoods
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SpuGoods spuGoods, @PathVariable  int page, @PathVariable  int size);

    /***
     * SpuGoods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索数据
     * @param spuGoods
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SpuGoods>> findList(@RequestBody(required = false) SpuGoods spuGoods);

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SpuGoods数据
     * @param spuGoods
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SpuGoods spuGoods, @PathVariable Integer id);

    /***
     * 新增SpuGoods数据
     * @param spuGoods
     * @return
     */
    @PostMapping
    Result add(@RequestBody SpuGoods spuGoods);

    /***
     * 根据ID查询SpuGoods数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SpuGoods> findById(@PathVariable Integer id);

    /***
     * 查询SpuGoods全部数据
     * @return
     */
    @GetMapping
    Result<List<SpuGoods>> findAll();
}