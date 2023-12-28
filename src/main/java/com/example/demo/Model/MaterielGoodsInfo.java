package com.example.demo.Model;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月23日 下午8:57:30
*/
@Data
@TableName("MaterielGoodsInfo")
public class MaterielGoodsInfo {
	private  int id;
	private String comment;
	private String description;
	private String designator;
	private String footprint;
	private int quantity;
}