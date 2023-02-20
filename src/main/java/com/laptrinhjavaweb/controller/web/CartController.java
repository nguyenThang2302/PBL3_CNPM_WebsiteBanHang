package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "cartControllerOfWeb")
public class CartController {
	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		ModelAndView mav = new ModelAndView("web/cart");
		return mav;
	}
}
