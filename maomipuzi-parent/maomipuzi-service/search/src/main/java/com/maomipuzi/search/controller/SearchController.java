package com.maomipuzi.search.controller;

import com.maomipuzi.search.service.SearchService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-25 20:17
 **/
@RestController
@RequestMapping(value = "/search")
@CrossOrigin
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/importDate")
    public Result importData(){
        searchService.importData();
        return new Result(true, StatusCode.OK,"数据导入成功");
    }
}
