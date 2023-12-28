package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapper.AjaxTestMapper;
import com.example.demo.Model.MaterielGoodsInfo;

@RestController
@RequestMapping("/pagenum")
public class PageNumController {
	HashMap<String, Object> hm = new HashMap<>();
	@Autowired
	AjaxTestMapper am;
	//@GetMapping("/page")
	//@RequestMapping("/userloginpage")
	public HashMap<String,Object> pagenum (@RequestParam Integer pageNum ,@RequestParam Integer pageSize,@RequestParam String search) {
		System.out.println("进入到了userloginpage");
		pageNum = (pageNum-1)*pageSize;
		List<MaterielGoodsInfo> data = am.findbypagenum(pageNum,pageSize);
		System.out.println("打印data:"+data);
		Integer total = am.selectTotal();
		System.out.println("打印total:"+total);
		
		hm.put("data",data);
		hm.put("total", total);
		System.out.println(hm);
		return hm;
	}
	
}
