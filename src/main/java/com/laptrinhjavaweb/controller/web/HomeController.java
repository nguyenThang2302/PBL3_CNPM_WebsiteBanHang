package com.laptrinhjavaweb.controller.web;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.dao.ProductDao;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;
import com.laptrinhjavaweb.service.web.ProductDescriptionServiceImpl;

@Controller
public class HomeController extends BaseController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	ProductDescriptionServiceImpl productDescriptionService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("products", homeService.findAllProducts());
		mav.addObject("departments", adminService.findAll());
		mav.addObject("trademarks",homeService.GetDataTradeMark());
		return mav;
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public String DescriptionProduct1(@PathVariable String code, Model m) {
		Departments departments = adminService.findSlugNameByCode(code);
		m.addAttribute("departments", departments);
		return "redirect:/sanpham/"+departments.getSlug_name()+"/"+code;
	}
	
	@RequestMapping(value = "sanpham/{slug_name}/{code}", method = RequestMethod.GET)
	public String ShowDescriptionProduct(@PathVariable String code, @PathVariable String slug_name, Model m) {
		Departments departmentsSlugName = adminService.findSlugNameByCode(code);
		DescriptionProduct desProduct= adminService.findProductDescription(code);
		Products products = homeService.findByCode(code);
		m.addAttribute("departments", adminService.findAll());
		m.addAttribute("products",products);
		m.addAttribute("desProduct",desProduct);
		m.addAttribute("departmentsSlugName", departmentsSlugName);
		m.addAttribute("related_products",productDescriptionService.findAllRelatedProduct(slug_name));
		return "web/descriptionproduct";
	}
	
	@GetMapping("/api/products")
	public @ResponseBody List<Products> APIProducts() {
	    List<Products> products = homeService.findAllProducts();
	    return products;
	}
}
