package com.bibliotheek.config;

import com.bibliotheek.api.filter.RequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RequestFilter> loggingFilter() {
        FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestFilter());

        registrationBean.addUrlPatterns("/v1/*");

        return registrationBean;

    }

}
