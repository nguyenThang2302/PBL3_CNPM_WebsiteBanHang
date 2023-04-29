package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Products;

@Service
public interface IProductDescriptionService {
	@Autowired
	public List<Products> findAllProductTop(String slug_name);
}
