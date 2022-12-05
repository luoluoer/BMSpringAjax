package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.LoginInterceptor;
@Configuration
public class MyConfig implements WebMvcConfigurer  {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/**") // 拦截所有
				.excludePathPatterns("/","/userlogin**","/webjars**"); //排除该登录地址或添加其他
		
				
		
	}
}
