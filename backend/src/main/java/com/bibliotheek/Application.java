package com.bibliotheek;

import com.bibliotheek.config.ExternalPropertyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * In order to deploy the application in an application server like Jboss,
 * the Application class extends {@link SpringBootServletInitializer}
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    // This static block loads external properties from the path configured in jboss
    static {
        ExternalPropertyConfig.loadExternalProperties("config_path_bibliotheek");
    }

    /*
     * This method is overridden to configure for deploying the application
     * in a separate application server.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
