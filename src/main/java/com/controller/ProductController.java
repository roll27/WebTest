package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.business.ProductService;
import com.form.ProductForm;
import com.model.Product;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月6日下午2:56:41
 * 类说明
 */

@Controller
public class ProductController {
	private static final Log logger = LogFactory.getLog(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product_input")
	public String inputProduct(){
		logger.info("inputProduct called");
		return "ProductForm";
	}
	
	@RequestMapping(value="/product_save")
	public String saveProduct(ProductForm productForm , RedirectAttributes redirectAttributes){
		logger.info("saveProduct called");
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		try {
			product.setPrice(Float.parseFloat(productForm.getPrice()));
			;
		} catch (NumberFormatException e) {
		}
		Product saveProduct = productService.add(product);
		redirectAttributes.addFlashAttribute("message","The product was successfully added");
		return "redirect:/product_view/"+saveProduct.getId();
	}
	
	@RequestMapping(value = "/product_view/{id}")
	public String viewProduct(@PathVariable Long id,Model model){
		Product product = productService.get(id);
		model.addAttribute("product",product);
		return "ProductView";
	}
}
