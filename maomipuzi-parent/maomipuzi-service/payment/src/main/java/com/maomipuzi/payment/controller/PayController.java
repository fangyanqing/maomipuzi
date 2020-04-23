package com.maomipuzi.payment.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.payment.pojo.Pay;
import com.maomipuzi.payment.service.PayService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 18:01
 **/
@Api(value = "支付类型管理")
@RestController
@RequestMapping("/pay")
@CrossOrigin
public class PayController {

    @Autowired
    private PayService payService;

    /***
     * Pay分页条件搜索实现
     * @param pay
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "支付类型条件分页查询",notes = "分页条件查询支付类型方法详情",tags = {"PayController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Pay对象",value = "传入JSON数据",required = false) Pay pay, @PathVariable  int page, @PathVariable  int size){
        //调用PayService实现分页条件查询Pay
        PageInfo<Pay> pageInfo = payService.findPage(pay, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Pay分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "支付类型分页查询",notes = "分页查询支付类型方法详情",tags = {"PayController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PayService实现分页查询Pay
        PageInfo<Pay> pageInfo = payService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pay
     * @return
     */
    @ApiOperation(value = "支付类型条件查询",notes = "条件查询支付类型方法详情",tags = {"PayController"})
    @PostMapping(value = "/search" )
    public Result<List<Pay>> findList(@RequestBody(required = false) @ApiParam(name = "Pay对象",value = "传入JSON数据",required = false) Pay pay){
        //调用PayService实现条件查询Pay
        List<Pay> list = payService.findList(pay);
        return new Result<List<Pay>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "支付类型根据ID删除",notes = "根据ID删除支付类型方法详情",tags = {"PayController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PayService实现根据主键删除
        payService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Pay数据
     * @param pay
     * @param id
     * @return
     */
    @ApiOperation(value = "支付类型根据ID修改",notes = "根据ID修改支付类型方法详情",tags = {"PayController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Pay对象",value = "传入JSON数据",required = false) Pay pay, @PathVariable Integer id){
        //设置主键值
        pay.setPayId(id);
        //调用PayService实现修改Pay
        payService.update(pay);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Pay数据
     * @param pay
     * @return
     */
    @ApiOperation(value = "支付类型添加",notes = "添加支付类型方法详情",tags = {"PayController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "Pay对象",value = "传入JSON数据",required = true) Pay pay){
        //调用PayService实现添加Pay
        payService.add(pay);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Pay数据
     * @param id
     * @return
     */
    @ApiOperation(value = "支付类型根据ID查询",notes = "根据ID查询支付类型方法详情",tags = {"PayController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<Pay> findById(@PathVariable Integer id){
        //调用PayService实现根据主键查询Pay
        Pay pay = payService.findById(id);
        return new Result<Pay>(true, StatusCode.OK,"查询成功",pay);
    }

    /***
     * 查询Pay全部数据
     * @return
     */
    @ApiOperation(value = "查询所有支付类型",notes = "查询所支付类型有方法详情",tags = {"PayController"})
    @GetMapping("/findAll")
    public Result<List<Pay>> findAll(){
        //调用PayService实现查询所有Pay
        List<Pay> list = payService.findAll();
        return new Result<List<Pay>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
