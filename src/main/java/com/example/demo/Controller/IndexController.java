package com.example.demo.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String indexcontroller (HttpServletRequest req,HttpServletResponse res ) {
		System.out.println("进入了首页的配置页面");
//		Cookie[] cookies = req.getCookies();
//		if(cookies != null) {
//			for (Cookie cookie :cookies) {
//				if(cookie.getName().equals("token")) {
//					String token = cookie.getValue();
//					
//				}
//			}
//		}
//		
		
		HttpSession session = req.getSession();
		System.out.println("登录页session"+session);
		System.out.println("这里是首页输出的session"+session.getAttribute("userinfo"));
		
		return "/html/index.html";
	}
}
