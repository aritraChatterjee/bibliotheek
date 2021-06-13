package com.bibliotheek.config;

import com.bibliotheek.security.filter.AasFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<AasFilter> loggingFilter() {
        FilterRegistrationBean<AasFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AasFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
