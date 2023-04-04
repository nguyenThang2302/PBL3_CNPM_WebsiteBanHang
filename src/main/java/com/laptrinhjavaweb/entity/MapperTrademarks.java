package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperTrademarks implements org.springframework.jdbc.core.RowMapper<Trademarks> {

	public Trademarks mapRow(ResultSet res, int rowNum) throws SQLException {

		Trademarks trameMarks = new Trademarks();

		trameMarks.setId(res.getInt("id"));
		trameMarks.setImage(res.getString("image"));
		trameMarks.setName(res.getString("name"));
		trameMarks.setUrl(res.getString("url"));
		return trameMarks;
	}
}
