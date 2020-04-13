package com.maomipuzi.goods.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.pojo.Type;
import com.maomipuzi.goods.service.TypeService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/
@Api(value = "TypeController")
@RestController
@RequestMapping("/type")
@CrossOrigin
public class TypeController {

    @Autowired
    private TypeService typeService;

    /***
     * Type分页条件搜索实现
     * @param type
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Type条件分页查询", notes = "分页条件查询Type方法详情", tags = {"TypeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Type对象", value = "传入JSON数据", required = false) Type type, @PathVariable int page, @PathVariable int size) {
        //调用TypeService实现分页条件查询Type
        PageInfo<Type> pageInfo = typeService.findPage(type, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * Type分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Type分页查询", notes = "分页查询Type方法详情", tags = {"TypeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {
        //调用TypeService实现分页查询Type
        PageInfo<Type> pageInfo = typeService.findPage(page, size);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param type
     * @return
     */
    @ApiOperation(value = "Type条件查询", notes = "条件查询Type方法详情", tags = {"TypeController"})
    @PostMapping(value = "/search")
    public Result<List<Type>> findList(@RequestBody(required = false) @ApiParam(name = "Type对象", value = "传入JSON数据", required = false) Type type) {
        //调用TypeService实现条件查询Type
        List<Type> list = typeService.findList(type);
        return new Result<List<Type>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Type根据ID删除", notes = "根据ID删除Type方法详情", tags = {"TypeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}")
    public Result delete(@PathVariable Integer id) {
        //调用TypeService实现根据主键删除
        typeService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 修改Type数据
     * @param type
     * @param id
     * @return
     */
    @ApiOperation(value = "Type根据ID修改", notes = "根据ID修改Type方法详情", tags = {"TypeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value = "/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Type对象", value = "传入JSON数据", required = false) Type type, @PathVariable Integer id) {
        //设置主键值
        type.setTypeId(id);
        //调用TypeService实现修改Type
        typeService.update(type);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 新增Type数据
     * @param type
     * @return
     */
    @ApiOperation(value = "Type添加", notes = "添加Type方法详情", tags = {"TypeController"})
    @PostMapping("/add")
    public Result add(@RequestBody @ApiParam(name = "Type对象", value = "传入JSON数据", required = true) Type type) {
        //调用TypeService实现添加Type
        typeService.add(type);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /***
     * 根据ID查询Type数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Type根据ID查询", notes = "根据ID查询Type方法详情", tags = {"TypeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById{id}")
    public Result<Type> findById(@PathVariable Integer id) {
        //调用TypeService实现根据主键查询Type
        Type type = typeService.findById(id);
        return new Result<Type>(true, StatusCode.OK, "查询成功", type);
    }

    /***
     * 查询Type全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Type", notes = "查询所Type有方法详情", tags = {"TypeController"})
    @GetMapping("/findAll")
    public Result<List<Type>> findAll() {
        //调用TypeService实现查询所有Type
        List<Type> list = typeService.findAll();
        return new Result<List<Type>>(true, StatusCode.OK, "查询成功", list);
    }
}
