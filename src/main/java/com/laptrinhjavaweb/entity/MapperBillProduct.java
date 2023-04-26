package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBillProduct implements org.springframework.jdbc.core.RowMapper<BillProduct> {
	public BillProduct mapRow(ResultSet res, int rowNum) throws SQLException {
		BillProduct sliders = new BillProduct();
		sliders.setName(res.getString("name"));
		sliders.setPrice(res.getDouble("price"));
		sliders.setQuantity(res.getInt("quantity"));
		sliders.setTotal_price(res.getDouble("total_price"));
		return sliders;
	}
}
