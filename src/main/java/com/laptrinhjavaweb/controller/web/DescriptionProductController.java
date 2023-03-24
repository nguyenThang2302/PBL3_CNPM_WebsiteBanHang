package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller
public class DescriptionProductController {
	@Autowired
	HomeServiceImpl homeService;

	/*
	 * @RequestMapping(value = "/sanpham", method = RequestMethod.GET) public
	 * ModelAndView homePage() { ModelAndView mav = new
	 * ModelAndView("web/descriptionproduct"); mav.addObject("products",
	 * homeService.getProductById(4)); return mav; }
	 */

	@RequestMapping(value = "/sanpham/{id}", method = RequestMethod.GET)
	public ModelAndView findById(@PathVariable int id, Model m) {
		ModelAndView mav = new ModelAndView("web/descriptionproduct");
		Products desProducts = homeService.findById(id);
		m.addAttribute("desProducts", desProducts);
		mav.addObject("relateProducts", homeService.GetDataSilde());
		return mav;
	}
}
