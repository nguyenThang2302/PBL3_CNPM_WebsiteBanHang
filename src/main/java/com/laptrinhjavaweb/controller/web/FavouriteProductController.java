package com.laptrinhjavaweb.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.FavouriteProduct;
import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.FavouriteProductServiceImpl;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller(value = "favouriteProductControllerOfWeb")
public class FavouriteProductController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	FavouriteProductServiceImpl favouriteProductService;
	
	@RequestMapping(value = "/san-pham-yeu-thich", method = RequestMethod.GET)
	public ModelAndView favouriteProdictPage() {
		ModelAndView mav = new ModelAndView("web/favouriteproduct");
		mav.addObject("departments", adminService.findAll());
		mav.addObject("favourite_products", favouriteProductService.findAllProductFavourite());
		return mav;
	}
	
	@RequestMapping(value = "/san-pham-yeu-thich/{code}", method = RequestMethod.GET)
	public String mapperLinkFavouriteProduct(@PathVariable String code) {
		Departments departments = adminService.findSlugNameByCode(code);
		return "redirect:/san-pham-yeu-thich/"+departments.getSlug_name()+"/"+code;
	}
	
	@RequestMapping(value = "/san-pham-yeu-thich/{slug_name}/{code}", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String favouriteProduct(HttpServletRequest request, @PathVariable String slug_name, @PathVariable String code, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null) {
			Departments departments = adminService.findBySlugName(slug_name);
			FavouriteProduct f = new FavouriteProduct();
			f.setProduct_code(code);
			f.setDepartment_id(departments.getId());
			favouriteProductService.createOneFavouriteProduct(f);
			return "redirect:" + request.getHeader("Referer"); 
		} else {
			Map<String, Object> result = new HashMap<>();
			result.put("status", "no_login");
			ObjectMapper objectMapper = new ObjectMapper();
			String json = "";
			try {
				json = objectMapper.writeValueAsString(result);
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
			return json; 
		}
	}
}
