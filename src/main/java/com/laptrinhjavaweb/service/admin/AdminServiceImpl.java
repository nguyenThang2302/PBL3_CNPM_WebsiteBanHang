package com.laptrinhjavaweb.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.DepartmentDao;
import com.laptrinhjavaweb.dao.DescriptionProductDao;
import com.laptrinhjavaweb.dao.ProductDao;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.Products;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private DescriptionProductDao desProductDao;
	@Override
	public List<Departments> findAll() {
		return departmentDao.findAll();
	}
	@Override
	public Departments findBySlugName(String slug_name) {
		return departmentDao.findBySlugName(slug_name);
	}
	@Override
	public Departments findSlugNameByCode(String code) {
		return departmentDao.findSlugNameByCode(code);
	}
	@Override
	public DescriptionProduct findProductDescription(String product_code) {
		return desProductDao.findProductDescription(product_code);
	}
	@Override
	public int updateDescritionProduct(DescriptionProduct d) {
		return desProductDao.updateDescritionProduct(d);
	}
}
