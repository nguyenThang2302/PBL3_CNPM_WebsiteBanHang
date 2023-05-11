package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.Favourites;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Trademarks;
@Service
public interface IHomeService {
	@Autowired
	public List<Products> GetDataSilde(int departmentId);
	@Autowired
	public List<Products> findAllProducts();
	@Autowired
	public List<Trademarks> GetDataTradeMark();
	@Autowired
	int deleteOne(String code);
	@Autowired
	int createOne(Products p, int department_id);
	@Autowired
	int updateOne(Products p);
	@Autowired
	Products findById(int id);
	@Autowired
	public List<Products> getProductById(int id);
	@Autowired
	public Products findByCode(String code);
	@Autowired
	public List<Products> findByDepartmentId(int id);
	@Autowired
	public List<Products> findAllNewProductHome();
	@Autowired
	public List<Favourites> findAllFavouriteProductHome();
	@Autowired
	public List<Products> findAllProductTopHome();
	@Autowired
	public List<Products> findProductWithDepartmentAndBrand(String brand, String slug_name);
	@Autowired
	public List<Products> findProductWithAroundPrice(String slug_name, double fromPrice, double toPrice);
	@Autowired
	public List<Products> findProductWithDepartmentAndColor(String color, String slug_name);
}
