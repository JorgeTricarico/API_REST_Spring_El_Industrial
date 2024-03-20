package com.products.backend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.List;

@Configuration
public class OpenApiConfig {
    private final String name;
    private final String apiVersion;

    public OpenApiConfig(@Value("Products") String name,
                         @Value("1.0.0") String apiVersion){
        this.name = name;
        this.apiVersion = apiVersion;
    }

    @Bean
    public OpenAPI customOpenAPI(){
        final String securitySchemeName  = "Bearer Authentication";
        final String apiTitle = String.format("%s API", StringUtils.capitalize(this.name));

        return new OpenAPI()
                .servers(List.of(new Server().url("/api/v1")))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("Bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title(apiTitle)
                        .version(apiVersion)
                        .description("<strong>Products.</strong>")
                        .contact(new Contact()
                                .url("Próximamente")
                                .email("products@gmail.com.ar")
                                .name("Products")));
    }
}
