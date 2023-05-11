package com.laptrinhjavaweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.ContactMessage;

@Repository
public class ContactMessageDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createOneMessage(ContactMessage c) {
		String sql = "INSERT INTO contact_messages (name, email, message, phone) VALUES (?, ?, ?, ?)";
		return _jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getMessage(), c.getPhone());
	}
}
