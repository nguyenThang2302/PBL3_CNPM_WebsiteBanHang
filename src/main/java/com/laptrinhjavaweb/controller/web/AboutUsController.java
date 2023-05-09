package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.admin.AdminServiceImpl;

@Controller(value = "aboutUsControllerOfWeb")
public class AboutUsController {
	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping(value = "/about-us", method = RequestMethod.GET)
	public ModelAndView aboutPage() {
		ModelAndView mav = new ModelAndView("web/about");
		mav.addObject("departments", adminService.findAll());
		return mav;
	}
}
