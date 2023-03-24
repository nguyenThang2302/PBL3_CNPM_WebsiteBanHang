package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperDiscountCodes implements org.springframework.jdbc.core.RowMapper<DiscountCodes> {

	public DiscountCodes mapRow(ResultSet res, int rowNum) throws SQLException {

		DiscountCodes sliders = new DiscountCodes();
		
		sliders.setId(res.getInt("id"));
		sliders.setDiscount_name(res.getString("discount_name"));
		sliders.setDiscount_code(res.getString("discount_code"));
		sliders.setDiscount_percent(res.getDouble("discount_percent"));
		sliders.setAmount(res.getInt("amount"));
		sliders.setValid_date(res.getString("valid_date"));
	
		return sliders;
	}
}
