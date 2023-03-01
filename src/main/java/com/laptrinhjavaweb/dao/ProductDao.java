package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
