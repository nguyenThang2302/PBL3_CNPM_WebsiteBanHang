package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Trademarks;
@Service
public interface IHomeService {
	@Autowired
	public List<Products> GetDataSilde();
	@Autowired
	public List<Trademarks> GetDataTradeMark();
}
