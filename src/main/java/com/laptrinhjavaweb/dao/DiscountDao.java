package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.DiscountCodes;
import com.laptrinhjavaweb.entity.MapperDiscountCodes;
import com.laptrinhjavaweb.entity.MapperProducts;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class DiscountDao {

	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<DiscountCodes> GetDataSilde() {
		List<DiscountCodes> list = new ArrayList<DiscountCodes>();
		String sql = "select * from discountcodes";
		list = _jdbcTemplate.query(sql, new MapperDiscountCodes());
		return list;
	}

	public int deleteOne(int id) {
		String sql = "delete from discountcodes where id = " + id + "";
		return _jdbcTemplate.update(sql);
	}

	public int createOne(DiscountCodes d) {
		String sql = "INSERT INTO discountcodes (id, discount_name, discount_code, discount_percent, amount, valid_date) VALUES (?, ?, ?, ?, ?, ?)";
        return _jdbcTemplate.update(sql, d.getId(), d.getDiscount_name(), d.getDiscount_code(), d.getDiscount_percent(),d.getAmount(), d.getValid_date());
	}
	
	public int updateOne(DiscountCodes d) {
		String sql = "UPDATE discountcodes set discount_name = ?, discount_code?, discount_percent = ?, amount = ?, valid_date = ? where id = ?";
		return _jdbcTemplate.update(sql, d.getDiscount_name(), d.getDiscount_code(), d.getDiscount_percent(), d.getAmount(), d.getAmount(), d.getId());
	}
	
	public DiscountCodes findById(int id) {
		List<DiscountCodes> list = new ArrayList<DiscountCodes>();
		String sql="select * from dicountcodes where id=?";    
			 return _jdbcTemplate.queryForObject(sql, new Object[]{id},new
			 BeanPropertyRowMapper<DiscountCodes>(DiscountCodes.class));
			 
	}
}

