package com.maomipuzi.logistics.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.logistics.pojo.Pickup;
import com.maomipuzi.logistics.service.PickupService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:10
 **/
@Api(value = "门店自提管理")
@RestController
@RequestMapping("/pickup")
@CrossOrigin
public class PickupController {

    @Autowired
    private PickupService pickupService;

    /***
     * Pickup分页条件搜索实现
     * @param pickup
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "门店自提条件分页查询",notes = "分页条件查询门店自提方法详情",tags = {"PickupController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Pickup对象",value = "传入JSON数据",required = false) Pickup pickup, @PathVariable  int page, @PathVariable  int size){
        //调用PickupService实现分页条件查询Pickup
        PageInfo<Pickup> pageInfo = pickupService.findPage(pickup, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Pickup分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "门店自提分页查询",notes = "分页查询门店自提方法详情",tags = {"PickupController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PickupService实现分页查询Pickup
        PageInfo<Pickup> pageInfo = pickupService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pickup
     * @return
     */
    @ApiOperation(value = "门店自提条件查询",notes = "条件查询门店自提方法详情",tags = {"PickupController"})
    @PostMapping(value = "/search" )
    public Result<List<Pickup>> findList(@RequestBody(required = false) @ApiParam(name = "Pickup对象",value = "传入JSON数据",required = false) Pickup pickup){
        //调用PickupService实现条件查询Pickup
        List<Pickup> list = pickupService.findList(pickup);
        return new Result<List<Pickup>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "门店自提根据ID删除",notes = "根据ID删除门店自提方法详情",tags = {"PickupController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PickupService实现根据主键删除
        pickupService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Pickup数据
     * @param pickup
     * @param id
     * @return
     */
    @ApiOperation(value = "门店自提根据ID修改",notes = "根据ID修改门店自提方法详情",tags = {"PickupController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Pickup对象",value = "传入JSON数据",required = false) Pickup pickup,@PathVariable Integer id){
        //设置主键值
        pickup.setPickupId(id);
        //调用PickupService实现修改Pickup
        pickupService.update(pickup);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Pickup数据
     * @param pickup
     * @return
     */
    @ApiOperation(value = "门店自提添加",notes = "添加门店自提方法详情",tags = {"PickupController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "Pickup对象",value = "传入JSON数据",required = true) Pickup pickup){
        //调用PickupService实现添加Pickup
        pickupService.add(pickup);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Pickup数据
     * @param id
     * @return
     */
    @ApiOperation(value = "门店自提根据ID查询",notes = "根据ID查询门店自提方法详情",tags = {"PickupController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<Pickup> findById(@PathVariable Integer id){
        //调用PickupService实现根据主键查询Pickup
        Pickup pickup = pickupService.findById(id);
        return new Result<Pickup>(true, StatusCode.OK,"查询成功",pickup);
    }

    /***
     * 查询Pickup全部数据
     * @return
     */
    @ApiOperation(value = "查询所有门店自提",notes = "查询所门店自提有方法详情",tags = {"PickupController"})
    @GetMapping("findAll")
    public Result<List<Pickup>> findAll(){
        //调用PickupService实现查询所有Pickup
        List<Pickup> list = pickupService.findAll();
        return new Result<List<Pickup>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
