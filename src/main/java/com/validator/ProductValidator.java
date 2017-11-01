package com.validator;

import java.util.ArrayList;
import java.util.List;

import com.form.ProductForm;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月1日下午3:18:27
 * 类说明
 */
public class ProductValidator {
	
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
}
