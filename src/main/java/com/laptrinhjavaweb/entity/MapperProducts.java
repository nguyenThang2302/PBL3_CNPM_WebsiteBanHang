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
		sliders.setDepartment_id(res.getInt("department_id"));
		sliders.setBrand(res.getString("brand"));
		sliders.setDescription(res.getString("description"));
		sliders.setInformation(res.getString("information"));
		sliders.setSalient(res.getString("salient"));
		sliders.setColor(res.getString("color"));
		sliders.setStatus(res.getString("status"));
		return sliders;
	}
}
