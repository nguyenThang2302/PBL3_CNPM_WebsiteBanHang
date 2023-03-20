package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.MapperDepartments;

public class DepartmentDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Departments> findAll() {
		List<Departments> list = new ArrayList<Departments>();
		String sql = "select * from departments";
		list = _jdbcTemplate.query(sql, new MapperDepartments());
		return list;
	}
}
