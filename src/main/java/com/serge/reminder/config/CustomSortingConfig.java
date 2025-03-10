package com.serge.reminder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.data.web.config.SortHandlerMethodArgumentResolverCustomizer;

@Configuration
public class CustomSortingConfig {

    @Bean
    public SortHandlerMethodArgumentResolverCustomizer customizedSort() {
        return sortResolver -> {
            sortResolver.setSortParameter("by");
        };
    }
}
