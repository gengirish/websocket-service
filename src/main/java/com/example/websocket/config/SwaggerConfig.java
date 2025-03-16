package com.example.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuration class for Swagger API documentation.
 * This class configures the Swagger Docket bean to generate API documentation for the controllers in the application.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Creates a Docket bean to configure Swagger 2 for the application.
     * The Docket bean is used to specify the base package for the controllers and the paths to be included in the documentation.
     *
     * @return a Docket object configured for Swagger 2.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.websocket.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}