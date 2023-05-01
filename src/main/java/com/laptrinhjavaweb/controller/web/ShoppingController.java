package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.FavouriteProductServiceImpl;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;
import com.laptrinhjavaweb.service.web.ProductDescriptionServiceImpl;

@Controller(value = "shoppingControllerOfWeb")
public class ShoppingController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	FavouriteProductServiceImpl favouriteProductService;
	@Autowired
	ProductDescriptionServiceImpl productDescriptionService;
	
	@RequestMapping(value = "/danh-muc-san-pham/{slug_name}", method = RequestMethod.GET)
	public ModelAndView shoppingProduct(@PathVariable String slug_name, Model m) {
		ModelAndView mav = new ModelAndView("web/shopping");
		Departments departmentsSlugName  = adminService.findBySlugName(slug_name);
		m.addAttribute("departmentsSlugName", departmentsSlugName);
		mav.addObject("departments", adminService.findAll());
		mav.addObject("top_products", productDescriptionService.findAllProductTop(slug_name));
		mav.addObject("new_products", productDescriptionService.findAllProductsNew(slug_name));
		mav.addObject("products", homeService.findByDepartmentId(departmentsSlugName.getId()));
		return mav;
	}
}
