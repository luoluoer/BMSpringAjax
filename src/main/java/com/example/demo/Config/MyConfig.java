package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import com.example.demo.interceptor.LoginInterceptor;
@Configuration
public class MyConfig implements WebMvcConfigurer  {
	
	@Bean
	LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor())
				
				.addPathPatterns("/**")
				
				.excludePathPatterns("/")
				//.excludePathPatterns("/webjars**")	
				.excludePathPatterns("/webjars/**")
				//Request URL: http://localhost:8080/webjars/jquery/3.6.1/dist/jquery.min.js
				; //排除该登录地址或添加其他,注意,webjars后面的/不能少,劳资查了两天了,艹
		
				;
				System.out.println(registry);
				WebMvcConfigurer.super.addInterceptors(registry);
		
	}
}
