package com.laptrinhjavaweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.MessageNotification;

@Repository
public class MessageNotificationDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createMessageNotificaton(MessageNotification m) {
		String sql = "INSERT INTO messages_notification (contact_id) VALUES (?)";
		return _jdbcTemplate.update(sql, m.getContact_id());
	}
	
	public int getLastContactId() {
		String sql = "select id from contact_messages where id = (select MAX(id) from contact_messages)";
		return _jdbcTemplate.queryForObject(sql.toString(), new Object[]{}, Integer.class);
	}
	
	public int deleteMessageNotification(int contact_id) {
		String sql = "delete from messages_notification where contact_id = ?";
		return _jdbcTemplate.update(sql, contact_id);
	}
	
	public int CountNotification() {
		String sql = "SELECT count(id) as count_notification from messages_notification";
	    return _jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
