package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperOrder implements org.springframework.jdbc.core.RowMapper<Order> {
	public Order mapRow(ResultSet res, int rowNum) throws SQLException {
		Order sliders = new Order();
		sliders.setCode(res.getString("code"));
		sliders.setQuantity(res.getInt("quantity"));
		sliders.setTotal_price(res.getDouble("total_price"));
		sliders.setCreated_at(res.getString("created_at"));
		return sliders;
	}
}
