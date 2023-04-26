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
		b.setStatus("Chờ xác nhận");
		String sql = "INSERT INTO bills (code, name, user_code, phone, address, email, quantity, total_price, note, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return _jdbcTemplate.update(sql, b.getCode(), b.getName(), b.getUser_code(), b.getPhone(), b.getAddress(), b.getEmail(), b.getQuantity(), b.getTotal_price(), b.getNote(), b.getStatus());
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
		String sql = "select * from bills where user_code = ? order by created_at DESC";
		list = _jdbcTemplate.query(sql, new MapperBills(), user_code);
		return list;
	}
	
	public Bills findBillsByCode(String code) {
		String sql = "select * from bills where code = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{code},new
				 BeanPropertyRowMapper<Bills>(Bills.class));
	}
	
	public List<Bills> findAllBillsUnconfimred() {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "select * from bills where status = 'Chờ xác nhận' order by created_at ASC";
		list = _jdbcTemplate.query(sql, new MapperBills());
		return list;
	}
	
	public List<Bills> findAllBillsConfimred() {
		List<Bills> list = new ArrayList<Bills>();
		String sql = "select * from bills where status = 'Đã xác nhận' order by created_at ASC";
		list = _jdbcTemplate.query(sql, new MapperBills());
		return list;
	}
	
	public int updateStatusOrder(String code) {
		String sql = "UPDATE bills set status = 'Đã xác nhận' where code = ?";
		return _jdbcTemplate.update(sql, code);
	}
	
}
