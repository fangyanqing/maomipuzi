package com.maomipuzi.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@MapperScan(basePackages = {"com.maomipuzi.comment.dao"})  //Dao接口包扫描->@MapperScan:tk下的包
public class CommentApplicatin {

    public static void main(String[] args) {
        SpringApplication.run(CommentApplicatin.class,args);
    }
}
