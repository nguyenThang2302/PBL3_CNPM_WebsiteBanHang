package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
