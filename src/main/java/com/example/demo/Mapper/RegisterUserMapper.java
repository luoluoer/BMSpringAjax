package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Model.UserInfo;

@Mapper
public interface RegisterUserMapper {
	//根据用户名，判断是否存在
	@Select("select * from user where username = #{username}")
	public List<UserInfo> getUserInfoByUsername(String username);
	
	//根据用户名和密码，判断登录信息是否正确
	@Select("select * from user where username = #{username} and password = #{password}" )
	public List<UserInfo> getUserInfoByUsernameandPassword(String username,String password);
	
	//根据用户名和密码，新建用户
	@Insert("insert into user(username,password) values (#{username},#{password})")
	public void insertuserinfo(String username,String password);
}
