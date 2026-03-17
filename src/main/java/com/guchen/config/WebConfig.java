package com.guchen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CustomRequestInterceptor requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截，并设置放行路径
        registry.addInterceptor(requestInterceptor).excludePathPatterns("/user/login",
                "/user/regist", "/user/captcha", "/user/yzmcap");
    }

}
