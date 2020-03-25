package com.maomipuzi.system.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.system.pojo.Admin;
import com.maomipuzi.system.service.AdminService;
import com.maomipuzi.system.util.JwtUtil;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/
@Api(value = "系统管理控制")
@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "查询所有Admin",notes = "查询所Admin有方法详情",tags = {"AdminController"})
    @GetMapping("/find")
    public Result findAll(){
        List<Admin> admins =  adminService.findAll();
        //响应结果封装
        return new Result(true, StatusCode.OK,"查询所有成功！",admins);
    }

    @ApiOperation(value = "Admin根据ID查询",notes = "根据ID查询Admin方法详情",tags = {"AdminController"})
    @GetMapping(value = "/{adminId}")
    public Result findById(@PathVariable(value = "adminId") Integer adminId){
        Admin admin = adminService.findById(adminId);
        return new Result(true, StatusCode.OK,"根据ID查询成功！",admin);
    }

    @ApiOperation(value = "Admin添加",notes = "添加Admin方法详情",tags = {"AdminController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "Admin对象",value = "传入JSON数据",required = true) Admin admin){
        adminService.add(admin);
        return new Result(true, StatusCode.OK,"添加成功！");
    }

    @ApiOperation(value = "Admin根据ID修改",notes = "根据ID修改Admin方法详情",tags = {"AdminController"})
    @PutMapping(value = "/{adminId}")
    public Result update(@RequestBody @ApiParam(name = "Admin对象",value = "传入JSON数据",required = false) Admin admin,@PathVariable Integer adminId){
        //将id传入
        admin.setAdminId(adminId);
        //调用修改方法
        adminService.update(admin);
        //返回信息
        return new Result(true, StatusCode.OK,"修改成功！");
    }

    @ApiOperation(value = "Admin根据ID删除",notes = "根据ID删除Admin方法详情",tags = {"AdminController"})
    @DeleteMapping(value = "/{adminId}")
    public Result delete(@PathVariable(value = "adminId")Integer adminId){
        adminService.delete(adminId);
        return new Result(true, StatusCode.OK,"删除成功！");
    }

    @ApiOperation(value = "Admin条件查询",notes = "条件查询Admin方法详情",tags = {"AdminController"})
    @PostMapping(value = "/search" )
    public Result<List<Admin>> findList(@RequestBody(required = false) @ApiParam(name = "Admin对象",value = "传入JSON数据",required = false) Admin admin){
        //实现查询
        List<Admin> admins = adminService.findList(admin);
        return new Result(true, StatusCode.OK,"条件搜索查询成功！",admins);
    }

    @ApiOperation(value = "Admin分页查询",notes = "分页查询Admin方法详情",tags = {"AdminController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}")
    public Result findPage(@PathVariable(value = "page")Integer page,
                                           @PathVariable(value = "size")Integer size){
        //调用Service实现分页查询
        PageInfo<Admin> pageInfo = adminService.findPage(page, size);
        return new Result(true, StatusCode.OK,"分页查询成功！",pageInfo);
    }

    @ApiOperation(value = "Admin条件分页查询",notes = "分页条件查询Admin方法详情",tags = {"AdminController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Admin对象",value = "传入JSON数据",required = false) Admin admin, @PathVariable  int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Admin> pageInfo = adminService.findPage(admin, page, size);
        return new Result(true, StatusCode.OK,"多条件分页查询成功",pageInfo);
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        boolean result = adminService.login(admin);
        if (result){
            //密码是正确的
            //生成jwt令牌,返回到客户端
            Map<String,String> info = new HashMap<>();
            info.put("adminName",admin.getAdminName());
            //基于工具类生成jwt令牌
            String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), admin.getAdminName(), null);
            info.put("token",jwt);
            return new Result(true, StatusCode.OK,"登录成功",info);
        }else{
            return new Result(false, StatusCode.ERROR,"登录失败");
        }
    }

}
