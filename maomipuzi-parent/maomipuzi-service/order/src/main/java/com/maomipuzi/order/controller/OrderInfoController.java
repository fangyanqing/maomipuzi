package com.maomipuzi.order.controller;


import com.github.pagehelper.PageInfo;
import com.maomipuzi.order.pojo.OrderInfo;
import com.maomipuzi.order.service.OrderInfoService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 15:25
 **/
@Api(value = "OrderInfoController")
@RestController
@RequestMapping("/orderInfo")
@CrossOrigin
public class OrderInfoController   {
    @Autowired
    private OrderInfoService orderInfoService;

    /***
     * OrderInfo分页条件搜索实现
     * @param orderInfo
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "OrderInfo条件分页查询",notes = "分页条件查询OrderInfo方法详情",tags = {"OrderInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "OrderInfo对象",value = "传入JSON数据",required = false) OrderInfo orderInfo, @PathVariable  int page, @PathVariable  int size){
        //调用OrderInfoService实现分页条件查询OrderInfo
        PageInfo<OrderInfo> pageInfo = orderInfoService.findPage(orderInfo, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OrderInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "OrderInfo分页查询",notes = "分页查询OrderInfo方法详情",tags = {"OrderInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OrderInfoService实现分页查询OrderInfo
        PageInfo<OrderInfo> pageInfo = orderInfoService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param orderInfo
     * @return
     */
    @ApiOperation(value = "OrderInfo条件查询",notes = "条件查询OrderInfo方法详情",tags = {"OrderInfoController"})
    @PostMapping(value = "/search" )
    public Result<List<OrderInfo>> findList(@RequestBody(required = false) @ApiParam(name = "OrderInfo对象",value = "传入JSON数据",required = false) OrderInfo orderInfo){
        //调用OrderInfoService实现条件查询OrderInfo
        List<OrderInfo> list = orderInfoService.findList(orderInfo);
        return new Result<List<OrderInfo>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OrderInfo根据ID删除",notes = "根据ID删除OrderInfo方法详情",tags = {"OrderInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用OrderInfoService实现根据主键删除
        orderInfoService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OrderInfo数据
     * @param orderInfo
     * @param id
     * @return
     */
    @ApiOperation(value = "OrderInfo根据ID修改",notes = "根据ID修改OrderInfo方法详情",tags = {"OrderInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "OrderInfo对象",value = "传入JSON数据",required = false) OrderInfo orderInfo,@PathVariable Integer id){
        //设置主键值
        orderInfo.setId(id);
        //调用OrderInfoService实现修改OrderInfo
        orderInfoService.update(orderInfo);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OrderInfo数据
     * @param orderInfo
     * @return
     */
    @ApiOperation(value = "OrderInfo添加",notes = "添加OrderInfo方法详情",tags = {"OrderInfoController"})
    @PostMapping("add")
    public Result add(@RequestBody  @ApiParam(name = "OrderInfo对象",value = "传入JSON数据",required = true) OrderInfo orderInfo){
        //调用OrderInfoService实现添加OrderInfo
        orderInfoService.add(orderInfo);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OrderInfo数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OrderInfo根据ID查询",notes = "根据ID查询OrderInfo方法详情",tags = {"OrderInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<OrderInfo> findById(@PathVariable Integer id){
        //调用OrderInfoService实现根据主键查询OrderInfo
        OrderInfo orderInfo = orderInfoService.findById(id);
        return new Result<OrderInfo>(true,StatusCode.OK,"查询成功",orderInfo);
    }

    /***
     * 查询OrderInfo全部数据
     * @return
     */
    @ApiOperation(value = "查询所有OrderInfo",notes = "查询所OrderInfo有方法详情",tags = {"OrderInfoController"})
    @GetMapping("/findAll")
    public Result<List<OrderInfo>> findAll(){
        //调用OrderInfoService实现查询所有OrderInfo
        List<OrderInfo> list = orderInfoService.findAll();
        return new Result<List<OrderInfo>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
