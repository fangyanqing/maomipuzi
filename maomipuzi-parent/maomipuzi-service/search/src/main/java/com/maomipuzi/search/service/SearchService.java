package com.maomipuzi.search.service;

import java.util.Map;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-25 19:57
 **/
public interface SearchService {
    /**
     * 导入索引库数据
     */
    void importData();

    /**
     * 按照查询条件进行数据查询
     * @param searchMap
     * @return
     */
    Map search(Map<String,String> searchMap);
}
