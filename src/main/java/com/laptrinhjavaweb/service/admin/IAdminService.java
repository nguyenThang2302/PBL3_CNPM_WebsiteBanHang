package com.laptrinhjavaweb.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.Products;
@Service
public interface IAdminService {
	@Autowired
	List<Departments> findAll();
	@Autowired
	public Departments findBySlugName(String slug_name);
	@Autowired
	public Departments findSlugNameByCode(String code);
	@Autowired
	public DescriptionProduct findProductDescription(String product_code);
	@Autowired
	public int updateDescritionProduct(DescriptionProduct d);
}
