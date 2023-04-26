package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BillNotification;
import com.laptrinhjavaweb.entity.Bills;
import com.laptrinhjavaweb.entity.MapperBillNotification;
import com.laptrinhjavaweb.entity.MapperBills;

@Repository
public class BillNotificationDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createBillNotification(BillNotification bn) {
		String sql = "INSERT INTO bills_notification (bill_code) VALUES (?)";
		return _jdbcTemplate.update(sql, bn.getBill_code());
	}
	
	public List<BillNotification> findAllBillNotification() {
		List<BillNotification> list = new ArrayList<BillNotification>();
		String sql = "SELECT * from bills_notification";
		list = _jdbcTemplate.query(sql, new MapperBillNotification());
		return list;
	}
	
	public int CountNotification() {
		String sql = "SELECT count(id) as count_notification from bills_notification";
	    return _jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public int deleteNotificationByCode(String bill_code) {
		String sql = "delete from bills_notification where bill_code = ?";
		return _jdbcTemplate.update(sql, bill_code);
	}
	
	public Bills findBillUnconfirmedByCode(String code) {
		String sql = "select * from bills where code = ? and status = 'Chờ xác nhận'";
		List<Bills> bills = _jdbcTemplate.query(sql, new Object[]{code}, new BeanPropertyRowMapper<>(Bills.class));
	    if (bills.isEmpty()) {
	        return null;
	    } else {
	        return bills.get(0);
	    }
	}
	
	public Bills findBillComfirmedByCode(String code) {
		String sql = "select * from bills where code = ? and status = 'Đã xác nhận'";
		List<Bills> bills = _jdbcTemplate.query(sql, new Object[]{code}, new BeanPropertyRowMapper<>(Bills.class));
	    if (bills.isEmpty()) {
	        return null;
	    } else {
	        return bills.get(0);
	    }
	}
}
