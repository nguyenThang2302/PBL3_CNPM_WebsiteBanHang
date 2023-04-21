package com.laptrinhjavaweb.service.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.entity.BillDetail;
import com.laptrinhjavaweb.entity.BillProduct;
import com.laptrinhjavaweb.entity.Bills;

@Service
public interface IBillsService {
	@Autowired
	public int createOneBill(Bills b);
	@Autowired
	public void AddBillDetail(HashMap<String, CartDto> carts);
	@Autowired
	public List<Bills> findAllBillsByUserCode(String user_code);
	@Autowired
	public Bills findBillsByCode(String code);
	@Autowired
	public List<BillProduct> findProductInBillByCode(String bill_code);
}
