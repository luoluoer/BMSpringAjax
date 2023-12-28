package com.example.demo.Config;
//返回结果集控制
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class ResultConfig<T> {
	private String code;
	private String message;
	private T data;
	
	
	public ResultConfig(T data) {
		this.data = data;
	}
	
	public static ResultConfig success() {
		ResultConfig result = new ResultConfig<>();
		result.setCode("200");
		result.setMessage("成功");
		return result;
	}
	
	public static <T> ResultConfig<T> success(T data) {
		ResultConfig<T> result = new ResultConfig<>(data);
		result.setCode("200");
		result.setMessage("成功");
		return result;
	}
	
	
	public static <T> ResultConfig<T> error(String code ,String msg) {
		ResultConfig<T> result = new ResultConfig<>();
		result.setCode(code);
		result.setMessage(msg);
		return result;
	}
	
	public static <T> ResultConfig<T> error(String code ,String msg,T data) {
		ResultConfig<T> result = new ResultConfig<>();
		result.setCode(code);
		result.setMessage(msg);
		result.data =data;
		return result;
	}
}
