package com.maomipuzi.payment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 15:25
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//调用下面的apiInfo()方法
                .select()
                //controller所在的路径
                .apis(RequestHandlerSelectors.basePackage("com.maomipuzi.payment.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("支付管理")
                .description("关于支付的所有信息")
                .termsOfServiceUrl("")
                .contact("fangyanqing")
                .version("0.0.1")
                .build();
    }
}

