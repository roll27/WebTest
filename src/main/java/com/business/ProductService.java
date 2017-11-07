package com.business;

import com.model.Product;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月6日下午3:33:20
 * 类说明
 */
public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
