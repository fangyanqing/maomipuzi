package com.maomipuzi.comment.service;

import com.maomipuzi.comment.pojo.Comment;
import org.apache.poi.ss.formula.functions.T;
import service.BasicService;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-04 01:02
 **/
public interface CommentService extends BasicService<Comment> {

    /**
     * 根据商品id查询
     * @return
     */
    List<Comment>  findBySkuId(Integer skuId);

    /**
     * 根据userId查询
     * @return
     */
    List<Comment>  findByUserId(Integer userId);
}
