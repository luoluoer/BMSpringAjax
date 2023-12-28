package com.example.demo.Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

@RestController
@RequestMapping("/files")
public class FileDealController {
	@Value("${server.port}")
	private String port;
	private static final String ip = "http://localhost";
	HashMap<String ,Object>  hm  = new HashMap<>();
	@PostMapping("/upload")
	public HashMap<String, Object> upload(MultipartFile file ){
		//定义文件的唯一标识
		String  flag = IdUtil.fastSimpleUUID();
		String originalFilename = file.getOriginalFilename();
		String rootFilePath =  System.getProperty("user.dir");
		String filepath = rootFilePath+"/src/main/resources/files/"+flag+originalFilename;
		System.out.println(filepath);
		try {
			FileUtil.writeBytes(file.getBytes(),filepath);
		} catch (IORuntimeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hm.put("code", 200);
			hm.put("message", "发生了异常,后端查看");
			return hm;
		}		
		hm.put("code", 200);
		hm.put("message", "success");
		hm.put("filepath", ip+":"+port +"/files/"+flag);//拼接结果URL
		return hm;
	}
	
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;  // 新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files/";  // 定于文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);  // 获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");  // 找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);  // 通过文件的路径读取文件字节流
                os = response.getOutputStream();   // 通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
