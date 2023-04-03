package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperDepartments implements org.springframework.jdbc.core.RowMapper<Departments> {

	public Departments mapRow(ResultSet res, int rowNum) throws SQLException {

		Departments sliders = new Departments();
		
		sliders.setId(res.getInt("id"));
		sliders.setName(res.getString("name"));
		sliders.setSlug_name(res.getString("slug_name"));
		return sliders;
	}
}
