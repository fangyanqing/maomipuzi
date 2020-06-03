package com.maomipuzi.comment.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-04 00:45
 **/
@ApiModel(description = "评论表",value = "Comment")
@Table(name="comment")
public class Comment implements Serializable {

    @ApiModelProperty(value = "评论ID", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "会员ID", required = false)
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "商品编号", required = false)
    @Column(name = "goods_no")
    private String goodsNo;

    @ApiModelProperty(value = "评论内容", required = false)
    @Column(name = "content")
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "评论时间", required = false)
    @Column(name = "comment_time")
    private Date commentTime;

    @ApiModelProperty(value = "评论类型 0-好评 1-差评 2-物流快 3-服务态度好", required = false)
    @Column(name = "comment_type")
    private String commentType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }
}
