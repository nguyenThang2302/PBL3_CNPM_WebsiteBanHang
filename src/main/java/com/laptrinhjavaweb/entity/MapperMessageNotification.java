package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMessageNotification implements org.springframework.jdbc.core.RowMapper<MessageNotification> {
	public MessageNotification mapRow(ResultSet res, int rowNum) throws SQLException {
		MessageNotification sliders = new MessageNotification();
		sliders.setId(res.getInt("id"));
		sliders.setContact_id(res.getInt("contact_id"));
		return sliders;
	}
}
