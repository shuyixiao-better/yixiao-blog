package com.shuyixiao.system.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName InterceptorConfig.java
 * author 舒一笑
 * version 1.0.0
 * Description 全局接口拦截器
 * createTime 2024年06月13日 22:53:00
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public JwtTokenInterceptor jwtInterceptor(){
        return new JwtTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                // 拦截的路径
                .addPathPatterns("/**")
                // 不拦截的路径
                .excludePathPatterns("/getVerificationCode")
        ;
    }
}
