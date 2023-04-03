package com.laptrinhjavaweb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class DescriptionProductDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public DescriptionProduct findProductDescription(String product_code) {
		String sql = "select * from product_descriptions where product_code=?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{product_code},new
				 BeanPropertyRowMapper<DescriptionProduct>(DescriptionProduct.class));
	}
	
	public int updateDescritionProduct(DescriptionProduct d) {
		System.out.print(d.getProduct_code());
		String sql = "update product_descriptions set brand = ?, description = ?, information = ?, salient = ?,video_url = ?, des_image1 =?, des_image2 = ?, des_image3 = ?, des_image4 = ?, color = ?, status = ? where product_code = ?";
		return _jdbcTemplate.update(sql, d.getBrand(), d.getDescription(), d.getInformation(), d.getSalient(), d.getVideo_url(), d.getDes_image1(), d.getDes_image2(), d.getDes_image3(), d.getDes_image4() ,d.getColor(), d.getStatus(), d.getProduct_code());
	}
}
