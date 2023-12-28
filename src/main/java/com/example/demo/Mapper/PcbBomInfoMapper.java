package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Model.PcbBomInfo;
import com.example.demo.Model.UserInfo;

@Mapper
public interface PcbBomInfoMapper  extends BaseMapper<PcbBomInfo> {
	@Select("select * from pcbbominfo")
	public List<PcbBomInfo> getpcbbominfo ();
}
