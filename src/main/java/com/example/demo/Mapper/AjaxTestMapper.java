package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Model.MaterielGoodsInfo;


@Mapper
public interface AjaxTestMapper {
	@Select("select * from materielgoodsinfo ")
	public List<MaterielGoodsInfo> findall();
}
