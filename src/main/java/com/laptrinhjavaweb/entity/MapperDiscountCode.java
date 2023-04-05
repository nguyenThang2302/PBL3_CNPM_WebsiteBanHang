package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperDiscountCode implements org.springframework.jdbc.core.RowMapper<DiscountCode> {
	
	public DiscountCode mapRow(ResultSet res, int rowNum) throws SQLException {
		DiscountCode sliders = new DiscountCode();
		
		sliders.setId(res.getInt("id"));
		sliders.setName(res.getString("name"));
		sliders.setSlug_name(res.getString("slug_name"));
		sliders.setCode(res.getString("code"));
		sliders.setPercent(res.getDouble("percent"));
		sliders.setAmount(res.getInt("amount"));
		sliders.setValid_date(res.getDate("valid_date"));
		
		return sliders;
	}
}
