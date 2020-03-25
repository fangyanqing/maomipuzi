package com.maomipuzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.tools.jar.resources.jar;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@MapperScan(basePackages = {"com.maomipuzi.goods.dao"})  //Dao接口包扫描->@MapperScan:tk下的包
public class GoodsApplicatin {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplicatin.class,args);
    }
}
