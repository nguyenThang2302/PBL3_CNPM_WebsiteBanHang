package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BillDetail;
import com.laptrinhjavaweb.entity.BillProduct;
import com.laptrinhjavaweb.entity.Bills;
import com.laptrinhjavaweb.entity.MapperBillDetail;
import com.laptrinhjavaweb.entity.MapperBillProduct;
import com.laptrinhjavaweb.entity.MapperDepartments;

@Repository
public class BillDetailDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createBillDetail(BillDetail bd) {
		String sql = "INSERT INTO bills_detail (product_code, bill_code, quantity, total_price) VALUES (? ,?, ?, ?)";
		return _jdbcTemplate.update(sql, bd.getProduct_code(), bd.getBill_code(), bd.getQuantity(), bd.getTotal_price());
	}
	
	public List<BillProduct> findProductInBillByCode(String bill_code) {
		List<BillProduct> list = new ArrayList<BillProduct>();
		String sql = "select name, price, bills_detail.quantity, bills_detail.total_price from products inner join bills_detail on\n"
				+ "products.code = bills_detail.product_code where bills_detail.bill_code = ?";
		list = _jdbcTemplate.query(sql, new MapperBillProduct(), bill_code);
		return list;
	}
}
