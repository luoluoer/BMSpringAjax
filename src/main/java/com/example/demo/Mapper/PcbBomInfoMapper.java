package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Model.PcbBomInfo;

@Mapper
public interface PcbBomInfoMapper {
	@Select("select * from pcbbominfo")
	public List<PcbBomInfo> getpcbbominfo ();
}
