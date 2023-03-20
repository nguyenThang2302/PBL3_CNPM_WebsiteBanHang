package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@Autowired
	HomeServiceImpl homeService;

	@RequestMapping(value = "/quan-ly", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/admin");
		return mav;
	}
}
