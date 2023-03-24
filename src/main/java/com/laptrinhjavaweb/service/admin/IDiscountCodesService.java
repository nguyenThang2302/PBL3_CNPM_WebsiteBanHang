package com.laptrinhjavaweb.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.DiscountCodes;

@Service
public interface IDiscountCodesService {

	@Autowired
	List<DiscountCodes> GetDataSilde();
	
	@Autowired
	public int deleteOne(int id);
	
	@Autowired
	public int createOne(DiscountCodes d);
	
	@Autowired
	public int updateOne(DiscountCodes id);
	
	@Autowired
	public DiscountCodes findById(int id);
	
	
}

