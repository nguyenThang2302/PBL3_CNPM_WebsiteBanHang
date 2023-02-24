package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "shoppingControllerOfWeb")
public class ShoppingController {
	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public ModelAndView shoppingPage() {
		ModelAndView mav = new ModelAndView("web/shopping");
		return mav;
	}
}
