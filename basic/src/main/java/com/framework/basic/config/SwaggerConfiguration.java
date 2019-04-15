package com.framework.basic.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 18:18
 * @Description: swagger 配置,在使用时候,需要在主程序 加 @EnableSwagger2 和  @ComponentScan(basePackages = "com.framework")
 */
@Configuration
public class SwaggerConfiguration {

    private static final String BASE_PACKAGE = "com.framework";
    private static final String VERSION = "1.0";

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API 接口文档")
                .description("")
                .license("")
                .version(VERSION)
                .build();
    }
}
