package com.example.demo.ServiceImpl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Config.ResultConfig;
import com.example.demo.Mapper.PcbBomInfoMapper;
import com.example.demo.Model.PcbBomInfo;

import com.example.demo.Service.PcbBomInfoDealService;
@Service("pcbbominfodealimpl")
public class PcbBomInfoDealImpl  implements PcbBomInfoDealService{
	@Autowired
	PcbBomInfoMapper pm;
	@Override
	public ResultConfig<?>  addPcbBomInfo(PcbBomInfo pcbbominfo) {
		
		
		// TODO Auto-generated method stub
		int inserResult = 0 ;
		inserResult = pm.insert(pcbbominfo);
		if (inserResult ==1) {
			return ResultConfig.success();
		}
		return ResultConfig.error("-1","插入产品信息失败");
	}

	@Override
	public int updatePcbBomInfo(PcbBomInfo Pcbbominfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePcbBomInfo(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultConfig<?> selectPcbBomInfo(PcbBomInfo Pcbbominfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
