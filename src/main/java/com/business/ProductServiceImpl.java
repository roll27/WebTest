package com.business;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.model.Product;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月6日下午3:34:33
 * 类说明
 */

@Service
public class ProductServiceImpl implements ProductService{
	
	private Map<Long,Product> products = new HashMap<Long , Product>();
	private AtomicLong generator = new AtomicLong();
	
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		Product product = new Product();
		product.setName("cyy");
		product.setDescription("abc");
		product.setPrice(12.3F);
		add(product);
	}

	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		long newId = generator.incrementAndGet();
		product.setId(newId);
		products.put(newId, product);
		return product;
	}

	@Override
	public Product get(long id) {
		// TODO Auto-generated method stub
		return products.get(id);
	}
	
}
