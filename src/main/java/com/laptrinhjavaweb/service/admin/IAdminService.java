package com.laptrinhjavaweb.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.DiscountCode;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Trademarks;
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
	@Autowired
	public List<Trademarks> findAllTradeMarks();
	@Autowired
	public int createOneTradeMark(Trademarks t);
	@Autowired
	public int deleteOndeTrademark(int id);
	@Autowired
	public int updateOneTrademark(Trademarks t);
	@Autowired
	public Trademarks findByIdTrademark(int id);
	@Autowired
	public List<DiscountCode> findAllDiscountCode();
	@Autowired
	public int createOneDiscountCode(DiscountCode d);
	@Autowired
	public int delteOneDiscountCode(int id);
	@Autowired
	public DiscountCode findByIdDiscountCode(int id);
	@Autowired
	public int updateOneDiscountCode(DiscountCode d);
	@Autowired
	public int checkDiscountCode(String code);
	@Autowired
	public DiscountCode findByCode(String code);
}
