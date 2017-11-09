package com.validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.form.ProductForm;
import com.model.Product;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月1日下午3:18:27
 * 类说明
 */
public class ProductValidator implements Validator{
	
	public List<String> validate(ProductForm productForm){
		List<String> errors = new ArrayList<String>();
		String name = productForm.getName();
		//isEmpty 判断可以判断空对象和空字符串。如：String a = new String()和String b = ""两类;
		if(name == null || name.trim().isEmpty()){
			errors.add("Product must have a name");
		}
		String price = productForm.getPrice();
		if(price == null || price.trim().isEmpty()){
			errors.add("Product must have a price");
		}else{
			try{
				Float.parseFloat(price);
			}catch (NumberFormatException e){
				errors.add("Invalid price value");
			}
		}
		return errors;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product = (Product)target;
		ValidationUtils.rejectIfEmpty(errors, "name", "productname.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
		ValidationUtils.rejectIfEmpty(errors, "productionDate", "productiondate.required");
		Float price = product.getPrice();
		if(price != null && price < 0 ){
			errors.rejectValue("price", "price.negative");
		}
		Date productionDate = product.getProductionDate();
		if(productionDate != null){
			if(productionDate.after(new Date())){
				System.out.println("salah lagi");
				errors.rejectValue("productionDate", "productiondate.invalid");
			}
		}
	}
}
