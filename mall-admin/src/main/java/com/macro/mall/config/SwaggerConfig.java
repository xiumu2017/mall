package com.macro.mall.config;

import com.macro.mall.common.config.BaseSwaggerConfig;
import com.macro.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 *
 * @author macro
 * @date 2018/4/26
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.macro.mall.controller")
                .title("垚修修后台管理")
                .description("垚修修后台相关接口文档")
                .contactName("Paradise")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}