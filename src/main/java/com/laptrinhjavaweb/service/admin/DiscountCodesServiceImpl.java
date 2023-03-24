package com.laptrinhjavaweb.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.DiscountDao;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DiscountCodes;

@Service
public class DiscountCodesServiceImpl implements IDiscountCodesService  {
	@Autowired
	private DiscountDao discountDao;
	
	@Override
	public List<DiscountCodes> GetDataSilde() {
		return discountDao.GetDataSilde();
	}
	
	@Override
	public int deleteOne(int id) {
		return discountDao.deleteOne(id);
	}
	
	@Override
	public int createOne(DiscountCodes d) {
		return discountDao.createOne(d);
	}
	
	@Override
	public int updateOne(DiscountCodes d) {
		return discountDao.updateOne(d);
	}
	
	@Override
	public DiscountCodes findById(int id) {
		return discountDao.findById(id);
	}


}

