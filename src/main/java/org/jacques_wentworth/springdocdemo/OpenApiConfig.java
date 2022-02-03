package org.jacques_wentworth.springdocdemo;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${info.name}")
    private String appName;

    @Value("${info.version}")
    private String version;

    @Bean
    public OpenAPI customOpenAPI() {
        /*More detail can be added here. See OpenAPI class definition*/
        return new OpenAPI()
                .info(
                        new Info()
                                .title(appName + " API")
                                .version(version)
                                .license(new License().name("Apache 2.0"))
                                .description("SpringDoc Demo application. Demonstrates the use of the SpringDoc library.")
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .url("https://example.com")
                                .description("External Document")
                );
    }
}