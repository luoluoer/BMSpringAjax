package com.example.demo.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Config.ResultConfig;
import com.example.demo.Model.MaterielGoodsInfo;
import com.example.demo.ServiceImpl.MaterileGoodsInfoDealimpl;
@RestController
@RequestMapping("MaterielGoodsInfoDeal")
public class MaterielGoodsInfoDealController {
	@Autowired
	MaterileGoodsInfoDealimpl MGIDeal;
	HashMap<String, Object> hm = new HashMap<>();
	@PostMapping()
	public ResultConfig<?>  addMaterielGoodsInfo(@RequestBody MaterielGoodsInfo mgi){
		MGIDeal.addMaterileGoodsInfo(mgi);
		return ResultConfig.success();
	}
	
	@PutMapping()
	public ResultConfig<?>  updateMaterielGoodsInfo(@RequestBody MaterielGoodsInfo mgi){
		MGIDeal.updateMaterileGoodsInfoById(mgi);
		return ResultConfig.success();
		

	}
	
	
	
	@DeleteMapping("/{id}")
	public ResultConfig<?> deleteMaterielGoodsinfoById(@PathVariable long id){
		System.out.println("进入删除物料方法");
		System.out.println(id);
		MGIDeal.deleteMaterileGoodsInfoById(id);
		return ResultConfig.success();
	}
}
