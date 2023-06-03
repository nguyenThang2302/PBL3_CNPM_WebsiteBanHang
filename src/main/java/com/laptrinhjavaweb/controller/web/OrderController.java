package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Bills;
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
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		ModelAndView mav = new ModelAndView("web/order");
		mav.addObject("departments", adminService.findAll());
		if (currentUser != null) {
			String user_code = currentUser.getUser_code();
			mav.addObject("orders", billsService.findAllBillsByUserCode(user_code));
			return mav;
		} else {
			return new ModelAndView("redirect:/khong-tim-thay-yeu-cau");
		}
	}
	
	@RequestMapping(value = "/chi-tiet-don-hang/{code}", method = RequestMethod.GET) 
	public ModelAndView detailOrder(@PathVariable String code, Model m, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("web/detailorder");
			m.addAttribute("bills", billsService.findBillsByCode(code));
			mav.addObject("billproduct", billsService.findProductInBillByCode(code));
			mav.addObject("departments", adminService.findAll());
			return mav;
		} else {
			return null;
		}
	}
}
