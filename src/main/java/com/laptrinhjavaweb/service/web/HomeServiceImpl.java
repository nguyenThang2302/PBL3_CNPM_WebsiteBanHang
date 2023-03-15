package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.ProductDao;
import com.laptrinhjavaweb.dao.TradeMarksDao;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Trademarks;
@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private TradeMarksDao trademarkDao;

	@Override
	public List<Products> GetDataSilde() {
		return productDao.GetDataSilde();
	}

	@Override
	public List<Trademarks> GetDataTradeMark() {
		return trademarkDao.GetDataTradeMark();
	}
	
	@Override
	public int deleteOne(int id) {
		return productDao.deleteOne(id);
	}
	
	@Override
	public int createOne(Products p) {
		return productDao.createOne(p);
	}
	
	@Override
	public int updateOne(Products p) {
		return productDao.updateOne(p);
	}
	
	@Override
	public Products findById(int id) {
		return productDao.findById(id);
	}
}
