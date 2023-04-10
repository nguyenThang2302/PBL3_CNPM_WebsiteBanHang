package com.laptrinhjavaweb.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.service.web.CartServiceImpl;

@Controller(value = "cartControllerOfWeb")
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	
	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		ModelAndView mav = new ModelAndView("web/cart");
		return mav;
	}
	
	@RequestMapping(value = "them-vao-gio-hang/{slug_name}/{code}")
	public String AddCart(HttpSession session, @PathVariable String code, @PathVariable String slug_name) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCart(code, cart);
		session.setAttribute("Cart", cart);
		return "redirect:/sanpham/" +slug_name+"/"+code;
	}
	
}
