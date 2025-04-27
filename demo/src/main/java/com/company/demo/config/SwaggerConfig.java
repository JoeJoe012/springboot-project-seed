package com.company.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    /**
     * 配置swagger基本信息
     */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Swagger 学习")
                        .description("Swagger 简单入门")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("百度网址")
                        .url("https://www.baidu.com/"));
    }
}
