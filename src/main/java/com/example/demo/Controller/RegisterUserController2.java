package com.example.demo.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserLoginDealService;
import com.example.demo.Model.UserInfo;

@RestController
public class RegisterUserController2 {
	@Autowired
	UserLoginDealService ulds;
	@PostMapping("/registerusertest")
	public HashMap<String,Object> registeruser (
			HttpServletRequest req ,
			@RequestParam(value = "regusername") String regusername,
			@RequestParam(value = "regpassword") String regpassword,
			@RequestParam(value = "confirmpassword") String confirmpassword,
			@RequestParam(value = "realname") String realname
			
			){
		
		
		HashMap<String , Object> registermessage = new HashMap<>();
		UserInfo userinfo = new UserInfo(regusername, confirmpassword, realname);
		
		registermessage  = ulds.addUserInfo(userinfo);
		System.out.println(registermessage);
		
		return registermessage;
	}
	
}
