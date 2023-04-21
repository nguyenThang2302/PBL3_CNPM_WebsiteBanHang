package com.laptrinhjavaweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BillDetail;

@Repository
public class BillDetailDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createBillDetail(BillDetail bd) {
		String sql = "INSERT INTO bills_detail (product_code, bill_code, quantity, total_price) VALUES (? ,?, ?, ?)";
		return _jdbcTemplate.update(sql, bd.getProduct_code(), bd.getBill_code(), bd.getQuantity(), bd.getTotal_price());
	}
}
