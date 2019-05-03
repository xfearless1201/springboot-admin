package com.cn.tianxia.admin.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @ClassName SwaggerConfig
 * @Description Swagger配置
 * @author Hardy
 * @Date 2019年5月3日 上午11:24:42
 * @version 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
          //加了ApiOperation注解的类，生成接口文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//            .apis(RequestHandlerSelectors.basePackage("com.cn.tianxia.admin.web"))//controller路径
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("天下集团管理后台接口")
            .description("tx-admin文档")
            .termsOfServiceUrl("localhost:8080/tx-admin")
            .version("4.0.0")
            .build();
    }

}