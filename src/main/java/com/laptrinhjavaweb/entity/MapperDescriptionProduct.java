package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperDescriptionProduct implements org.springframework.jdbc.core.RowMapper<DescriptionProduct> {
	public DescriptionProduct mapRow(ResultSet res, int rowNum)  throws SQLException {
		DescriptionProduct sliders = new DescriptionProduct();
		sliders.setId(res.getInt("id"));
		sliders.setProduct_code(res.getString("product_code"));
		sliders.setVideo_url(res.getString("video_url"));
		sliders.setDes_image1(res.getString("des_image1"));
		sliders.setDes_image2(res.getString("des_image2"));
		sliders.setDes_image3(res.getString("des_image3"));
		sliders.setDes_image4(res.getString("des_image4"));
		sliders.setBrand(res.getString("brand"));
		sliders.setDescription(res.getString("description"));
		sliders.setInformation(res.getString("information"));
		sliders.setSalient(res.getString("salient"));
		sliders.setColor(res.getString("color"));
		sliders.setStatus(res.getString("status"));
		return sliders;
	}
}
