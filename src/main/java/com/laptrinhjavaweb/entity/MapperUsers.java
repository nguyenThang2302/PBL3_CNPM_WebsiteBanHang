package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users> {
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setUser_code(rs.getString("user_code"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		/*
		 * user.setRepeat_password(rs.getString("repeat_password"));
		 */		return user;
	}
}