package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBillDetail implements org.springframework.jdbc.core.RowMapper<BillDetail> {
	public BillDetail mapRow(ResultSet res, int rowNum) throws SQLException {
		BillDetail sliders = new BillDetail();
		sliders.setId(res.getInt("id"));
		sliders.setProduct_code(res.getString("product_code"));
		sliders.setBill_code(res.getString("bill_code"));
		sliders.setTotal_price(res.getDouble("total_price"));
		sliders.setQuantity(res.getInt("quantity"));
		return sliders;
	}
}
