package com.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("default")
                .apiInfo(new ApiInfoBuilder().title("Springboot Security API").version("1.0.0").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.security.controller"))
                .build()
                .globalOperationParameters(globalOperationParameters());
    }

    private List<Parameter> globalOperationParameters() {
        List<Parameter> parameters = new ArrayList<>();
//         parameters.add(new ParameterBuilder().name("Authorization").description("Authorization").required(false).parameterType("header").modelRef(new ModelRef("string")).build());
        return parameters;
    }

}
