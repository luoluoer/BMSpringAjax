package com.example.demo.ServiceImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.Config.ResultConfig;
import com.example.demo.Mapper.UserLoginMapper;
import com.example.demo.Model.UserInfo;
import com.example.demo.Service.UserLoginDealService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
@Service
public class UserLoginDealServiceImpl implements UserLoginDealService{
	
	HashMap<String,Object> hm  = new HashMap<>();
	@Autowired
	UserLoginMapper um;


	@Override
	public void updateUserInfo(UserInfo userinfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserInfo(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultConfig<?> selectUserInfo(UserInfo userinfo) {
		// TODO Auto-generated method stub
		UserInfo selectuserinfo = um.selectOne(Wrappers.<UserInfo>lambdaQuery()
				.eq(UserInfo::getUsername, userinfo.getUsername())
				.eq(UserInfo::getPassword, userinfo.getPassword()));
		
		
		
		
		
		System.out.println("UserLoginDealControl中输出 userinfo"+userinfo);
		System.out.println("UserLoginDealControl中输出 selectuserinfo"+selectuserinfo);
		if (selectuserinfo==null) {
			return ResultConfig.error("-1", "用户名和密码不匹配");
		}
		return ResultConfig.success(selectuserinfo);
	}

	@Override
	public HashMap<String, Object> addUserInfo(UserInfo userinfo) {
		// TODO Auto-generated method stub
		int insertResult = 0;  
		insertResult = um.insert(userinfo);
		hm.put(Integer.toString(insertResult), userinfo);
		return hm;
	}


	

}
