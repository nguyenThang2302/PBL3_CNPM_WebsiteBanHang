package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.MapperDepartments;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class DepartmentDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Departments> findAll() {
		List<Departments> list = new ArrayList<Departments>();
		String sql = "select * from departments";
		list = _jdbcTemplate.query(sql, new MapperDepartments());
		return list;
	}
	
	public Departments findBySlugName(String slug_name) {
		String sql = "select * from departments where slug_name = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{slug_name},new
				 BeanPropertyRowMapper<Departments>(Departments.class));
	}
	
	public Departments findSlugNameByCode(String code) {
		String sql = "select slug_name from departments inner join products on departments.id = products.department_id\n"
				+ "where products.code = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{code},new
				 BeanPropertyRowMapper<Departments>(Departments.class));
	}
}
