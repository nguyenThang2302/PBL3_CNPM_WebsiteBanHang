package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBillNotification implements org.springframework.jdbc.core.RowMapper<BillNotification>{
	public BillNotification mapRow(ResultSet res, int rowNum) throws SQLException {
		BillNotification sliders = new BillNotification();
		sliders.setId(res.getInt("id"));
		sliders.setBill_code(res.getString("bill_code"));
		return sliders;
	}
}
