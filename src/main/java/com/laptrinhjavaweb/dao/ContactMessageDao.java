package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.ContactMessage;
import com.laptrinhjavaweb.entity.MapperContactMessage;

@Repository
public class ContactMessageDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createOneMessage(ContactMessage c) {
		c.setStatus("Chưa xem");
		String sql = "INSERT INTO contact_messages (name, email, message, phone, status) VALUES (?, ?, ?, ?, ?)";
		return _jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getMessage(), c.getPhone(), c.getStatus());
	}
	
	public List<ContactMessage> findAllMessageNotSeen() {
		List<ContactMessage> list = new ArrayList<ContactMessage>();
		String sql = "select * from contact_messages where status = 'Chưa xem' order by created_at ASC";
		list = _jdbcTemplate.query(sql, new MapperContactMessage());
		return list;
	}
	
	public List<ContactMessage> findAllMessageSeened() {
		List<ContactMessage> list = new ArrayList<ContactMessage>();
		String sql = "select * from contact_messages where status = 'Đã xem' order by created_at ASC";
		list = _jdbcTemplate.query(sql, new MapperContactMessage());
		return list;
	}
	
	public int updateStatusMessage(int id) {
		String sql = "UPDATE contact_messages SET status = 'Đã xem' where id = ?";
		return _jdbcTemplate.update(sql, id);
	}
}
