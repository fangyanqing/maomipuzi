package com.maomipuzi.goods.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.Stock;
import com.maomipuzi.goods.service.StockService;
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

@Api(value = "库存管理")
@RestController
@RequestMapping("/stock")
@CrossOrigin
public class StockController {

    @Autowired
    private StockService stockService;

    /***
     * Stock分页条件搜索实现
     * @param stock
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Stock条件分页查询",notes = "分页条件查询Stock方法详情",tags = {"StockController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Stock对象",value = "传入JSON数据",required = false) Stock stock, @PathVariable  int page, @PathVariable  int size){
        //调用StockService实现分页条件查询Stock
        PageInfo<Stock> pageInfo = stockService.findPage(stock, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Stock分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Stock分页查询",notes = "分页查询Stock方法详情",tags = {"StockController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用StockService实现分页查询Stock
        PageInfo<Stock> pageInfo = stockService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索数据
     * @param stock
     * @return
     */
    @ApiOperation(value = "Stock条件查询",notes = "条件查询Stock方法详情",tags = {"StockController"})
    @PostMapping(value = "/search" )
    public Result<List<Stock>> findList(@RequestBody(required = false) @ApiParam(name = "Stock对象",value = "传入JSON数据",required = false) Stock stock){
        //调用StockService实现条件查询Stock
        List<Stock> list = stockService.findList(stock);
        return new Result<List<Stock>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Stock根据ID删除",notes = "根据ID删除Stock方法详情",tags = {"StockController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用StockService实现根据主键删除
        stockService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Stock数据
     * @param stock
     * @param id
     * @return
     */
    @ApiOperation(value = "Stock根据ID修改",notes = "根据ID修改Stock方法详情",tags = {"StockController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Stock对象",value = "传入JSON数据",required = false) Stock stock,@PathVariable Integer id){
        //设置主键值
        stock.setStockId(id);
        //调用StockService实现修改Stock
        stockService.update(stock);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Stock数据
     * @param stock
     * @return
     */
    @ApiOperation(value = "Stock添加",notes = "添加Stock方法详情",tags = {"StockController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "Stock对象",value = "传入JSON数据",required = true) Stock stock){
        //调用StockService实现添加Stock
        stockService.add(stock);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Stock数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Stock根据ID查询",notes = "根据ID查询Stock方法详情",tags = {"StockController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Stock> findById(@PathVariable Integer id){
        //调用StockService实现根据主键查询Stock
        Stock stock = stockService.findById(id);
        return new Result<Stock>(true,StatusCode.OK,"查询成功",stock);
    }

    /***
     * 查询Stock全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Stock",notes = "查询所Stock有方法详情",tags = {"StockController"})
    @GetMapping("/find")
    public Result<List<Stock>> findAll(){
        //调用StockService实现查询所有Stock
        List<Stock> list = stockService.findAll();
        return new Result<List<Stock>>(true, StatusCode.OK,"查询成功",list) ;
    }
}