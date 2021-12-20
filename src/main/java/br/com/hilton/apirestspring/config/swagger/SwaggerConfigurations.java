package br.com.hilton.apirestspring.config.swagger;

import br.com.hilton.apirestspring.models.User;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfigurations {
/*
    @Bean
    public GroupedOpenApi

    @Bean
    public Docket ApiRestSpringSwagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.hilton.apirestspring"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(User.class)
                .globalOperationParameters(Arrays.asList(
                        new ParameterBuilder()
                                .name("Authorization")
                                .description("Header token JWT")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build()
                ));
    }*/
}
