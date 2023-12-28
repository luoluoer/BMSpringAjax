package com.example.demo.Model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("user")
@Data
public class UserInfo {
	@TableId(type=IdType.AUTO)
	private Integer id;
	private String username;
	private String password ;
	private String realname;
	
	public UserInfo (String username,String password,String realname){
		this.username = username;
		this.password = password;
		this.realname = realname;
	}
}
