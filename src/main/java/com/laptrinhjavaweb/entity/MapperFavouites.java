package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperFavouites implements org.springframework.jdbc.core.RowMapper<Favourites> {
	
	public Favourites mapRow(ResultSet res, int rowNum) throws SQLException {

		Favourites sliders = new Favourites();

		sliders.setName(res.getString("name"));
		sliders.setPrice(res.getInt("price"));
		sliders.setCode(res.getString("code"));
		sliders.setCount_favourite(res.getInt("count_favourite"));
		return sliders;
	} 
}
