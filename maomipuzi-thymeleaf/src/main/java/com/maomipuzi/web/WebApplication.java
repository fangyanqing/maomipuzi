package com.maomipuzi.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-06 11:49
 **/

@SpringBootApplication
@EnableEurekaClient //客户端开启Eureka客户端
@MapperScan(basePackages = {"com.maomipuzi.system.dao"})  //开启通用Mapper的包扫描
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
