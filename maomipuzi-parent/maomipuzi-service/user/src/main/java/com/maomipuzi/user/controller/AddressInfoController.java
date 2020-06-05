package com.maomipuzi.user.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.user.pojo.AddressInfo;
import com.maomipuzi.user.service.AddressInfoService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-05 20:24
 **/
@Api(value = "AddressInfoController")
@RestController
@RequestMapping("/addressInfo")
@CrossOrigin
public class AddressInfoController {

    @Autowired
    private AddressInfoService addressInfoService;

    /***
     * AddressInfo分页条件搜索实现
     * @param addressInfo
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "AddressInfo条件分页查询",notes = "分页条件查询AddressInfo方法详情",tags = {"AddressInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "AddressInfo对象",value = "传入JSON数据",required = false) AddressInfo addressInfo, @PathVariable  int page, @PathVariable  int size){
        //调用AddressInfoService实现分页条件查询AddressInfo
        PageInfo<AddressInfo> pageInfo = addressInfoService.findPage(addressInfo, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * AddressInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "AddressInfo分页查询",notes = "分页查询AddressInfo方法详情",tags = {"AddressInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用AddressInfoService实现分页查询AddressInfo
        PageInfo<AddressInfo> pageInfo = addressInfoService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param addressInfo
     * @return
     */
    @ApiOperation(value = "AddressInfo条件查询",notes = "条件查询AddressInfo方法详情",tags = {"AddressInfoController"})
    @PostMapping(value = "/search" )
    public Result<List<AddressInfo>> findList(@RequestBody(required = false) @ApiParam(name = "AddressInfo对象",value = "传入JSON数据",required = false) AddressInfo addressInfo){
        //调用AddressInfoService实现条件查询AddressInfo
        List<AddressInfo> list = addressInfoService.findList(addressInfo);
        return new Result<List<AddressInfo>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AddressInfo根据ID删除",notes = "根据ID删除AddressInfo方法详情",tags = {"AddressInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用AddressInfoService实现根据主键删除
        addressInfoService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改AddressInfo数据
     * @param addressInfo
     * @param id
     * @return
     */
    @ApiOperation(value = "AddressInfo根据ID修改",notes = "根据ID修改AddressInfo方法详情",tags = {"AddressInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "AddressInfo对象",value = "传入JSON数据",required = false) AddressInfo addressInfo,@PathVariable Integer id){
        //设置主键值
        addressInfo.setAddressInfoId(id);
        //调用AddressInfoService实现修改AddressInfo
        addressInfoService.update(addressInfo);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增AddressInfo数据
     * @param addressInfo
     * @return
     */
    @ApiOperation(value = "AddressInfo添加",notes = "添加AddressInfo方法详情",tags = {"AddressInfoController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "AddressInfo对象",value = "传入JSON数据",required = true) AddressInfo addressInfo){
        //调用AddressInfoService实现添加AddressInfo
        addressInfoService.add(addressInfo);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询AddressInfo数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AddressInfo根据ID查询",notes = "根据ID查询AddressInfo方法详情",tags = {"AddressInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<AddressInfo> findById(@PathVariable Integer id){
        //调用AddressInfoService实现根据主键查询AddressInfo
        AddressInfo addressInfo = addressInfoService.findById(id);
        return new Result<AddressInfo>(true, StatusCode.OK,"查询成功",addressInfo);
    }

    /***
     * 查询AddressInfo全部数据
     * @return
     */
    @ApiOperation(value = "查询所有AddressInfo",notes = "查询所AddressInfo有方法详情",tags = {"AddressInfoController"})
    @GetMapping
    public Result<List<AddressInfo>> findAll(){
        //调用AddressInfoService实现查询所有AddressInfo
        List<AddressInfo> list = addressInfoService.findAll();
        return new Result<List<AddressInfo>>(true, StatusCode.OK,"查询成功",list) ;
    }
}

