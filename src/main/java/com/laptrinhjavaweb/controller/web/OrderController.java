package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.BillsServiceImpl;

@Controller(value = "orderContronlerrOfWeb")
public class OrderController {
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	
	@RequestMapping(value = "/don-hang", method = RequestMethod.GET) 
	public ModelAndView orderPage(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("web/order");
		mav.addObject("departments", adminService.findAll());
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null) {
			String user_code = currentUser.getUser_code();
			mav.addObject("orders", billsService.findAllBillsByUserCode(user_code));
		}
		return mav;
	}
}
