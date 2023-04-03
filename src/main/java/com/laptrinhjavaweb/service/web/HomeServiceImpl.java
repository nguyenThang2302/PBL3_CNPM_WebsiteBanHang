package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.ProductDao;
import com.laptrinhjavaweb.dao.TradeMarksDao;
import com.laptrinhjavaweb.entity.Departments;
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
}
