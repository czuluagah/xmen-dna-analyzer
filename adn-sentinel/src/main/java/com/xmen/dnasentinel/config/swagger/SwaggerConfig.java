package com.xmen.dnasentinel.config.swagger;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.fasterxml.classmate.TypeResolver;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig  {

    @NonNull
    private final TypeResolver typeResolver;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xmen.dnasentinel"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .alternateTypeRules(
                        newRule(typeResolver.resolve(ResponseEntity.class, WildcardType.class),
                                typeResolver.resolve(WildcardType.class))
                )
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("X-Men DNA Analyzer")
                .description("Search for Mutant DNA ")
                .contact(new Contact(
                        "Carlos Zuluaga",
                        "https://github.com/czuluagah",
                        "")
                )
                .license("")
                .version("")
                .build();
    }
}
