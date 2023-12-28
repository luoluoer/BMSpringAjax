package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Config.ResultConfig;
import com.example.demo.Model.UserInfo;
import com.example.demo.ServiceImpl.UserLoginDealServiceImpl;
import com.example.demo.ServiceImpl.UserLoginServiceImpl;

@RestController
@RequestMapping("/userlogin")
public class UserLoginDealController {
	@Autowired
	UserLoginDealServiceImpl ulds;
	@PostMapping("")
	public ResultConfig<?> userlogin(@RequestBody UserInfo userinfo){
		System.out.println("进入到了userlogin的方法中");
		ResultConfig<?> res = ulds.selectUserInfo(userinfo);
		return res;
		
	}
}
