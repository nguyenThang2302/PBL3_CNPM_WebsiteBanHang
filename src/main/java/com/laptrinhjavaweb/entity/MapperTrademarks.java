package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperTrademarks implements org.springframework.jdbc.core.RowMapper<Trademarks> {

	public Trademarks mapRow(ResultSet res, int rowNum) throws SQLException {

		Trademarks trameMarks = new Trademarks();
		/*
		 * sliders.setId(res.getInt("id")); sliders.setName(res.getString("name"));
		 * sliders.setEmail(res.getString("email")); sliders.setAge(res.getInt("age"));
		 * sliders.setDob(res.getString("dob"));
		 */

		trameMarks.setId(res.getInt("id"));
		trameMarks.setImage(res.getString("image"));
		trameMarks.setName(res.getString("name"));
		return trameMarks;
	}
}
