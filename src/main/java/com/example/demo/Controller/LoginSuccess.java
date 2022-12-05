package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapper.PcbBomInfoMapper;
import com.example.demo.Model.PcbBomInfo;

@Controller
public class LoginSuccess {
	@Autowired
	PcbBomInfoMapper pbim;
	@RequestMapping("/loginsuccess")
	public String getPcbBomInfo(HttpServletRequest req,HttpSession session,Model model){
		System.out.println("进入loginsuccess页面");
		List<PcbBomInfo> pcbbominfo =  pbim.getpcbbominfo();
		session = req.getSession();
		
		System.out.println("这里是登录成功页面获取的session"+session.getAttribute("userinfo"));
		
		System.out.println(pcbbominfo);
		model.addAttribute("pcbbominfo",pcbbominfo);
			  
		return "/html/loginsuccess";
	}
}
