package com.laptrinhjavaweb.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dao.ProductDao;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller
public class HomeController extends BaseController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	AdminServiceImpl adminService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("products", homeService.findAllProducts());
		mav.addObject("departments", adminService.findAll());
		mav.addObject("trademarks",homeService.GetDataTradeMark());
		return mav;
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public String DescriptionProduct1(@PathVariable String code) {
		Departments departments = adminService.findSlugNameByCode(code);
		return "redirect:/sanpham/"+departments.getSlug_name()+"/"+code;
	}
	
	@RequestMapping(value = "sanpham/{slug_name}/{code}", method = RequestMethod.GET)
	public String ShowDescriptionProduct(@PathVariable String code, @PathVariable String slug_name, Model m) {
		DescriptionProduct desProduct= adminService.findProductDescription(code);
		Products products = homeService.findByCode(code);
		m.addAttribute("products",products);
		m.addAttribute("desProduct",desProduct);
		return "web/descriptionproduct";
	}
}
