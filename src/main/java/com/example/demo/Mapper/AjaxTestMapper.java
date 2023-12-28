package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Model.MaterielGoodsInfo;


@Mapper
public interface AjaxTestMapper  extends BaseMapper<MaterielGoodsInfo>{
	
	@Select("select * from materielgoodsinfo ")
	public List<MaterielGoodsInfo> findall();
	
	@Select("select * from materielgoodsinfo limit #{pageNum}")
	public List<MaterielGoodsInfo> findbypagenum(int pageNum,int pageSize);
	
	@Select("select count(*) from materielgoodsinfo")
	public Integer selectTotal();
}

	
