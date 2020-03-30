package com.maomipuzi.search.dao;

import com.maomipuzi.search.pojo.SkuGoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-25 20:02
 **/
@Repository
public interface SearchMapper extends ElasticsearchRepository<SkuGoodsInfo,Integer> {
}