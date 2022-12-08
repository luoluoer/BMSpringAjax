package com.example.demo.Service;

import java.util.HashMap;
import java.util.List;

import com.example.demo.Model.UserInfo;

public interface RegisterUserService {
	public boolean  confirmpassword(String password,String confirmpassword);
	
	public List<UserInfo> selectuserinfobyusername(String username);
	
	public void insertuserinfo(String username,String password);
	
	public HashMap<String, Object> registeruser(String username,String password,String confirmpassword);
}
