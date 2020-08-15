package com.tiger.consumption.manager.config;

import com.tiger.consumption.manager.interceptor.ErrorPageInterceptor;
import com.tiger.consumption.manager.interceptor.LoginHandleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/25 18:42
 * @Description:
 * @Version: 1.0
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/")
                .excludePathPatterns("/**/**/*.html")
                .excludePathPatterns("/**/**/*.js")
                .excludePathPatterns("/**/**/*.css");
      // registry.addInterceptor(new ErrorPageInterceptor());
    }
}
