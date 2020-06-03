package com.maomipuzi.comment.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.comment.dao.CommentMapper;
import com.maomipuzi.comment.pojo.Comment;
import com.maomipuzi.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-04 01:03
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 条件+分页查询
     * @param comment 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Comment> findPage(Comment comment, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(comment);
        //执行搜索
        return new PageInfo<Comment>(commentMapper.selectByExample(example));
    }

    /**
     * SkuGoods分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Comment> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Comment>(commentMapper.selectAll());
    }

    /**
     * 条件查询
     * @param comment
     * @return
     */
    @Override
    public List<Comment> findList(Comment comment){
        //构建查询条件
        Example example = createExample(comment);
        //根据构建的条件查询数据
        return commentMapper.selectByExample(example);
    }


    /**
     * 构建查询对象
     * @param comment
     * @return
     */
    public Example createExample(Comment comment){
        Example example=new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        if(comment!=null){
            // 评论ID
            if(!StringUtils.isEmpty(comment.getId())){
                criteria.andEqualTo("id",comment.getId());
            }
            // 会员Id
            if(!StringUtils.isEmpty(comment.getUserId())){
                criteria.andEqualTo("userId","%"+comment.getUserId()+"%");
            }
            // 商品Id
            if(!StringUtils.isEmpty(comment.getSkuId())){
                criteria.andEqualTo("skuId","%"+comment.getSkuId()+"%");
            }
            // 商品编号
            if(!StringUtils.isEmpty(comment.getGoodsNo())){
                criteria.andEqualTo("goodsNo","%"+comment.getGoodsNo()+"%");
            }
            // 评论内容
            if(!StringUtils.isEmpty(comment.getContent())){
                criteria.andEqualTo("content","%"+comment.getContent()+"%");
            }
            // 评论时间
            if(!StringUtils.isEmpty(comment.getCommentTime())){
                criteria.andEqualTo("commentTime","%"+comment.getCommentTime()+"%");
            }
            // 评论类型 0-好评 1-差评 2-物流快 3-服务态度好
            if(!StringUtils.isEmpty(comment.getCommentType())){
                criteria.andEqualTo("commentType",comment.getCommentType());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        commentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param comment
     */
    @Override
    public void update(Comment comment){
        commentMapper.updateByPrimaryKey(comment);
    }

    /**
     * 增加
     * @param comment
     */
    @Override
    public void add(Comment comment){
        commentMapper.insert(comment);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Comment findById(Integer id){
        return  commentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询全部数据
     * @return
     */
    @Override
    public List<Comment> findAll() {
        return commentMapper.selectAll();
    }

    /**
     * 构建查询对象
     * @param comment
     * @return
     */
    public Example findByExample(Comment comment){
        Example example=new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        if(comment!=null){
            // 商品Id
            if(!StringUtils.isEmpty(comment.getSkuId())){
                criteria.andEqualTo("skuId",comment.getSkuId());
            }
        }
        return example;
    }

    @Override
    public List<Comment> findBySkuId(Integer skuId) {
        Comment comment = new Comment();
        comment.setSkuId(skuId);
        //构建查询条件
        Example example = findByExample(comment);
        //根据构建的条件查询数据
        return commentMapper.selectByExample(example);
    }
}
