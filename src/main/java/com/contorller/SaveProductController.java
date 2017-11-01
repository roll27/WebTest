package com.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.form.ProductForm;
import com.model.Product;
import com.validator.ProductValidator;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月1日下午2:54:19 类说明
 */
public class SaveProductController implements Contorller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProductForm productForm = new ProductForm();
		productForm.setName(request.getParameter("name"));
		productForm.setDescription(request.getParameter("description"));
		productForm.setPrice(request.getParameter("price"));

		ProductValidator productValidator = new ProductValidator();
		List<String> errors = productValidator.validate(productForm);
		if (errors.isEmpty()) {

			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			try {
				product.setPrice(Float.parseFloat(productForm.getPrice()));
				;
			} catch (NumberFormatException e) {
			}
			request.setAttribute("product", product);
			return "/WEB-INF/jsp/ProductDetails.jsp";

		} else {
			request.setAttribute("errors", errors);
			System.out.println(errors);
			request.setAttribute("form", productForm);
			return "/WEB-INF/jsp/ProductForm.jsp";
		}
	}

}
