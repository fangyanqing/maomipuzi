package com.maomipuzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-25 18:07
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.maomipuzi.goods.feign")
@EnableElasticsearchRepositories(basePackages = "com.maomipuzi.search.dao")
public class SearchApplication {
    public static void main(String[] args) {
        //防止entty冲突后client时还会报异常
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(SearchApplication.class,args);
    }
}
