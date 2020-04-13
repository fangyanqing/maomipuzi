package com.maomipuzi.goods.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.pojo.Goods;
import com.maomipuzi.goods.pojo.SpuGoods;
import com.maomipuzi.goods.service.SpuGoodsService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 14:52
 **/
@Api(value = "商品公共属性")
@RestController
@RequestMapping("/spuGoods")
@CrossOrigin
public class SpuGoodsController {

    @Autowired
    private SpuGoodsService spuGoodsService;


    @ApiOperation(value = "商品批量上架",notes = "商品批量上架方法",tags = {"SpuGoodsController"})
    @PutMapping(value = "/putMany")
    public Result putMany(@RequestBody Integer[] ids){
        spuGoodsService.putMany(ids);
        return new Result(true,StatusCode.OK,"批量上架成功");
    }

    /**
     * 上架
     */
    @ApiOperation(value = "商品上架",notes = "商品上架方法",tags = {"SpuGoodsController"})
    @PutMapping(value = "/put/{id}")
    public Result put(@PathVariable Integer id){
        spuGoodsService.put(id);
        return new Result(true,StatusCode.OK,"上架成功");
    }

    /**
     * 下架
     */
    @ApiOperation(value = "商品下架",notes = "商品下架方法",tags = {"SpuGoodsController"})
    @PutMapping(value = "/pull/{id}")
    public Result pull(@PathVariable Integer id){
        spuGoodsService.pull(id);
        return new Result(true,StatusCode.OK,"下架成功");
    }

    /**
     * 修改审批状态
     */
    @ApiOperation(value = "商品审批",notes = "商品审批方法",tags = {"SpuGoodsController"})
    @PutMapping(value = "/audit/{id}")
    public Result audit(@PathVariable Integer id){
        spuGoodsService.audit(id);
        return new Result(true,StatusCode.OK,"审核成功");
    }

    /**
     * 修改商品信息
     */
    @ApiOperation(value = "商品修改",notes = "商品修改方法",tags = {"SpuGoodsController"})
    @PutMapping(value = "/updateGoods/{id}")
    public Result updateGoods(@RequestBody Goods goods,
                              @PathVariable Integer id){
        spuGoodsService.updateGoods(goods);
        return new Result(true,StatusCode.OK,"修改商品成功");
    }

    /**
     * 根据商品ID查询商品信息
     */
    @ApiOperation(value = "商品查询",notes = "商品查询方法",tags = {"SpuGoodsController"})
    @GetMapping("/findGoods/{spuId}")
    public Result findGoodsById(@PathVariable Integer spuId){
        Goods goods = spuGoodsService.findGoodsById(spuId);
        return new Result(true, StatusCode.OK,"查询商品成功",goods);
    }

    /**
     * 添加商品
     * @return
     */
    @ApiOperation(value = "商品添加",notes = "商品添加方法",tags = {"SpuGoodsController"})
    @PostMapping("/save")
    public Result saveGoods(@RequestBody Goods goods){
        spuGoodsService.saveGoods(goods);
        return new Result(true,StatusCode.OK,"添加商品成功");
    }

    /***
     * SpuGoods分页条件搜索实现
     * @param spuGoods
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SpuGoods条件分页查询",notes = "分页条件查询SpuGoods方法详情",tags = {"SpuGoodsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true,defaultValue="1", dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, defaultValue="10",dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "SpuGoods对象",value = "传入JSON数据",required = false) SpuGoods spuGoods, @PathVariable  int page, @PathVariable  int size){
        //调用SpuGoodsService实现分页条件查询SpuGoods
        PageInfo<SpuGoods> pageInfo = spuGoodsService.findPage(spuGoods, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SpuGoods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SpuGoods分页查询",notes = "分页查询SpuGoods方法详情",tags = {"SpuGoodsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, defaultValue="1",dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, defaultValue="10",dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SpuGoodsService实现分页查询SpuGoods
        PageInfo<SpuGoods> pageInfo = spuGoodsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索数据
     * @param spuGoods
     * @return
     */
    @ApiOperation(value = "SpuGoods条件查询",notes = "条件查询SpuGoods方法详情",tags = {"SpuGoodsController"})
    @PostMapping(value = "/search" )
    public Result<List<SpuGoods>> findList(@RequestBody(required = false) @ApiParam(name = "SpuGoods对象",value = "传入JSON数据",required = false) SpuGoods spuGoods){
        //调用SpuGoodsService实现条件查询SpuGoods
        List<SpuGoods> list = spuGoodsService.findList(spuGoods);
        return new Result<List<SpuGoods>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SpuGoods根据ID逻辑删除",notes = "根据ID逻辑删除SpuGoods方法详情",tags = {"SpuGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SpuGoodsService实现根据主键删除
        spuGoodsService.delete(id);
        return new Result(true,StatusCode.OK,"逻辑删除成功");
    }

    /**
     * 数据恢复
     * @param id
     * @return
     */
    @ApiOperation(value = "数据恢复",notes = "对逻辑删除的数据进行数据恢复",tags = {"SpuGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value = "/restore/{id}" )
    public Result restore(@PathVariable Integer id){
        spuGoodsService.restore(id);
        return new Result(true,StatusCode.OK,"数据恢复成功");
    }

    /**
     * 物理删除，实现真正的删除
     * @param id
     * @return
     */
    @ApiOperation(value = "物理删除",notes = "永久删除，无法恢复数据",tags = {"SpuGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/realDelete/{id}" )
    public Result realDelete(@PathVariable Integer id){
        spuGoodsService.realDelete(id);
        return new Result(true,StatusCode.OK,"永久删除成功");
    }

    /***
     * 修改SpuGoods数据
     * @param spuGoods
     * @param id
     * @return
     */
    @ApiOperation(value = "SpuGoods根据ID修改",notes = "根据ID修改SpuGoods方法详情",tags = {"SpuGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "SpuGoods对象",value = "传入JSON数据",required = false) SpuGoods spuGoods,@PathVariable Integer id){
        //设置主键值
        spuGoods.setId(id);
        //调用SpuGoodsService实现修改SpuGoods
        spuGoodsService.update(spuGoods);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SpuGoods数据
     * @param spuGoods
     * @return
     */
    @ApiOperation(value = "SpuGoods添加",notes = "添加SpuGoods方法详情",tags = {"SpuGoodsController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "SpuGoods对象",value = "传入JSON数据",required = true) SpuGoods spuGoods){
        //调用SpuGoodsService实现添加SpuGoods
        spuGoodsService.add(spuGoods);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SpuGoods数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SpuGoods根据ID查询",notes = "根据ID查询SpuGoods方法详情",tags = {"SpuGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById{id}")
    public Result<SpuGoods> findById(@PathVariable Integer id){
        //调用SpuGoodsService实现根据主键查询SpuGoods
        SpuGoods spuGoods = spuGoodsService.findById(id);
        return new Result<SpuGoods>(true, StatusCode.OK,"查询成功",spuGoods);
    }

    /***
     * 查询SpuGoods全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SpuGoods",notes = "查询所SpuGoods有方法详情",tags = {"SpuGoodsController"})
    @GetMapping("/findAll")
    public Result<List<SpuGoods>> findAll(){
        //调用SpuGoodsService实现查询所有SpuGoods
        List<SpuGoods> list = spuGoodsService.findAll();
        return new Result<List<SpuGoods>>(true, StatusCode.OK,"查询成功",list) ;
    }
}

