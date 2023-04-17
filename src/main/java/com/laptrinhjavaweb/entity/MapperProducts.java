package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProducts implements org.springframework.jdbc.core.RowMapper<Products> {

	public Products mapRow(ResultSet res, int rowNum) throws SQLException {

		Products sliders = new Products();

		sliders.setId(res.getInt("id"));
		sliders.setCode(res.getString("code"));
		sliders.setImage(res.getString("image"));
		sliders.setName(res.getString("name"));
		sliders.setPrice(res.getDouble("price"));
		sliders.setDepartment_id(res.getInt("department_id"));
		return sliders;
	}
}
