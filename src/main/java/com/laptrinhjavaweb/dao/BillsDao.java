package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Bills;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.MapperBills;

@Repository
public class BillsDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createOneBill(Bills b) {
		String code = generateOrderCode();
		b.setCode(code);
		String sql = "INSERT INTO bills (code, user_code, phone, address, email, quantity, total_price, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		return _jdbcTemplate.update(sql, b.getCode(), b.getUser_code(), b.getPhone(), b.getAddress(), b.getEmail(), b.getQuantity(), b.getTotal_price(), b.getNote());
	}
	
	public String generateOrderCode() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
	
	public String getLastBillCode() {
		String sql = "select code from bills where id = (select MAX(id) from bills)";
		return _jdbcTemplate.queryForObject(sql.toString(), new Object[]{}, String.class);
	}
	
	public List<Bills> findAllBillsByUserCode(String user_code) {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "select * from bills where user_code = ?";
		list = _jdbcTemplate.query(sql, new MapperBills(), user_code);
		return list;
	}
}
