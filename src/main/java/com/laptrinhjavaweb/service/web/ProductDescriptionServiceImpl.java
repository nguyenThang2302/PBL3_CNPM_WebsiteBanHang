package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.ProductDao;
import com.laptrinhjavaweb.entity.Products;

@Service
public class ProductDescriptionServiceImpl implements IProductDescriptionService {
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Products> findAllProductTop(String slug_name) {
		return productDao.findAllProductTop(slug_name);
	}
	
	@Override
	public List<Products> findAllProductsNew(String slug_name) {
		return productDao.findAllProductsNew(slug_name);
	}
}
