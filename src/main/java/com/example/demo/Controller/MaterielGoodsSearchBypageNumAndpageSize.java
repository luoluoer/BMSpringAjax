package com.example.demo.Controller;

import java.lang.invoke.LambdaConversionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.core.*;
import com.example.demo.Config.ResultConfig;
import com.example.demo.Mapper.AjaxTestMapper;
import com.example.demo.Model.MaterielGoodsInfo;

import cn.hutool.core.util.StrUtil;

@RestController
@RequestMapping("/MaterielGoodsSearch")
public class MaterielGoodsSearchBypageNumAndpageSize {
	@Autowired
	AjaxTestMapper ajm;
	@GetMapping
	public ResultConfig<?> getMaterielGoodsInfoBypageNumandpageSize(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "") String search
			){
		System.out.println("进入到了MaterielGoodsSearch方法");
		System.out.println("输出searchkeyword000:"+search);
		//new Page<>(pageNum,pageSize);
		
//		Page<MaterielGoodsInfo> materielgoodsinfopage =  ajm.selectPage(new Page<>(pageNum,pageSize),
//				Wrappers.<MaterielGoodsInfo>lambdaQuery().like(MaterielGoodsInfo::getComment, searchkeyword)
//				);
		
		LambdaQueryWrapper<MaterielGoodsInfo> wrapper= Wrappers.lambdaQuery();
		System.out.println("输出searchkeyword:"+search);
		if(StrUtil.isNotBlank(search)) {
			wrapper.like(MaterielGoodsInfo::getComment,search);
		}
		Page<MaterielGoodsInfo> materielgoodsinfopage = ajm.selectPage(new Page<>(pageNum,pageSize), wrapper);
		
		System.out.println("妈了个巴子的");
		return ResultConfig.success(materielgoodsinfopage);
	}
}
