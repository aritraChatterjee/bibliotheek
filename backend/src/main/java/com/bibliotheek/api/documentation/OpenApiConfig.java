package com.bibliotheek.api.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    public static final String API_VERSION = "v1";
    public static final String API_ROOT = API_VERSION;

    @Bean
    public OpenAPI bibliotheekOpenAPI(@Value("${application.environment}") String appDesciption,
                                      @Value("${application.version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Bibliotheek API")
                        .version(appVersion)
                        .description(appDesciption));
    }
}
