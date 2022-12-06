package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = false;
		try {
			System.out.println(request.getRequestURI());
			System.out.println("拦截方法中输入session"+request.getSession().getAttribute("userinfo"));
			result = (boolean)request.getSession().getAttribute("userinfo");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		if (result) {
			return true; // 放行
		}
		return false; // 拦截
	}
	
}

