package com.example.demo.Controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.PcbBomInfo;
import com.example.demo.Service.PcbBomInfoDealService;



@RestController
@RequestMapping("/PcbBomInfoDeal")
public class PcbBomInfoDealController {
	@Resource(name = "pcbbominfodealimpl")
	PcbBomInfoDealService pbis ;
	@PostMapping()
	public HashMap<String, Object>  addPcbBomInfoDeal (
			HttpServletRequest req ,
			@RequestParam(value = "bomid") String  bomid,
			@RequestParam(value = "bomname") String bomname,
			@RequestParam(value = "quantity") String quantity
			
			){
		
		PcbBomInfo  pbi = new PcbBomInfo(Integer.valueOf(bomid), bomname, Integer.valueOf(quantity));
		System.out.println("addPcbBomInfoDeal方法");
		pbis.addPcbBomInfo(pbi);
		HashMap<String, Object>  hm = new HashMap<>();
		hm.put("code", 200);
		return hm;
	}

}
