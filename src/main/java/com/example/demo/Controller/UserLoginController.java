package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.example.demo.Mapper.RegisterUserMapper;
import com.example.demo.Model.UserInfo;

import com.example.demo.Service.UserLoginService;
@RestController
public class UserLoginController {
	@Autowired
	RegisterUserMapper ru ;
	@Autowired
	UserLoginService userlogin;
	List<UserInfo> userinfo = new ArrayList<>();
	HashMap<String, Object> hm = new HashMap<>();
	@RequestMapping("/userlogin")
	public HashMap<String, Object> uerlogin(HttpServletRequest req,HttpSession session) {
		String username = req.getParameter("username");
		
		String password = req.getParameter("password");
		hm  = userlogin.validateAccount(username, password,req,session);
//		if(validateAccount(username,password)) {
//			System.out.println("这里是判断登录返回的hm:"+hm);
//			System.out.println((Integer)hm.get("code")==200);
//			if ((Integer)hm.get("code")==200) {
//				System.out.println("登录完成，写入session");
//				session = req.getSession();
//				
//				session.setAttribute("userinfo", true);
//				System.out.println("这里是查询公共变量userinfo"+userinfo);
//				
//				System.out.println("登录方法中写入的session值："+session.getAttribute("userinfo"));
//				
//			}
//			
//		}
		//System.out.println(hm.get("code"));
	
		return hm;
}
//	private boolean validateAccount(String username ,String password) {
//		
//		//判断用户名是否存在
//		userinfo = ru.getUserInfoByUsername(username);
//		if (userinfo.size()==0) {
//			hm.put("code", -200);
//			hm.put("message", "用户名不存在，请进行注册");
//			return false;
//		}
//		
//		
//		//判断用户名和密码是否匹配
//		userinfo = ru.getUserInfoByUsernameandPassword(username, password);
//		System.out.println("这里是根据用户名和密码查询出的userinfo"+userinfo);
//		if (userinfo.size()==0) {
//			hm.put("code", -200);
//			hm.put("message", "用户名和密码不匹配，请确认");
//			return false;
//		}else {
//			System.out.println("开始写入session");
//
//			hm.put("code", 200);
//			hm.put("message", "登录成功");
//			hm.put("userinfo",userinfo);
//		
//		return true;
//		}
//	}
}
