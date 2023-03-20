package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.MapperProducts;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class ProductDao {

	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<Products> GetDataSilde() {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products";
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}

	public int deleteOne(int id) {
		String sql = "delete from products where id = " + id + "";
		return _jdbcTemplate.update(sql);
	}

	public int createOne(Products p) {
		String sql = "INSERT INTO products (name, image, price) VALUES (?, ?, ?)";
        return _jdbcTemplate.update(sql, p.getName(), p.getImage(), p.getPrice());
	}
	
	public int updateOne(Products p) {
		String sql = "UPDATE products set name = ?, image = ?, price = ? where id = ?";
		return _jdbcTemplate.update(sql, p.getName(), p.getImage(), p.getPrice(), p.getId());
	}
	
	public Products findById(int id) {
		List<Products> list = new ArrayList<Products>();
		String sql="select * from products where id=?";    
			 return _jdbcTemplate.queryForObject(sql, new Object[]{id},new
			 BeanPropertyRowMapper<Products>(Products.class));
			 
	}
	public int updateDescriptionProduct(Products p) {
		String sql = "update products set brand = ?, description = ?, information = ?, salient = ?, color = ?, status = ? where id = ?";
		return _jdbcTemplate.update(sql, p.getBrand(), p.getDescription(), p.getInformation(), p.getSalient(), p.getColor(), p.getStatus(), p.getId());
	}
}
