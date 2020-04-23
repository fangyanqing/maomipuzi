package com.maomipuzi.logistics.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.logistics.pojo.Express;
import com.maomipuzi.logistics.service.ExpressService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:11
 **/
@Api(value = "快递公司管理")
@RestController
@RequestMapping("/express")
@CrossOrigin
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    /***
     * Express分页条件搜索实现
     * @param express
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "快递公司条件分页查询",notes = "分页条件查询快递公司方法详情",tags = {"ExpressController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Express对象",value = "传入JSON数据",required = false) Express express, @PathVariable  int page, @PathVariable  int size){
        //调用ExpressService实现分页条件查询Express
        PageInfo<Express> pageInfo = expressService.findPage(express, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Express分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "快递公司分页查询",notes = "分页查询快递公司方法详情",tags = {"ExpressController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ExpressService实现分页查询Express
        PageInfo<Express> pageInfo = expressService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param express
     * @return
     */
    @ApiOperation(value = "快递公司条件查询",notes = "条件查询快递公司方法详情",tags = {"ExpressController"})
    @PostMapping(value = "/search" )
    public Result<List<Express>> findList(@RequestBody(required = false) @ApiParam(name = "Express对象",value = "传入JSON数据",required = false) Express express){
        //调用ExpressService实现条件查询Express
        List<Express> list = expressService.findList(express);
        return new Result<List<Express>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "快递公司根据ID删除",notes = "根据ID删除快递公司方法详情",tags = {"ExpressController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用ExpressService实现根据主键删除
        expressService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Express数据
     * @param express
     * @param id
     * @return
     */
    @ApiOperation(value = "快递公司根据ID修改",notes = "根据ID修改快递公司方法详情",tags = {"ExpressController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Express对象",value = "传入JSON数据",required = false) Express express, @PathVariable Integer id){
        //设置主键值
        express.setId(id);
        //调用ExpressService实现修改Express
        expressService.update(express);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Express数据
     * @param express
     * @return
     */
    @ApiOperation(value = "快递公司添加",notes = "添加快递公司方法详情",tags = {"ExpressController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "Express对象",value = "传入JSON数据",required = true) Express express){
        //调用ExpressService实现添加Express
        expressService.add(express);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Express数据
     * @param id
     * @return
     */
    @ApiOperation(value = "快递公司根据ID查询",notes = "根据ID查询快递公司方法详情",tags = {"ExpressController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<Express> findById(@PathVariable Integer id){
        //调用ExpressService实现根据主键查询Express
        Express express = expressService.findById(id);
        return new Result<Express>(true, StatusCode.OK,"查询成功",express);
    }

    /***
     * 查询Express全部数据
     * @return
     */
    @ApiOperation(value = "查询所有快递公司",notes = "查询所快递公司有方法详情",tags = {"ExpressController"})
    @GetMapping("/findAll")
    public Result<List<Express>> findAll(){
        //调用ExpressService实现查询所有Express
        List<Express> list = expressService.findAll();
        return new Result<List<Express>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
