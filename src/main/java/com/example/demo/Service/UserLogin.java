package com.example.demo.Service;

import java.util.HashMap;
import java.util.List;

import com.example.demo.Model.UserInfo;

public interface UserLogin {
	public List<UserInfo> getUserInfoByUsernameandPassword(String username ,String password) throws Exception;
	public void insertuserinfo(String username,String password) throws Exception;
	public List<UserInfo> getUserInfoByUsername(String username) throws Exception;
	public  HashMap<String, Object> validateAccount(String username,String password);
}
