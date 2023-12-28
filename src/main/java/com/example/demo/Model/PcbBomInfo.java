package com.example.demo.Model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName("pcbbominfo")
@Data
public class PcbBomInfo {
	@TableId(type=IdType.AUTO,value="id")
	private int id;
	private int bomid;
	private String bomname;
	private int quantity;

	public PcbBomInfo  (int bomid,String bomname,int quantity) {
		this.bomid = bomid;
		this.bomname = bomname;
		this.quantity = quantity;
		//return;
	}

}





