package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperContactMessage implements org.springframework.jdbc.core.RowMapper<ContactMessage> {
	public ContactMessage mapRow(ResultSet res, int rowNum) throws SQLException {
		ContactMessage sliders = new ContactMessage();
		sliders.setId(res.getInt("id"));
		sliders.setName(res.getString("name"));
		sliders.setEmail(res.getString("email"));
		sliders.setMessage(res.getString("message"));
		sliders.setCreated_at(res.getString("created_at"));
		sliders.setPhone(res.getString("phone"));
		sliders.setStatus(res.getString("status"));
		return sliders;
	}
}
