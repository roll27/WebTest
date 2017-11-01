package com.contorller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月1日下午2:51:04 类说明
 */
public interface Contorller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
