package com.emergencyfood.PaimonTravelReservation.config;

import com.emergencyfood.PaimonTravelReservation.Interceptor.JwtIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtIntercepter())
        		// 拦截所有请求

                .addPathPatterns("/**")
                //不需要的拦截请求
                .excludePathPatterns("/PaimonTravelReservation/login")
                .excludePathPatterns("/doc.html") //不需要拦截的地
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/favicon.ico")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns("/PaimonTravelReservation/identifycode")
                .excludePathPatterns("/PaimonTravelReservation/identifycodeSign")

        ;
    }


	// 跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOriginPatterns("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600);
    }


}

