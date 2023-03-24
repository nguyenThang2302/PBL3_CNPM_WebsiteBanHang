package com.laptrinhjavaweb.dao;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.MapperUsers;
import com.laptrinhjavaweb.entity.Users;

@Repository
public class UsersDao extends BaseDao{
	public int AddAccount(Users user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO users ");
		sql.append("( ");
		sql.append("	user_code, ");
		sql.append("	email, ");
		sql.append("	password, ");
		sql.append("	name ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	'"+user.getUser_code()+"', ");
		sql.append("	'"+user.getEmail()+"', ");
		sql.append("	'"+user.getPassword()+"', ");
		sql.append("	'"+user.getName()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	};
	
	public Users GetUserByAcc(Users user) {
		String sql = "SELECT * FROM users WHERE email = '"+user.getEmail()+"';";
		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return result;
	};
}
