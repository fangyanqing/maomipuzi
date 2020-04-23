package com.maomipuzi.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient //客户端开启Eureka客户端
@MapperScan(basePackages = {"com.maomipuzi.logistics.dao"})  //开启通用Mapper的包扫描
public class LogisticsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsApplication.class,args);
    }
}
