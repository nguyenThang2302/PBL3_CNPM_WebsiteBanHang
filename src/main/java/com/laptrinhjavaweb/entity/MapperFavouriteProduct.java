package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperFavouriteProduct implements org.springframework.jdbc.core.RowMapper<FavouriteProduct> {
	
	public FavouriteProduct mapRow(ResultSet res, int rowNum) throws SQLException {
		FavouriteProduct sliders = new FavouriteProduct();
		
		sliders.setId(res.getInt("id"));
		sliders.setProduct_code(res.getString("product_code"));
		sliders.setDepartment_id(res.getInt("department_id"));
		return sliders;
	}
}
