package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.slugify.Slugify;
import com.laptrinhjavaweb.entity.DiscountCode;
import com.laptrinhjavaweb.entity.MapperDiscountCode;
import com.laptrinhjavaweb.entity.MapperProducts;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class DiscountCodeDao {
	
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<DiscountCode> findAllDiscountCode() {
		List<DiscountCode> list = new ArrayList<DiscountCode>();
		String sql = "select * from discount_codes";
		list = _jdbcTemplate.query(sql, new MapperDiscountCode());
		return list;
	}
	
	public int createOneDiscountCode(DiscountCode d) {
		Slugify slugify = new Slugify();
		String slug_name = slugify.slugify(d.getName());
		String sql = "INSERT INTO discount_codes(name, slug_name, code, percent, amount, valid_date) VALUES (?, ?, ?, ?, ? ,?)";
		return _jdbcTemplate.update(sql, d.getName(), slug_name, d.getCode(), d.getPercent(), d.getAmount(), d.getValid_date());
	}
	
	public int delteOneDiscountCode(int id) {
		String sql = "delete from discount_codes where id = ?";
		return _jdbcTemplate.update(sql, id);
	}
	
	public DiscountCode findByIdDiscountCode(int id) {
		List<DiscountCode> list = new ArrayList<DiscountCode>();
		String sql="select * from discount_codes where id=?";    
			 return _jdbcTemplate.queryForObject(sql, new Object[]{id},new
			 BeanPropertyRowMapper<DiscountCode>(DiscountCode.class));
	}
	
	public int updateOneDiscountCode(DiscountCode d) {
		Slugify slugify = new Slugify();
		String slug_name = slugify.slugify(d.getName());
		String sql = "UPDATE discount_codes set name = ?, slug_name = ?, code = ?, percent = ?, amount = ?, valid_date = ? where id = ?";
		return _jdbcTemplate.update(sql, d.getName(), slug_name, d.getCode(), d.getPercent(), d.getAmount(), d.getValid_date(), d.getId());
	}
 }
