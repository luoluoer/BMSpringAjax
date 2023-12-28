package com.example.demo.Config;
//Mybatis分页查询
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;



@Configuration
@MapperScan("com.example.demo.Mapper")

public class MyBatistaConfig  {
	
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		
		return new PaginationInterceptor();
		
		
	}
	
}
