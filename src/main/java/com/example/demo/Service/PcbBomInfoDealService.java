package com.example.demo.Service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Config.ResultConfig;
import com.example.demo.Model.PcbBomInfo;

public interface PcbBomInfoDealService {
//	public ResultConfig<?>  addPcbBomInfo(PcbBomInfo Pcbbominfo) ;
	
	public int updatePcbBomInfo(PcbBomInfo Pcbbominfo);
	
	public int deletePcbBomInfo(long id);
	
	public ResultConfig<?> selectPcbBomInfo(PcbBomInfo Pcbbominfo);

	ResultConfig<?> addPcbBomInfo(PcbBomInfo Pcbbominfo);

}
