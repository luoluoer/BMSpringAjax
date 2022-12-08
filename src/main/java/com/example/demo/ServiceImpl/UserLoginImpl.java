package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.RegisterUserMapper;
import com.example.demo.Model.UserInfo;
import com.example.demo.Service.UserLogin;
@Service
public class UserLoginImpl implements UserLogin {
	@Autowired
	RegisterUserMapper ru ;
	List<UserInfo> userinfo = new ArrayList<>();
	HashMap<String, Object>  hm = new HashMap<>(); 
	@Override
	public List<UserInfo> getUserInfoByUsername(String username) throws Exception {
		
		// TODO Auto-generated method stub

		return ru.getUserInfoByUsername(username);
	}

	@Override
	public List<UserInfo> getUserInfoByUsernameandPassword(String username,String password) throws Exception {
		// TODO Auto-generated method stub

		return ru.getUserInfoByUsernameandPassword(username, password);
	}

	@Override
	public void insertuserinfo(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		ru.insertuserinfo(username, password);
	}
	
	@Override
	public HashMap<String, Object> validateAccount(String username ,String password) {
		
		//判断用户名是否存在
		userinfo = ru.getUserInfoByUsername(username);
		if (userinfo.size()==0) {
			hm.put("code", -200);
			hm.put("message", "用户名不存在，请进行注册");
			return hm;
		}
		
		
		//判断用户名和密码是否匹配
		userinfo = ru.getUserInfoByUsernameandPassword(username, password);
		System.out.println("这里是根据用户名和密码查询出的userinfo"+userinfo);
		if (userinfo.size()==0) {
			hm.put("code", -200);
			hm.put("message", "用户名和密码不匹配，请确认");
			return hm;
		}else {
			System.out.println("开始写入session");

			hm.put("code", 200);
			hm.put("message", "登录成功");
			hm.put("userinfo",userinfo);
		
		return hm;
		}
	}
	

}
