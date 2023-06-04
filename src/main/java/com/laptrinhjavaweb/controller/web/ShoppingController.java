package com.laptrinhjavaweb.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		mav.addObject("trademarks",homeService.GetDataTradeMark());
		mav.addObject("top_products", productDescriptionService.findAllProductTop(slug_name));
		mav.addObject("new_products", productDescriptionService.findAllProductsNew(slug_name));
		if (departmentsSlugName.getSlug_name().equals("tat-ca-san-pham")) {
			mav.addObject("products", homeService.findAllProducts());
		} else {
			mav.addObject("products", homeService.findByDepartmentId(departmentsSlugName.getId()));
		}
		return mav;
	}
	
	@GetMapping("/danh-muc/{slug_name}")
	public @ResponseBody List<Products> MapperProducts(@PathVariable String slug_name) {
		List<Products> products = null;
		if (slug_name.equals("tat-ca-san-pham")) {
			products = homeService.findAllProducts();
		} else {
			Departments departmentsSlugName  = adminService.findBySlugName(slug_name);
		    products = homeService.findByDepartmentId(departmentsSlugName.getId());
		}
	    return products;
	}
	
	@GetMapping("/danh-muc-san-pham/{slug_name}/{brand}")
	public @ResponseBody List<Products> findProductsByBrand(@PathVariable String brand, @PathVariable String slug_name) {
		List<Products> products = homeService.findProductWithDepartmentAndBrand(brand, slug_name);
		return products;
	}
	
	@GetMapping("/danh-muc-san-pham/{slug_name}/{fromPrice}/{toPrice}")
	public @ResponseBody List<Products> findProductsByAroundPrice(@PathVariable String slug_name, @PathVariable double fromPrice, @PathVariable double toPrice) {
		List<Products> products = homeService.findProductWithAroundPrice(slug_name, fromPrice, toPrice);
		return products;
	}
	
	@GetMapping("/danh-muc-san-pham/{slug_name}/color/{color}")
	public @ResponseBody List<Products> findProductsByColor(@PathVariable String color, @PathVariable String slug_name) {
		String newColor = "";
		if (color.equals("white")) {
			newColor = "Trắng";
		} else if (color.equals("yellow")) {
			newColor = "Vàng";
		} else if (color.equals("red")) {
			newColor = "Đỏ";
		} else if (color.equals("blue")) {
			newColor = "Xanh biển";
		} else if (color.equals("black")) {
			newColor = "Đen";
		} else {
			newColor = "Xanh lá";
		}
		List<Products> products = homeService.findProductWithDepartmentAndColor(newColor, slug_name);
		return products;
	}
}
