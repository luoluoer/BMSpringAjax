package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;

import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapper.AjaxTestMapper;
import com.example.demo.Mapper.RegisterUserMapper;
import com.example.demo.Model.MaterielGoodsInfo;
import com.example.demo.Model.UserInfo;

@RestController
public class RegisterUserController {
	@Autowired
	RegisterUserMapper ru;
	@PostMapping("/registeruser")
	public HashMap<String,Object> registeruser (HttpServletRequest req) {
		System.out.println("page registerusercontroller");
		System.out.println(req.getMethod());
		HashMap<String, Object> registermessage = new HashMap<>();
		String username = req.getParameter("regusername");
		String password = req.getParameter("regpassword");
		String confirmpassword = req.getParameter("confirmpassword");
		if (!(password.equals(confirmpassword))) {
			registermessage.put("code", 200);
			registermessage.put("message", "后台报错两次密码不一致");
			
		}
		List<UserInfo> us = ru.getUserInfoByUsername(username);
		if (us.size()>0) {
			registermessage.put("code", 200);
			registermessage.put("message", "已经存在此用户，请直接登录");
		}else {
			ru.insertuserinfo(username, password);
			registermessage.put("code", 200);
			registermessage.put("message", "注册成功，请进行登录");
		
		}
		
		


		
		return registermessage;
	}
}
