package com.example.demo.Service;

import java.util.HashMap;

import com.example.demo.Config.ResultConfig;
import com.example.demo.Model.UserInfo;

public interface UserLoginDealService {
	public HashMap<String ,Object>  addUserInfo(UserInfo userinfo);
	
	public void updateUserInfo(UserInfo userinfo);
	
	public void deleteUserInfo(long id);
	
	public ResultConfig<?> selectUserInfo(UserInfo userinfo);
}	
