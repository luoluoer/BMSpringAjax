package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
@MapperScan("com.example.demo.Mapper")
@SpringBootApplication
public class AjaxDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(AjaxDemo2Application.class, args);
	}

}
