package com.maomipuzi.system.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.system.pojo.LoginLog;
import com.maomipuzi.system.service.LoginLogService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-16 15:49
 **/
@Api(value = "登录日志控制")
@RestController
@RequestMapping("/loginLog")
@CrossOrigin
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    /***
     * LoginLog分页条件搜索实现
     * @param loginLog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "LoginLog条件分页查询",notes = "分页条件查询LoginLog方法详情",tags = {"LoginLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "LoginLog对象",value = "传入JSON数据",required = false) LoginLog loginLog, @PathVariable  int page, @PathVariable  int size){
        //调用LoginLogService实现分页条件查询LoginLog
        PageInfo<LoginLog> pageInfo = loginLogService.findPage(loginLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * LoginLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "LoginLog分页查询",notes = "分页查询LoginLog方法详情",tags = {"LoginLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用LoginLogService实现分页查询LoginLog
        PageInfo<LoginLog> pageInfo = loginLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param loginLog
     * @return
     */
    @ApiOperation(value = "LoginLog条件查询",notes = "条件查询LoginLog方法详情",tags = {"LoginLogController"})
    @PostMapping(value = "/search" )
    public Result<List<LoginLog>> findList(@RequestBody(required = false) @ApiParam(name = "LoginLog对象",value = "传入JSON数据",required = false) LoginLog loginLog){
        //调用LoginLogService实现条件查询LoginLog
        List<LoginLog> list = loginLogService.findList(loginLog);
        return new Result<List<LoginLog>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "LoginLog根据ID删除",notes = "根据ID删除LoginLog方法详情",tags = {"LoginLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用LoginLogService实现根据主键删除
        loginLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改LoginLog数据
     * @param loginLog
     * @param id
     * @return
     */
    @ApiOperation(value = "LoginLog根据ID修改",notes = "根据ID修改LoginLog方法详情",tags = {"LoginLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "LoginLog对象",value = "传入JSON数据",required = false) LoginLog loginLog,@PathVariable Integer id){
        //设置主键值
        loginLog.setId(id);
        //调用LoginLogService实现修改LoginLog
        loginLogService.update(loginLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增LoginLog数据
     * @param loginLog
     * @return
     */
    @ApiOperation(value = "LoginLog添加",notes = "添加LoginLog方法详情",tags = {"LoginLogController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "LoginLog对象",value = "传入JSON数据",required = true) LoginLog loginLog){
        //调用LoginLogService实现添加LoginLog
        loginLogService.add(loginLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询LoginLog数据
     * @param id
     * @return
     */
    @ApiOperation(value = "LoginLog根据ID查询",notes = "根据ID查询LoginLog方法详情",tags = {"LoginLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<LoginLog> findById(@PathVariable Integer id){
        //调用LoginLogService实现根据主键查询LoginLog
        LoginLog loginLog = loginLogService.findById(id);
        return new Result<LoginLog>(true,StatusCode.OK,"查询成功",loginLog);
    }

    /***
     * 查询LoginLog全部数据
     * @return
     */
    @ApiOperation(value = "查询所有LoginLog",notes = "查询所LoginLog有方法详情",tags = {"LoginLogController"})
    @GetMapping
    public Result<List<LoginLog>> findAll(){
        //调用LoginLogService实现查询所有LoginLog
        List<LoginLog> list = loginLogService.findAll();
        return new Result<List<LoginLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}