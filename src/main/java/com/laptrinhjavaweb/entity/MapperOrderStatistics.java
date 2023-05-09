package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperOrderStatistics implements org.springframework.jdbc.core.RowMapper<OrderStatistics> {
	public OrderStatistics mapRow(ResultSet res, int rowNum) throws SQLException {
		OrderStatistics sliders = new OrderStatistics();
		sliders.setTotal_price(res.getDouble("total_price"));
		sliders.setTotal_quantity(res.getInt("total_quantity"));
		sliders.setTotal_bills(res.getInt("total_bills"));
		return sliders;
	}
}
