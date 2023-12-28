package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Mapper.AjaxTestMapper;
import com.example.demo.Model.MaterielGoodsInfo;
import com.example.demo.Service.MaterileGoodsInfoServiceDeal;
@Service
public class MaterileGoodsInfoDealimpl implements MaterileGoodsInfoServiceDeal{
	@Autowired
	AjaxTestMapper ajm;
	
	@Override
	public void addMaterileGoodsInfo(MaterielGoodsInfo mgi) {
		// TODO Auto-generated method stub
		ajm.insert(mgi);
		
	}

	@Override
	public void updateMaterileGoodsInfoById(MaterielGoodsInfo mgi) {
		// TODO Auto-generated method stub
		ajm.updateById(mgi);
		
	}

	@Override
	public void deleteMaterileGoodsInfoById(long  id) {
		// TODO Auto-generated method stub
		ajm.deleteById(id);
		
	}
	
}
