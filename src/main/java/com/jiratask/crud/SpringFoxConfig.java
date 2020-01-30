package com.jiratask.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiratask"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "UserList API",
                "Sample API for Andersen Internship task",
                "v0.1beta",
                "http://swagger.io/terms",
                new Contact("Igor Povrozniuk", "https://github.com/sofflen", "nixxesgaming@gmail.com"),
                "API Licence",
                "http://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList()
        );


    }
}
