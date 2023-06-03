package com.laptrinhjavaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "notFound404OfControllerAdmin")
public class NotFound404Controller {
	@RequestMapping(value = "/khong-tim-thay-yeu-cau", method = RequestMethod.GET)
	public ModelAndView notFoundPage() {
		ModelAndView mav = new ModelAndView("web/not_found_404");
		return mav;
	}
}
