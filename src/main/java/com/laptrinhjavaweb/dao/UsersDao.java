package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Bills;
import com.laptrinhjavaweb.entity.MapperUsers;
import com.laptrinhjavaweb.entity.Users;

@Repository
public class UsersDao extends BaseDao{
	public int AddAccount(Users user) {
		StringBuffer  sql = new StringBuffer();
		user.setIs_admin(0);
		sql.append("INSERT INTO users ");
		sql.append("( ");
		sql.append("	user_code, ");
		sql.append("	email, ");
		sql.append("	password, ");
		sql.append("	name, ");
		sql.append("	is_admin ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	'"+user.getUser_code()+"', ");
		sql.append("	'"+user.getEmail()+"', ");
		sql.append("	'"+user.getPassword()+"', ");
		sql.append("	'"+user.getName()+"', ");
		sql.append("	'"+user.getIs_admin()+"' ");
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
	
	public List<Users> findAllUser() {
		List<Users> list = new ArrayList<Users>();
		String sql = "select * from users where is_admin = 0";
		list = _jdbcTemplate.query(sql, new MapperUsers());
		return list;
	}
	
	public List<Users> findUserByUserCode(String user_code) {
		String sql = "SELECT * FROM users where user_code = ?";
		List<Users> user = _jdbcTemplate.query(sql, new Object[]{user_code}, new BeanPropertyRowMapper<>(Users.class));
	    if (user.isEmpty()) {
	        return null;
	    } else {
	        return user;
	    }
	}
	
	public int updateAdmin(String user_code) {
		String sql = "UPDATE users set is_admin = 1 WHERE user_code = ?";
		return _jdbcTemplate.update(sql, user_code);
	}
}
