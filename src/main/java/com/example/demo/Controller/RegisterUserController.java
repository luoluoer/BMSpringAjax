package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;

import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapper.AjaxTestMapper;
import com.example.demo.Mapper.RegisterUserMapper;
import com.example.demo.Model.MaterielGoodsInfo;
import com.example.demo.Model.UserInfo;
import com.example.demo.Service.RegisterUserService;

@RestController
public class RegisterUserController {
//	@Autowired
//	RegisterUserMapper ru;
	@Autowired
	RegisterUserService rs;
	@PostMapping("/registeruser")
	//public HashMap<String,Object> registeruser (HttpServletRequest req) {
	public HashMap<String,Object> registeruser (
			HttpServletRequest req ,
			@RequestParam(value = "regusername") String regusername,
			@RequestParam(value = "regpassword") String regpassword,
			@RequestParam(value = "confirmpassword") String confirmpassword,
			@RequestParam(value = "realname") String realname
			
			)  
	{	
		//后期通过basemapper.insert直接插入
		//UserInfo userinfo = new UserInfo(regusername,regpassword,realname);
		
		System.out.println("page registerusercontroller");
		System.out.println(regusername);
		System.out.println(regpassword);
		System.out.println(confirmpassword);
		System.out.println(req.getMethod());
		HashMap<String, Object> registermessage = new HashMap<>();
		//System.out.println(rs.registeruser(regusername, regpassword, confirmpassword));
		//return rs.registeruser(regusername, regpassword, confirmpassword);
		registermessage = rs.registeruser(regusername, regpassword, confirmpassword);
		return registermessage;
	}
}
