package com.maomipuzi.user.service;

import com.maomipuzi.user.pojo.Collect;
import org.apache.poi.ss.formula.functions.T;
import service.BasicService;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-05 20:09
 **/
public interface CollectService extends BasicService<Collect> {
    //查询收藏信息
    List<Collect> findAll(Integer userId);


}
