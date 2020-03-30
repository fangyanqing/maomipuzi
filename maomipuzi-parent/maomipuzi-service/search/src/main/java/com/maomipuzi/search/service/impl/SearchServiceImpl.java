package com.maomipuzi.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.maomipuzi.goods.feign.SkuGoodsFeign;
import com.maomipuzi.goods.pojo.SkuGoods;
import com.maomipuzi.search.dao.SearchMapper;
import com.maomipuzi.search.pojo.SkuGoodsInfo;
import com.maomipuzi.search.service.SearchService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-25 19:57
 **/
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SkuGoodsFeign skuGoodsFeign;

    @Autowired
    private SearchMapper searchMapper;

    /**
     * 导入索引库
     */
    @Override
    public void importData() {
        //feign调用，查询List<SkuGoods>
        Result<List<SkuGoods>> skuGoodsResult = skuGoodsFeign.findAll();
        //将List<SkuGoods>转成List<SkuGoodsInfo>
        List<SkuGoodsInfo> skuGoodsInfoList = JSON.parseArray(JSON.toJSONString(skuGoodsResult.getData()),SkuGoodsInfo.class);
        //调用Dao实现数据批量导入
        searchMapper.saveAll(skuGoodsInfoList);

//        //查询sku集合
//        List<SkuGoods> skuList = skuGoodsFeign.findAll();
//        if (skuList == null || skuList.size()<=0){
//            throw new RuntimeException("当前没有数据被查询到,无法导入索引库");
//        }
//
//        //skulist转换为json
//        String jsonSkuList = JSON.toJSONString(skuList);
//        //将json转换为skuinfo
//        List<SkuGoodsInfo> skuInfoList = JSON.parseArray(jsonSkuList, SkuGoodsInfo.class);
//
//        for (SkuGoodsInfo skuInfo : skuInfoList) {
//            //将规格信息转换为map
//            Map specMap = JSON.parseObject(skuInfo.getSpec(), Map.class);
//            skuInfo.setSpecMap(specMap);
//        }
//
//        //导入索引库
//        searchMapper.saveAll(skuInfoList);
    }
}
