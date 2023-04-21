package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBills implements org.springframework.jdbc.core.RowMapper<Bills> {
	public Bills mapRow(ResultSet res, int rowNum) throws SQLException {
		Bills sliders = new Bills();
		sliders.setId(res.getInt("id"));
		sliders.setCode(res.getString("code"));
		sliders.setPhone(res.getString("phone"));
		sliders.setEmail(res.getString("email"));
		sliders.setAddress(res.getString("address"));
		sliders.setQuantity(res.getInt("quantity"));
		sliders.setTotal_price(res.getDouble("total_price"));
		sliders.setUser_code(res.getString("user_code"));
		sliders.setNote(res.getString("note"));
		sliders.setCreated_at(res.getString("created_at"));
		return sliders;
	}
}
