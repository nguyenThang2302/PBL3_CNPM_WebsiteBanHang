package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.FavouriteProduct;
import com.laptrinhjavaweb.entity.Favourites;
import com.laptrinhjavaweb.entity.MapperFavouites;

@Repository
public class FavouriteProductDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createOneFavouriteProduct(FavouriteProduct f) {
		String sql = "INSERT INTO favourite_products (product_code, department_id) VALUES (?, ?)";
		return _jdbcTemplate.update(sql, f.getProduct_code(), f.getDepartment_id());
	}
	
	public List<Favourites> findAllProductFavourite() {
		List<Favourites> list = new ArrayList<Favourites>();
		String sql = "select distinct name, price, code, count(code) AS count_favourite, image from products inner join favourite_products on products.code = favourite_products.product_code group by name, price, code order by count_favourite DESC limit 20";
		list = _jdbcTemplate.query(sql, new MapperFavouites());
		return list;
	}
}
