package com.maomipuzi.search.controller;

import com.maomipuzi.search.pojo.SkuGoodsInfo;
import com.maomipuzi.search.service.SearchService;
import entity.Page;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-25 20:17
 **/
@Api(value = "商品搜索")
@RestController
@RequestMapping(value = "/search")
@CrossOrigin
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "数据导入",tags = {"SearchController"})
    @GetMapping(value = "/importDate")
    public Result importData(){
        searchService.importData();
        return new Result(true, StatusCode.OK,"数据导入成功");
    }

    @ApiOperation(value = "搜索查询",tags = {"SearchController"})
    @GetMapping("/list")
    public String list(@RequestParam Map<String ,String> searchMap, Model model){
        //特殊符号处理
        this.handleSearchMap(searchMap);

        //获取查询结果
        Map resultMap = searchService.search(searchMap);
        model.addAttribute("result",resultMap);
        model.addAttribute("searchMap",searchMap);

        //封装分页数据并返回
       Page<SkuGoodsInfo> page = new Page<>(
                Long.parseLong(String.valueOf(resultMap.get("total"))),
                Integer.parseInt(String.valueOf(resultMap.get("pageNum"))),
                Page.pageSize
        );
       model.addAttribute("page",page);

        //拼装url
        StringBuilder url = new StringBuilder("/search/list");
        if(searchMap != null && searchMap.size()>0){
            url.append("?");
            for (String paramKey : searchMap.keySet()){
                if(!"sortRule".equals(paramKey) && !"sortField".equals(paramKey) && !"pageNum".equals(paramKey)){
                    url.append(paramKey).append("=").append(searchMap.get(paramKey)).append("&");
                }
            }
            String urlString = url.toString();
            urlString = urlString.substring(0,urlString.length()-1);
            model.addAttribute("url",urlString);
        }else{
            model.addAttribute("url",url);
        }

        return "search";
    }

    @ApiOperation(value = "特殊符号处理",tags = {"SearchController"})
    @GetMapping
    @ResponseBody
    public Map search(@RequestParam Map<String,String> searchMap){
        //特殊符号处理
        this.handleSearchMap(searchMap);
        Map searchResult = searchService.search(searchMap);
        return searchResult;
    }

    //特殊符号处理
    private void handleSearchMap(Map<String,String> searchMap){
        Set<Map.Entry<String ,String >> entries = searchMap.entrySet();
        for(Map.Entry<String,String> entry : entries){
            if(entry.getKey().startsWith("spec_")){
                searchMap.put(entry.getKey(),entry.getValue().replace("+","%2B"));
            }
        }
    }
}
