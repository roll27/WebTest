package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月22日下午9:57:44
 * 类说明
 */

@Controller //spring mvc 控制器注解
public class HelloWorldController {
	
	@RequestMapping("/helloWorld") //spring mvc 控制器中对请求URL的映射,值为URL后缀。
	public String helloworld(Model model) {
		//Model是spring mvc中的model对象，可在返回视图中获取，message是返回对象的名，HelloWorld是值。
		model.addAttribute("message", "HelloWorld");
		//返回的是helloWorld的视图名称，如果后缀是jsp（配置中查看），则就是指向helloWorld.jsp
		return "helloWorld";
	}
	
}
