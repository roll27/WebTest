package com.contorller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月1日下午2:53:01
 * 类说明
 */
public class InputProductController implements Contorller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/WEB-INF/jsp/ProductForm.jsp";
	}
	
}
