package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.ProductDao;
import com.laptrinhjavaweb.dao.TradeMarksDao;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.Favourites;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Trademarks;
@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private TradeMarksDao trademarkDao;

	@Override
	public List<Products> GetDataSilde(int departmentId) {
		return productDao.GetDataSilde(departmentId);
	}
	
	@Override
	public List<Products> findAllProducts() {
		return productDao.findAllProducts();
	}

	@Override
	public List<Trademarks> GetDataTradeMark() {
		return trademarkDao.GetDataTradeMark();
	}
	
	@Override
	public int deleteOne(String code) {
		return productDao.deleteOne(code);
	}
	
	@Override
	public int createOne(Products p, int department_id) {
		return productDao.createOne(p, department_id);
	}
	
	@Override
	public int updateOne(Products p) {
		return productDao.updateOne(p);
	}
	
	@Override
	public Products findById(int id) {
		return productDao.findById(id);
	}
	
	@Override
	public List<Products> getProductById(int id) {
		return productDao.getProductById(id);
	}
	
	@Override
	public Products findByCode(String code) {
		return productDao.findByCode(code);
	}
	
	@Override
	public List<Products>  findByDepartmentId(int id) {
		return productDao.findByDepartmentId(id);
	}
	
	@Override
	public List<Products> findAllNewProductHome() {
		return productDao.findAllNewProductHome();
	}
	
	@Override
	public List<Favourites> findAllFavouriteProductHome() {
		return productDao.findAllFavouriteProductHome();
	}
	
	@Override
	public List<Products> findAllProductTopHome() {
		return productDao.findAllProductTopHome();
	}
	
	@Override
	public List<Products> findProductWithDepartmentAndBrand(String brand, String slug_name) {
		return productDao.findProductWithDepartmentAndBrand(brand, slug_name);
	}
	
	@Override
	public List<Products> findProductWithAroundPrice(String slug_name, double fromPrice, double toPrice) {
		return productDao.findProductWithAroundPrice(slug_name, fromPrice, toPrice);
	}
	
	@Override
	public List<Products> findProductWithDepartmentAndColor(String color, String slug_name) {
		return productDao.findProductWithDepartmentAndColor(color, slug_name);
	}
}
