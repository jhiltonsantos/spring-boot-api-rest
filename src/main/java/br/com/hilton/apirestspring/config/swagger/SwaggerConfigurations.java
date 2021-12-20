package br.com.hilton.apirestspring.config.swagger;

import br.com.hilton.apirestspring.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

    @Bean
    public Docket ApiRestSpringSwagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.hilton.apirestspring"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(User.class);
    }
}
