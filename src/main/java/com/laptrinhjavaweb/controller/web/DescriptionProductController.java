package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller
public class DescriptionProductController {
	@Autowired
	HomeServiceImpl homeService;

	@RequestMapping(value = "/sanpham", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/descriptionproduct");
		return mav;
	}
}
