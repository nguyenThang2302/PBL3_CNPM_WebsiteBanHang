package com.laptrinhjavaweb.controller.web;

import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.entity.Bills;
import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.AccountServiceImpl;
import com.laptrinhjavaweb.service.web.BillsServiceImpl;
import com.laptrinhjavaweb.service.web.CartServiceImpl;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller(value = "checkoutControllerOfWeb")
public class CheckoutController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView checkoutPage(HttpServletRequest request, HttpSession session, HttpServletResponse respone, @RequestParam("secret_key") String secretKey) {
		ModelAndView mav = new ModelAndView("web/checkout");
		mav.addObject("departments", adminService.findAll());
	    Bills bills = new Bills();
	    Users currentUser = (Users) session.getAttribute("LoginInfor");
	    HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (currentUser != null) { 
		 bills.setUser_code(currentUser.getUser_code());
		 bills.setName(currentUser.getName());
		 bills.setAddress(currentUser.getAddress());
		 bills.setPhone(currentUser.getPhone()); 
		 bills.setEmail(currentUser.getEmail());
		}
	    mav.addObject("bills", bills);
	    session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
	    session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		return mav;
	}
	
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.POST)
	public String checkOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bills) {
		Random random = new Random();
		int randomNumber = random.nextInt(90000) + 10000;
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser == null) {
			bills.setUser_code("GUEST" + randomNumber);
			accountService.InsertGuest(bills.getUser_code());
		}
		if (billsService.createOneBill(bills) > 0) {
			HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
			billsService.AddBillDetail(cart);
		}
		session.removeAttribute("Cart");
		session.setAttribute("TotalPrice", 0);
	    session.setAttribute("TotalQuantity", 0);
		return "redirect:gio-hang";
	}
}
