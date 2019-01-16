package com.flying.zsbn.core.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class FlyingSystemWebConfigurer extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new com.flying.zsbn.commons.interceptor.springmvc.OperateInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
