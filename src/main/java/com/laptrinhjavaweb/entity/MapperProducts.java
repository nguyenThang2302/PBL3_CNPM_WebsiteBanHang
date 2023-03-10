package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProducts implements org.springframework.jdbc.core.RowMapper<Products> {

	public Products mapRow(ResultSet res, int rowNum) throws SQLException {

		Products sliders = new Products();
		/*
		 * sliders.setId(res.getInt("id")); sliders.setName(res.getString("name"));
		 * sliders.setEmail(res.getString("email")); sliders.setAge(res.getInt("age"));
		 * sliders.setDob(res.getString("dob"));
		 */

		sliders.setId(res.getInt("id"));
		sliders.setImage(res.getString("image"));
		sliders.setName(res.getString("name"));
		sliders.setPrice(res.getInt("price"));
		return sliders;
	}
}
