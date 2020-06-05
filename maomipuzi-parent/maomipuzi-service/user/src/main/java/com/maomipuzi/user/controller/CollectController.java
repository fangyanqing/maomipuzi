package com.maomipuzi.user.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.user.pojo.Collect;
import com.maomipuzi.user.service.CollectService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-05 20:13
 **/
@Api(value = "CollectController")
@RestController
@RequestMapping("/collect")
@CrossOrigin
public class CollectController {

    @Autowired
    private CollectService collectService;

    /***
     * Collect分页条件搜索实现
     * @param collect
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Collect条件分页查询",notes = "分页条件查询Collect方法详情",tags = {"CollectController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Collect对象",value = "传入JSON数据",required = false) Collect collect, @PathVariable  int page, @PathVariable  int size){
        //调用CollectService实现分页条件查询Collect
        PageInfo<Collect> pageInfo = collectService.findPage(collect, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Collect分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Collect分页查询",notes = "分页查询Collect方法详情",tags = {"CollectController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CollectService实现分页查询Collect
        PageInfo<Collect> pageInfo = collectService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param collect
     * @return
     */
    @ApiOperation(value = "Collect条件查询",notes = "条件查询Collect方法详情",tags = {"CollectController"})
    @PostMapping(value = "/search" )
    public Result<List<Collect>> findList(@RequestBody(required = false) @ApiParam(name = "Collect对象",value = "传入JSON数据",required = false) Collect collect){
        //调用CollectService实现条件查询Collect
        List<Collect> list = collectService.findList(collect);
        return new Result<List<Collect>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Collect根据ID删除",notes = "根据ID删除Collect方法详情",tags = {"CollectController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用CollectService实现根据主键删除
        collectService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Collect数据
     * @param collect
     * @param id
     * @return
     */
    @ApiOperation(value = "Collect根据ID修改",notes = "根据ID修改Collect方法详情",tags = {"CollectController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Collect对象",value = "传入JSON数据",required = false) Collect collect, @PathVariable Integer id){
        //设置主键值
        collect.setCollectId(id);
        //调用CollectService实现修改Collect
        collectService.update(collect);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Collect数据
     * @param collect
     * @return
     */
    @ApiOperation(value = "Collect添加",notes = "添加Collect方法详情",tags = {"CollectController"})
    @PostMapping(value = "/add")
    public Result add(@RequestBody  @ApiParam(name = "Collect对象",value = "传入JSON数据",required = true) Collect collect){
        //调用CollectService实现添加Collect
        collectService.add(collect);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Collect数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Collect根据ID查询",notes = "根据ID查询Collect方法详情",tags = {"CollectController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<Collect> findById(@PathVariable Integer id){
        //调用CollectService实现根据主键查询Collect
        Collect collect = collectService.findById(id);
        return new Result<Collect>(true, StatusCode.OK,"查询成功",collect);
    }

    /***
     * 查询Collect全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Collect",notes = "查询所Collect有方法详情",tags = {"CollectController"})
    @GetMapping(value = "/findAll")
    public Result<List<Collect>> findAll(){
        //调用CollectService实现查询所有Collect
        List<Collect> list = collectService.findAll();
        return new Result<List<Collect>>(true, StatusCode.OK,"查询成功",list) ;
    }


}

