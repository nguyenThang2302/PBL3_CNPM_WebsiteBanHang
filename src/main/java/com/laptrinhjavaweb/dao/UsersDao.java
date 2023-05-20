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
	
	public int InsertGuest(String guest_code) {
		String sql = "INSERT INTO users (user_code) VALUES (?)";
		return _jdbcTemplate.update(sql, guest_code);
	}
	
	public Users getUserByAcc(Users user) {
	    String sql = "SELECT * FROM users WHERE email = ?";
	    Users result = _jdbcTemplate.queryForObject(sql, new Object[]{user.getEmail()}, new MapperUsers());
	    return result;
	};
	
	public Users getUserByUserCode(String user_code) {
	    String sql = "SELECT * FROM users WHERE user_code = ?";
	    Users result = _jdbcTemplate.queryForObject(sql, new Object[]{user_code}, new MapperUsers());
	    return result;
	};
	
	public boolean isUserExists(String email) {
	    String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
	    int count = _jdbcTemplate.queryForObject(sql, new Object[] {email}, Integer.class);
	    return count > 0;
	}
	
	public void updateUser(Users user) {
	    String sql = "UPDATE users SET name=?, email=?, phone=?, address=? WHERE user_code=?";
	    _jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhone(), user.getAddress(), user.getUser_code());
	}
	

	public void updateUser_passWord(Users user) {
	    String sql = "UPDATE users SET password =? WHERE user_code=?";
	    _jdbcTemplate.update(sql, user.getPassword(), user.getUser_code());
	}
}
