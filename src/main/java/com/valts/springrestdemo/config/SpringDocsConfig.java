package com.valts.springrestdemo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocsConfig {

    @Bean
    public OpenAPI restDemoAPI() {
        return new OpenAPI()
                .info(new Info().title("Spring REST Demo")
                        .description("Spring REST Demo app with simple CRUD controls")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://google.com")));

    }
}


