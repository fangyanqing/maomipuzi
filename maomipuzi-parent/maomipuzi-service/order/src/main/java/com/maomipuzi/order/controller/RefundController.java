package com.maomipuzi.order.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.order.pojo.Refund;
import com.maomipuzi.order.service.RefundService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 16:03
 **/
@Api(value = "退款管理")
@RestController
@RequestMapping("/refund")
@CrossOrigin
public class RefundController {

    @Autowired
    private RefundService refundService;

    /***
     * Refund分页条件搜索实现
     * @param refund
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Refund条件分页查询",notes = "分页条件查询Refund方法详情",tags = {"RefundController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Refund对象",value = "传入JSON数据",required = false) Refund refund, @PathVariable  int page, @PathVariable  int size){
        //调用RefundService实现分页条件查询Refund
        PageInfo<Refund> pageInfo = refundService.findPage(refund, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Refund分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Refund分页查询",notes = "分页查询Refund方法详情",tags = {"RefundController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RefundService实现分页查询Refund
        PageInfo<Refund> pageInfo = refundService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param refund
     * @return
     */
    @ApiOperation(value = "Refund条件查询",notes = "条件查询Refund方法详情",tags = {"RefundController"})
    @PostMapping(value = "/search" )
    public Result<List<Refund>> findList(@RequestBody(required = false) @ApiParam(name = "Refund对象",value = "传入JSON数据",required = false) Refund refund){
        //调用RefundService实现条件查询Refund
        List<Refund> list = refundService.findList(refund);
        return new Result<List<Refund>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Refund根据ID删除",notes = "根据ID删除Refund方法详情",tags = {"RefundController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RefundService实现根据主键删除
        refundService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Refund数据
     * @param refund
     * @param id
     * @return
     */
    @ApiOperation(value = "Refund根据ID修改",notes = "根据ID修改Refund方法详情",tags = {"RefundController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Refund对象",value = "传入JSON数据",required = false) Refund refund,@PathVariable Integer id){
        //设置主键值
        refund.setId(id);
        //调用RefundService实现修改Refund
        refundService.update(refund);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Refund数据
     * @param refund
     * @return
     */
    @ApiOperation(value = "Refund添加",notes = "添加Refund方法详情",tags = {"RefundController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "Refund对象",value = "传入JSON数据",required = true) Refund refund){
        //调用RefundService实现添加Refund
        refundService.add(refund);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Refund数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Refund根据ID查询",notes = "根据ID查询Refund方法详情",tags = {"RefundController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<Refund> findById(@PathVariable Integer id){
        //调用RefundService实现根据主键查询Refund
        Refund refund = refundService.findById(id);
        return new Result<Refund>(true,StatusCode.OK,"查询成功",refund);
    }

    /***
     * 查询Refund全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Refund",notes = "查询所Refund有方法详情",tags = {"RefundController"})
    @GetMapping("/findAll")
    public Result<List<Refund>> findAll(){
        //调用RefundService实现查询所有Refund
        List<Refund> list = refundService.findAll();
        return new Result<List<Refund>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
