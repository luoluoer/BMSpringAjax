package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.RegisterUserMapper;
import com.example.demo.Model.UserInfo;
import com.example.demo.Service.UserLoginService;
@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	RegisterUserMapper ru ;
	List<UserInfo> userinfo = new ArrayList<>();
	HashMap<String, Object>  hm = new HashMap<>(); 
	@Override
	public List<UserInfo> getUserInfoByUsername(String username)  {
		
		// TODO Auto-generated method stub

		return ru.getUserInfoByUsername(username);
	}

	@Override
	public List<UserInfo> getUserInfoByUsernameandPassword(String username,String password)  {
		// TODO Auto-generated method stub

		return ru.getUserInfoByUsernameandPassword(username, password);
	}

//	@Override
//	public void insertuserinfo(String username, String password) throws Exception {
//		// TODO Auto-generated method stub		
//		ru.insertuserinfo(username, password);
//	}
	
	@Override
	public HashMap<String, Object> validateAccount(String username ,String password,HttpServletRequest req,HttpSession session) {	
		//判断用户名是否存在
		userinfo = getUserInfoByUsername(username);
		if (userinfo.size()==0) {
			hm.put("code", -200);
			hm.put("message", "用户名不存在，请进行注册");
			return hm;
		}				
		//判断用户名和密码是否匹配
		userinfo = getUserInfoByUsernameandPassword(username, password);
		System.out.println("这里是根据用户名和密码查询出的userinfo"+userinfo);
		if (userinfo.size()==0) {
			hm.put("code", -200);
			hm.put("message", "用户名和密码不匹配，请确认");
			return hm;
		}else {
			System.out.println("开始写入session");
			session = req.getSession();
			session.setAttribute("userinfo", true);
			System.out.println("结束写入session");
			hm.put("code", 200);
			hm.put("message", "登录成功");
			hm.put("userinfo",userinfo);
			
		return hm;
		}
	}
	

}
