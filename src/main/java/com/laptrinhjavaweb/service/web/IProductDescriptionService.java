package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.Products;

@Service
public interface IProductDescriptionService {
	@Autowired
	public List<Products> findAllProductTop(String slug_name);
	@Autowired
	public List<Products> findAllProductsNew(String slug_name);
	@Autowired
	public List<Products> findAllRelatedProduct(String slug_name);
	@Autowired
	public DescriptionProduct findProductDescription(String product_code);
}
