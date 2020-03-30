package com.maomipuzi.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.maomipuzi.goods.feign.SkuGoodsFeign;
import com.maomipuzi.goods.pojo.SkuGoods;
import com.maomipuzi.search.dao.SearchMapper;
import com.maomipuzi.search.pojo.SkuGoodsInfo;
import com.maomipuzi.search.service.SearchService;
import entity.Result;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 导入索引库
     */
    @Override
    public void importData() {
        //feign调用，查询List<SkuGoods>
        Result<List<SkuGoods>> skuGoodsResult = skuGoodsFeign.findAll();
        if (skuGoodsResult == null){
            throw new RuntimeException("当前没有数据被查询到,无法导入索引库");
        }
        //将List<SkuGoods>转成List<SkuGoodsInfo>
        List<SkuGoodsInfo> skuGoodsInfoList = JSON.parseArray(JSON.toJSONString(skuGoodsResult.getData()),SkuGoodsInfo.class);
        //调用Dao实现数据批量导入
        searchMapper.saveAll(skuGoodsInfoList);

    }

    /**
     * 按照查询条件进行数据查询
     * @param searchMap
     * @return
     */
    @Override
    public Map search(Map<String, String> searchMap) {
        Map<String,Object> resultMap = new HashMap<>();
        if(searchMap !=null){
            //1、查询条件构造
            NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

            //2、搜索列表

            //3、按照分类搜索查询
            if(StringUtils.isNotEmpty(searchMap.get("type"))){
                boolQueryBuilder.filter(QueryBuilders.termQuery("typeName",searchMap.get("type")));
            }

            //4、按照规格数据查询
            for(String key : searchMap.keySet()){
                if(key.startsWith("spec_")){
                    String value = searchMap.get(key).replace("%2B","+");
                    boolQueryBuilder.filter(QueryBuilders.termQuery(("specMap"+key.substring(5)+".keyword"),value));
                }
            }

            //5、按照关键字查询
            if(StringUtils.isNotEmpty(searchMap.get("keywords"))){
                boolQueryBuilder.must(QueryBuilders.matchQuery("goodsName",searchMap.get("keywords")));
            }

            //6、按照价格进行区间过滤查询
            if(StringUtils.isNotEmpty(searchMap.get("price"))){
                String[] prices = searchMap.get("price").split("-");
                if(prices.length == 2){
                    boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").lte(prices[1]));
                }
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(prices[0]));
            }
            nativeSearchQueryBuilder.withQuery(boolQueryBuilder);

            //按照规格进行聚合查询
            String skuSpec="skuSpec";
            nativeSearchQueryBuilder.addAggregation(AggregationBuilders.terms(skuSpec).field("spec.keyword"));

            //7、分页查询
            String pageNum = searchMap.get("pageNum");//当前页
            String pageSize = searchMap.get("pageSize");//每页显示的数量
            //设置分页为空时的默认值
            if(StringUtils.isEmpty(pageNum)){
                pageNum="1";
            }
            if(StringUtils.isEmpty(pageSize)){
                pageSize="20";
            }
            //按照相关字段进行排序查询
            if(StringUtils.isNotEmpty(searchMap.get("sortField")) && StringUtils.isNotEmpty(searchMap.get(("sortRule")))){
                if("ASC".equals(searchMap.get("sortRule"))){
                    nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort((searchMap.get("sortField"))).order(SortOrder.ASC));
                }else{
                    nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort((searchMap.get("sortField"))).order(SortOrder.DESC));
                }
            }

            //8、设置高亮域以及高亮样式
            HighlightBuilder.Field field = new HighlightBuilder.Field("goodsName")//高亮域
                    .preTags("<span style=color:red'>")//高亮样式前缀
                    .postTags("</span>");//后缀
            nativeSearchQueryBuilder.withHighlightFields(field);

            //9、开始查询
            AggregatedPage<SkuGoodsInfo> resultInfo = elasticsearchTemplate.queryForPage(nativeSearchQueryBuilder.build(), SkuGoodsInfo.class, new SearchResultMapper() {
                @Override
                public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                    //查询结果
                    List<T> list = new ArrayList<>();

                    //获取查询命中结果数据
                    SearchHits searchHits = searchResponse.getHits();
                    if(searchHits != null){
                        for(SearchHit hit : searchHits){
                            SkuGoodsInfo skuGoodsInfo = JSON.parseObject(hit.getSourceAsString(),SkuGoodsInfo.class);
                            Map<String, HighlightField> highlightFieldMap = hit.getHighlightFields();
                            if(highlightFieldMap != null && highlightFieldMap.size()>0){
                                //替换上数据
                                skuGoodsInfo.setGoodsName(highlightFieldMap.get("goodsName").getFragments()[0].toString());
                            }
                            list.add((T) skuGoodsInfo);
                        }
                    }
                    return new AggregatedPageImpl<T>(list,pageable,searchHits.getTotalHits(),searchResponse.getAggregations());
                }
            });

            //10、返回结果
            //总记录数
            resultMap.put("total",resultInfo.getTotalElements());
            //总页数
            resultMap.put("totalPages",resultInfo.getTotalPages());
            //数据集合
            resultMap.put("rows",resultInfo.getContent());
            //封装规格参数分组结果
            StringTerms specTerms = (StringTerms) resultInfo.getAggregation(skuSpec);
            List<String> specList = specTerms.getBuckets().stream().map(bucket -> bucket.getKeyAsString()).collect(Collectors.toList());
            resultMap.put("specList",this.formartSpec(specList));
            //当前页
            resultMap.put("pageNum",pageNum);
            return resultMap;
        }

        return null;
    }

    //规格转换的方法
    public Map<String,Set<String>> formartSpec(List<String> specList){
        Map<String,Set<String>> resultMap = new HashMap<>();
        if (specList!=null && specList.size()>0){
            for (String specJsonString : specList) {
                //将json数据转换为map
                Map<String,String> specMap = JSON.parseObject(specJsonString, Map.class);
                for (String specKey : specMap.keySet()) {
                    Set<String> specSet = resultMap.get(specKey);
                    if (specSet == null){
                        specSet = new HashSet<String>();
                    }
                    //将规格的值放入set中
                    specSet.add(specMap.get(specKey));
                    //将set放入map中
                    resultMap.put(specKey,specSet);
                }
            }
        }
        return resultMap;
    }
}
