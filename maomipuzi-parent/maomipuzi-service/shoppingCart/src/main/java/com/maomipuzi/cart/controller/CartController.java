package com.maomipuzi.cart.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.cart.pojo.Cart;
import com.maomipuzi.cart.service.CartService;
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
@Api(value = "购物车管理")
@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    @Autowired
    private CartService cartService;

    /***
     * Cart分页条件搜索实现
     * @param cart
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "购物车条件分页查询",notes = "分页条件查询购物车方法详情",tags = {"CartController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Cart对象",value = "传入JSON数据",required = false) Cart cart, @PathVariable  int page, @PathVariable  int size){
        //调用CartService实现分页条件查询Car
        PageInfo<Cart> pageInfo = cartService.findPage(cart, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Car分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "购物车分页查询",notes = "分页查询购物车方法详情",tags = {"CartController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CartService实现分页查询Car
        PageInfo<Cart> pageInfo = cartService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param cart
     * @return
     */
    @ApiOperation(value = "购物车条件查询",notes = "条件查询购物车方法详情",tags = {"CartController"})
    @PostMapping(value = "/search" )
    public Result<List<Cart>> findList(@RequestBody(required = false) @ApiParam(name = "Car对象",value = "传入JSON数据",required = false) Cart cart){
        //调用CartService实现条件查询Car
        List<Cart> list = cartService.findList(cart);
        return new Result<List<Cart>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "购物车根据ID删除",notes = "根据ID删除购物车方法详情",tags = {"CartController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用CartService实现根据主键删除
        cartService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Car数据
     * @param cart
     * @param id
     * @return
     */
    @ApiOperation(value = "购物车根据ID修改",notes = "根据ID修改购物车方法详情",tags = {"CartController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Car对象",value = "传入JSON数据",required = false) Cart cart,@PathVariable Integer id){
        //设置主键值
        cart.setCartId(id);
        //调用CartService实现修改Car
        cartService.update(cart);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Car数据
     * @param cart
     * @return
     */
    @ApiOperation(value = "购物车添加",notes = "添加购物车方法详情",tags = {"CartController"})
    @PostMapping("/add")
    public Result add(@RequestBody @ApiParam(name = "购物车对象",value = "传入JSON数据",required = true) Cart cart){
        //调用CartService实现添加Car
        cartService.add(cart);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Car数据
     * @param id
     * @return
     */
    @ApiOperation(value = "购物车根据ID查询",notes = "根据ID查询购物车方法详情",tags = {"CartController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<Cart> findById(@PathVariable Integer id){
        //调用CartService实现根据主键查询Car
        Cart cart = cartService.findById(id);
        return new Result<Cart>(true,StatusCode.OK,"查询成功",cart);
    }

    /***
     * 查询Car全部数据
     * @return
     */
    @ApiOperation(value = "查询所有购物车",notes = "查询所有购物车方法详情",tags = {"CartController"})
    @GetMapping("/findAll")
    public Result<List<Cart>> findAll(){
        //调用CartService实现查询所有Car
        List<Cart> list = cartService.findAll();
        return new Result<List<Cart>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
