package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月1日下午2:53:01
 * 类说明
 */
public class InputProductController implements Controller{
	
	private static final Log logger = LogFactory.getLog(InputProductController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp");
	}
	
}
