package com.laptrinhjavaweb.service.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.dao.BillDetailDao;
import com.laptrinhjavaweb.dao.BillsDao;
import com.laptrinhjavaweb.entity.BillDetail;
import com.laptrinhjavaweb.entity.Bills;

@Service
public class BillsServiceImpl implements IBillsService {
	@Autowired
	private BillsDao billsDao;
	@Autowired
	private BillDetailDao billDetailDao;
	
	@Override
	public int createOneBill(Bills b) {
		return billsDao.createOneBill(b);
	}
	
	public void AddBillDetail(HashMap<String, CartDto> carts) {
		String billCode = billsDao.getLastBillCode();
		
		for(Map.Entry<String, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setProduct_code(itemCart.getValue().getProduct().getCode());
			billDetail.setBill_code(billCode);
			billDetail.setQuantity(itemCart.getValue().getQuantity());
			billDetail.setTotal_price(itemCart.getValue().getTotalPrice());
			billDetailDao.createBillDetail(billDetail);
		}
	}
}
