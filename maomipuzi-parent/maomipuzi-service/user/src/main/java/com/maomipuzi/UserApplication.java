package com.maomipuzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-05 01:16
 **/
@SpringBootApplication
@EnableEurekaClient //客户端开启Eureka客户端
@MapperScan(basePackages = {"com.maomipuzi.user.dao"})  //开启通用Mapper的包扫描
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

