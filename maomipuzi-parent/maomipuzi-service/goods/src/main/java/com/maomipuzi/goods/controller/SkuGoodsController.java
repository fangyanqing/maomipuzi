package com.maomipuzi.goods.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.pojo.SkuGoods;
import com.maomipuzi.goods.service.SkuGoodsService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 14:58
 **/
@Api(value = "商品独特属性")
@RestController
@RequestMapping("/skuGoods")
@CrossOrigin
public class SkuGoodsController {

    @Autowired
    private SkuGoodsService skuGoodsService;

    /***
     * SkuGoods分页条件搜索实现
     * @param skuGoods
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SkuGoods条件分页查询",notes = "分页条件查询SkuGoods方法详情",tags = {"SkuGoodsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", defaultValue = "1", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", defaultValue = "10", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SkuGoods对象",value = "传入JSON数据",required = false) SkuGoods skuGoods, @PathVariable  int page, @PathVariable  int size){
        //调用SkuGoodsService实现分页条件查询SkuGoods
        PageInfo<SkuGoods> pageInfo = skuGoodsService.findPage(skuGoods, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SkuGoods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SkuGoods分页查询",notes = "分页查询SkuGoods方法详情",tags = {"SkuGoodsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", defaultValue = "1",  required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", defaultValue = "10",  required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SkuGoodsService实现分页查询SkuGoods
        PageInfo<SkuGoods> pageInfo = skuGoodsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索数据
     * @param skuGoods
     * @return
     */
    @ApiOperation(value = "SkuGoods条件查询",notes = "条件查询SkuGoods方法详情",tags = {"SkuGoodsController"})
    @PostMapping(value = "/search" )
    public Result<List<SkuGoods>> findList(@RequestBody(required = false) @ApiParam(name = "SkuGoods对象",value = "传入JSON数据",required = false) SkuGoods skuGoods){
        //调用SkuGoodsService实现条件查询SkuGoods
        List<SkuGoods> list = skuGoodsService.findList(skuGoods);
        return new Result<List<SkuGoods>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SkuGoods根据ID删除",notes = "根据ID删除SkuGoods方法详情",tags = {"SkuGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SkuGoodsService实现根据主键删除
        skuGoodsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SkuGoods数据
     * @param skuGoods
     * @param id
     * @return
     */
    @ApiOperation(value = "SkuGoods根据ID修改",notes = "根据ID修改SkuGoods方法详情",tags = {"SkuGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "SkuGoods对象",value = "传入JSON数据",required = false) SkuGoods skuGoods,@PathVariable Integer id){
        //设置主键值
        skuGoods.setId(id);
        //调用SkuGoodsService实现修改SkuGoods
        skuGoodsService.update(skuGoods);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SkuGoods数据
     * @param skuGoods
     * @return
     */
    @ApiOperation(value = "SkuGoods添加",notes = "添加SkuGoods方法详情",tags = {"SkuGoodsController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "SkuGoods对象",value = "传入JSON数据",required = true) SkuGoods skuGoods){
        //调用SkuGoodsService实现添加SkuGoods
        skuGoodsService.add(skuGoods);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SkuGoods数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SkuGoods根据ID查询",notes = "根据ID查询SkuGoods方法详情",tags = {"SkuGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById{id}")
    public Result<SkuGoods> findById(@PathVariable Integer id){
        //调用SkuGoodsService实现根据主键查询SkuGoods
        SkuGoods skuGoods = skuGoodsService.findById(id);
        return new Result<SkuGoods>(true, StatusCode.OK,"查询成功",skuGoods);
    }

    /***
     * 查询SkuGoods全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SkuGoods",notes = "查询所SkuGoods有方法详情",tags = {"SkuGoodsController"})
    @GetMapping("/findAll")
    public Result<List<SkuGoods>> findAll(){
        //调用SkuGoodsService实现查询所有SkuGoods
        List<SkuGoods> list = skuGoodsService.findAll();
        return new Result<List<SkuGoods>>(true, StatusCode.OK,"查询成功",list) ;
    }
}

