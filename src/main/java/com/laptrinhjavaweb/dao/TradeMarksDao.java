package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.MapperProducts;
import com.laptrinhjavaweb.entity.MapperTrademarks;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Trademarks;

@Repository
public class TradeMarksDao {

	@Autowired
	public JdbcTemplate _jdbcTemplate;

	public List<Trademarks> GetDataTradeMark() {
		List<Trademarks> list = new ArrayList<Trademarks>();
		String sql = "select * from trademarks";
		list = _jdbcTemplate.query(sql, new MapperTrademarks());
		return list;
	}
	
	public List<Trademarks> findAllTradeMarks() {
		List<Trademarks> list = new ArrayList<Trademarks>();
		String sql = "select * from trademarks";
		list = _jdbcTemplate.query(sql, new MapperTrademarks());
		return list;
	}
	
	public int createOneTradeMark(Trademarks t) {
		String sql = "insert into trademarks (name, image, url) values (?, ?, ?)";
		return _jdbcTemplate.update(sql, t.getName(), t.getImage(), t.getUrl());
	}
	
	public int deleteOndeTrademark(int id) {
		String sql = "delete from trademarks where id = ?";
		return _jdbcTemplate.update(sql, id);
	}
	
	public int updateOneTrademark(Trademarks t) {
		String sql = "update trademarks set name = ?, image = ?, url = ? where id = ?";
		return _jdbcTemplate.update(sql, t.getName(), t.getImage(), t.getUrl(), t.getId());
	}
	
	public Trademarks findByIdTrademark(int id) {
		List<Trademarks> list = new ArrayList<Trademarks>();
		String sql = "select * from trademarks where id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{id},new
				 BeanPropertyRowMapper<Trademarks>(Trademarks.class));
	}
}
