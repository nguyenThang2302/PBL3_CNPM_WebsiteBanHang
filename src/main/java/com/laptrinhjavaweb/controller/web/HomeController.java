package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dao.ProductDao;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller
public class HomeController {
	@Autowired
	HomeServiceImpl homeService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("products", homeService.GetDataSilde());
		mav.addObject("trademarks",homeService.GetDataTradeMark());
		return mav;
	}
}
