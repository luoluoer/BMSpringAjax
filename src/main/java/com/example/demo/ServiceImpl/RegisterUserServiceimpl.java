package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.RegisterUserMapper;
import com.example.demo.Model.UserInfo;
import com.example.demo.Service.RegisterUserService;
@Service
public class RegisterUserServiceimpl implements RegisterUserService{
	@Autowired
	RegisterUserMapper ru;
	
	HashMap<String, Object> hm = new HashMap<>();
	@Override
	
	public boolean confirmpassword(String password, String confirmpassword) {
		// TODO Auto-generated method stub
		if (password.equals(confirmpassword)) {
			return true;
		}
		return false;
	}

	@Override
	public List<UserInfo> selectuserinfobyusername(String username) {
		// TODO Auto-generated method stub
		
		
		return ru.getUserInfoByUsername(username);
	}

	@Override
	public void insertuserinfo(String username, String password) {
		// TODO Auto-generated method stub
		ru.insertuserinfo(username, password);
		
	}

	@Override
	public HashMap<String, Object> registeruser(String username, String password, String confirmpassword) {
		// TODO Auto-generated method stub
		System.out.println("进入到registeruser方法");
		boolean confirm = confirmpassword(password, confirmpassword);
		if (!confirm) {
			hm.put("code", "-200");
			hm.put("message", "两次输入的密码不一致");
			return hm;
		}
		List<UserInfo> us = selectuserinfobyusername(username);
		if (us.size()>0) {
			hm.put("code", "-200");
			hm.put("message", "已经存在此用户，请直接登录");
			System.out.println("RegisterUserServiceImpl中的代码位置1");
			return hm;
		}else {
			insertuserinfo(username, password);
			hm.put("code", 200);
			
			hm.put("message", "注册成功，请进行登录");
			System.out.println("RegisterUserServiceImpl中的代码位置2");
		
		}
		return hm;
		
	}
}
	
