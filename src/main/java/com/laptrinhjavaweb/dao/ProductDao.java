package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.MapperProducts;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class ProductDao {

	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<Products> GetDataSilde(int departmentId) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products where department_id = ?";
		list = _jdbcTemplate.query(sql, new MapperProducts(), departmentId);
		return list;
	}
	
	public List<Products> findAllProducts() {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products";
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}

	public int deleteOne(String code) {
		String sqlDeleteDesc = "DELETE FROM product_descriptions WHERE product_code = ?";
	    _jdbcTemplate.update(sqlDeleteDesc, code);
	    
	    String sqlDeleteProduct = "DELETE FROM products WHERE code = ?";
	    return _jdbcTemplate.update(sqlDeleteProduct, code);
	}

	public int createOne(Products p, int department_id) {
		String sql = "INSERT INTO products (code, department_id, name, image, price) VALUES (?, ?, ?, ?, ?)";
	    int result = _jdbcTemplate.update(sql, p.getCode(), department_id, p.getName(), p.getImage(), p.getPrice());
	    
	    String descriptionSql = "INSERT INTO product_descriptions (product_code) VALUES (?)";
	    _jdbcTemplate.update(descriptionSql, p.getCode());
	    
	    return result;
	}
	
	public int updateOne(Products p) {
		String sql = "UPDATE products set name = ?, image = ?, price = ? where code = ?";
		return _jdbcTemplate.update(sql, p.getName(), p.getImage(), p.getPrice(), p.getCode());
	}
	
	public Products findById(int id) {
		List<Products> list = new ArrayList<Products>();
		String sql="select * from products where id=?";    
			 return _jdbcTemplate.queryForObject(sql, new Object[]{id},new
			 BeanPropertyRowMapper<Products>(Products.class));
	}
	
	public Products findByCode(String code) {
		String sql = "select * from products where code=?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{code},new
				 BeanPropertyRowMapper<Products>(Products.class));
	}
	
	public List<Products> getProductById(int id) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products where id = "+id+"" ;
		list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
	
	public List<Products>  findByDepartmentId(int id) {
		List<Products> list = new ArrayList<Products>();
		String sql = "select * from products where department_id = ?";
		list = _jdbcTemplate.query(sql, new MapperProducts(), id);
		return list;
	}
	
	public Products findProductById(int id) {
		String sql = "select * from products where id = "+id+"";
		Products product = _jdbcTemplate.queryForObject(sql, new MapperProducts());
		return product;
	}
}
