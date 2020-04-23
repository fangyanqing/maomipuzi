package com.maomipuzi.order.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.order.pojo.OrderOperation;
import com.maomipuzi.order.service.OrderOperationService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 15:26
 **/
@Api(value = "订单操作")
@RestController
@RequestMapping("/orderOperation")
@CrossOrigin
public class OrderOperationController {
    @Autowired
    private OrderOperationService orderOperationService;

    /***
     * OrderStatus分页条件搜索实现
     * @param orderOperation
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "订单操作条件分页查询",notes = "分页条件查询订单操作方法详情",tags = {"OrderOperationController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "OrderStatus对象",value = "传入JSON数据",required = false) OrderOperation orderOperation, @PathVariable  int page, @PathVariable  int size){
        //调用OrderStatusService实现分页条件查询OrderStatus
        PageInfo<OrderOperation> pageInfo = orderOperationService.findPage(orderOperation, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OrderStatus分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "订单操作分页查询",notes = "分页查询订单操作方法详情",tags = {"OrderOperationController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OrderStatusService实现分页查询OrderStatus
        PageInfo<OrderOperation> pageInfo = orderOperationService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param orderOperation
     * @return
     */
    @ApiOperation(value = "订单操作条件查询",notes = "条件查询订单操作方法详情",tags = {"OrderOperationController"})
    @PostMapping(value = "/search" )
    public Result<List<OrderOperation>> findList(@RequestBody(required = false) @ApiParam(name = "OrderStatus对象",value = "传入JSON数据",required = false) OrderOperation orderOperation){
        //调用OrderStatusService实现条件查询OrderStatus
        List<OrderOperation> list = orderOperationService.findList(orderOperation);
        return new Result<List<OrderOperation>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "订单操作根据ID删除",notes = "根据ID删除订单操作方法详情",tags = {"OrderOperationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用OrderStatusService实现根据主键删除
        orderOperationService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OrderStatus数据
     * @param orderOperation
     * @param id
     * @return
     */
    @ApiOperation(value = "订单操作根据ID修改",notes = "根据ID修改订单操作方法详情",tags = {"OrderOperationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "OrderStatus对象",value = "传入JSON数据",required = false) OrderOperation orderOperation,@PathVariable Integer id){
        //设置主键值
        orderOperation.setId(id);
        //调用OrderStatusService实现修改OrderStatus
        orderOperationService.update(orderOperation);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OrderStatus数据
     * @param orderOperation
     * @return
     */
    @ApiOperation(value = "订单操作添加",notes = "添加订单操作方法详情",tags = {"OrderOperationController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "OrderStatus对象",value = "传入JSON数据",required = true) OrderOperation orderOperation){
        //调用OrderStatusService实现添加OrderStatus
        orderOperationService.add(orderOperation);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OrderStatus数据
     * @param id
     * @return
     */
    @ApiOperation(value = "订单操作根据ID查询",notes = "根据ID查询订单操作方法详情",tags = {"OrderOperationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<OrderOperation> findById(@PathVariable Integer id){
        //调用OrderStatusService实现根据主键查询OrderStatus
        OrderOperation orderOperation = orderOperationService.findById(id);
        return new Result<OrderOperation>(true, StatusCode.OK,"查询成功",orderOperation);
    }

    /***
     * 查询OrderStatus全部数据
     * @return
     */
    @ApiOperation(value = "查询所有订单操作",notes = "查询所订单操作有方法详情",tags = {"OrderOperationController"})
    @GetMapping("/findAll")
    public Result<List<OrderOperation>> findAll(){
        //调用OrderStatusService实现查询所有OrderStatus
        List<OrderOperation> list = orderOperationService.findAll();
        return new Result<List<OrderOperation>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
