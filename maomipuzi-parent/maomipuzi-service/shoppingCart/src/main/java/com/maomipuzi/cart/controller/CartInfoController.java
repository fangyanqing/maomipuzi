package com.maomipuzi.cart.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.cart.pojo.CartInfo;
import com.maomipuzi.cart.service.CartInfoService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:07
 **/
@Api(value = "购物车详情")
@RestController
@RequestMapping("/cartInfo")
@CrossOrigin
public class CartInfoController {
    @Autowired
    private CartInfoService cartInfoService;

    /***
     * CarInfo分页条件搜索实现
     * @param cartInfo
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "购物车详情条件分页查询",notes = "分页条件查询购物车详情方法详情",tags = {"CartInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "CarInfo对象",value = "传入JSON数据",required = false) CartInfo cartInfo, @PathVariable  int page, @PathVariable  int size){
        //调用CarInfoService实现分页条件查询CarInfo
        PageInfo<CartInfo> pageInfo = cartInfoService.findPage(cartInfo, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * CarInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "购物车详情分页查询",notes = "分页查询购物车详情方法详情",tags = {"CartInfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CarInfoService实现分页查询CarInfo
        PageInfo<CartInfo> pageInfo = cartInfoService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param cartInfo
     * @return
     */
    @ApiOperation(value = "购物车详情条件查询",notes = "条件查询购物车详情方法详情",tags = {"CartInfoController"})
    @PostMapping(value = "/search" )
    public Result<List<CartInfo>> findList(@RequestBody(required = false) @ApiParam(name = "CarInfo对象",value = "传入JSON数据",required = false) CartInfo cartInfo){
        //调用CarInfoService实现条件查询CarInfo
        List<CartInfo> list = cartInfoService.findList(cartInfo);
        return new Result<List<CartInfo>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "购物车详情根据ID删除",notes = "根据ID删除购物车详情方法详情",tags = {"CartInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用CarInfoService实现根据主键删除
        cartInfoService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改CarInfo数据
     * @param cartInfo
     * @param id
     * @return
     */
    @ApiOperation(value = "购物车详情根据ID修改",notes = "根据ID修改购物车详情方法详情",tags = {"CartInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "CarInfo对象",value = "传入JSON数据",required = false) CartInfo cartInfo,@PathVariable Integer id){
        //设置主键值
        cartInfo.setCarInfoId(id);
        //调用CarInfoService实现修改CarInfo
        cartInfoService.update(cartInfo);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增CarInfo数据
     * @param cartInfo
     * @return
     */
    @ApiOperation(value = "购物车详情添加",notes = "添加购物车详情方法详情",tags = {"CartInfoController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "CarInfo对象",value = "传入JSON数据",required = true) CartInfo cartInfo){
        //调用CarInfoService实现添加CarInfo
        cartInfoService.add(cartInfo);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询CarInfo数据
     * @param id
     * @return
     */
    @ApiOperation(value = "购物车详情根据ID查询",notes = "根据ID查询购物车详情方法详情",tags = {"CartInfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<CartInfo> findById(@PathVariable Integer id){
        //调用CarInfoService实现根据主键查询CarInfo
        CartInfo cartInfo = cartInfoService.findById(id);
        return new Result<CartInfo>(true,StatusCode.OK,"查询成功",cartInfo);
    }

    /***
     * 查询CarInfo全部数据
     * @return
     */
    @ApiOperation(value = "查询所有购物车详情",notes = "查询所购物车详情有方法详情",tags = {"CartInfoController"})
    @GetMapping("/findAlll")
    public Result<List<CartInfo>> findAll(){
        //调用CarInfoService实现查询所有CarInfo
        List<CartInfo> list = cartInfoService.findAll();
        return new Result<List<CartInfo>>(true, StatusCode.OK,"查询成功",list) ;
    }

}
