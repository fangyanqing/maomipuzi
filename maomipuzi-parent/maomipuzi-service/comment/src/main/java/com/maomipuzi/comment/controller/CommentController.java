package com.maomipuzi.comment.controller;

import com.github.pagehelper.PageInfo;
import com.maomipuzi.comment.pojo.Comment;
import com.maomipuzi.comment.service.CommentService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-04 00:56
 **/
@Api(value = "评论管理")
@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    /***
     * 分页条件搜索实现
     * @param comment
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "条件分页查询",notes = "分页条件查询方法详情",tags = {"CommentController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", defaultValue = "1", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", defaultValue = "10", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Comment对象",value = "传入JSON数据",required = false) Comment comment, @PathVariable  int page, @PathVariable  int size){
        //调用CommentService实现分页条件查询
        PageInfo<Comment> pageInfo = commentService.findPage(comment, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "分页查询",notes = "分页查询方法详情",tags = {"CommentController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", defaultValue = "1",  required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", defaultValue = "10",  required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CommentService实现分页查询
        PageInfo<Comment> pageInfo = commentService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索数据
     * @param comment
     * @return
     */
    @ApiOperation(value = "条件查询",notes = "条件查询方法详情",tags = {"CommentController"})
    @PostMapping(value = "/search" )
    public Result<List<Comment>> findList(@RequestBody(required = false) @ApiParam(name = "Comment对象",value = "传入JSON数据",required = false) Comment comment){
        //调用CommentService实现条件查询
        List<Comment> list = commentService.findList(comment);
        return new Result<List<Comment>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID删除",notes = "根据ID删除方法详情",tags = {"CommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/deleted/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用CommentService实现根据主键删除
        commentService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改数据
     * @param comment
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID修改",notes = "根据ID修改方法详情",tags = {"CommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/update/{id}")
    public Result update(@RequestBody @ApiParam(name = "Comment对象",value = "传入JSON数据",required = false) Comment comment,@PathVariable Integer id){
        //设置主键值
        comment.setId(id);
        //调用CommentService实现修改
        commentService.update(comment);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增数据
     * @param comment
     * @return
     */
    @ApiOperation(value = "添加",notes = "添加方法详情",tags = {"CommentController"})
    @PostMapping("/add")
    public Result add(@RequestBody  @ApiParam(name = "Comment对象",value = "传入JSON数据",required = true) Comment comment){
        //调用CommentService实现添加
        commentService.add(comment);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID查询",notes = "根据ID查询方法详情",tags = {"CommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/findById/{id}")
    public Result<Comment> findById(@PathVariable Integer id){
        //调用CommentService实现根据主键查询
        Comment comment = commentService.findById(id);
        return new Result<Comment>(true, StatusCode.OK,"查询成功",comment);
    }

    /***
     * 查询全部数据
     * @return
     */
    @ApiOperation(value = "查询所有",notes = "查询所有方法详情",tags = {"CommentController"})
    @GetMapping("/findAll")
    public Result<List<Comment>> findAll(){
        //调用CommentService实现查询所有
        List<Comment> list = commentService.findAll();
        return new Result<List<Comment>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
