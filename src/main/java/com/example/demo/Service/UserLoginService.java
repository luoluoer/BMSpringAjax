package com.example.demo.Service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.Model.UserInfo;

public interface UserLoginService {
	public List<UserInfo> getUserInfoByUsernameandPassword(String username ,String password); 
	//public void insertuserinfo(String username,String password) throws Exception;
	public List<UserInfo> getUserInfoByUsername(String username) ;
	public  HashMap<String, Object> validateAccount(String username,String password,HttpServletRequest req,HttpSession session);
}
