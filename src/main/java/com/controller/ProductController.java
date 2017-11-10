package com.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.business.ProductService;
import com.model.Product;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月6日下午2:56:41 类说明
 */

@Controller
public class ProductController{
	private static final Log logger = LogFactory.getLog(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product_input")
	public String inputProduct(Model model) {
		logger.info("inputProduct called");
		model.addAttribute("product", new Product());
		return "ProductForm";
	}

	@RequestMapping(value = "/product_save")
	public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {
		logger.info("saveProduct called");
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
			return "ProductForm";
		}

		Product saveProduct = productService.add(product);
		redirectAttributes.addFlashAttribute("message", "The product was successfully added");
		return "redirect:/product_view/" + saveProduct.getId();
	}

	@RequestMapping(value = "/product_view/{id}")
	public String viewProduct(@PathVariable Long id, Model model) {
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "ProductView";
	}
}
