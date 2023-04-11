package com.laptrinhjavaweb.controller.web;

import java.net.http.HttpRequest;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.CartServiceImpl;

@Controller(value = "cartControllerOfWeb")
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		ModelAndView mav = new ModelAndView("web/cart");
		return mav;
	}
	
/*	@RequestMapping(value = "them-vao-gio-hang/{code}/{quantity}", method = RequestMethod.GET)
	public String mapLinkAddCartWithQuantity(@PathVariable String code, Model m, @PathVariable int quantity) {
		Departments departments = adminService.findSlugNameByCode(code);
		m.addAttribute("departments", departments);
		return "redirect:/them-vao-gio-hang/"+departments.getSlug_name()+"/"+code+"/"+quantity;
	}
*/	
	@RequestMapping(value = "them-vao-gio-hang/{slug_name}/{code}/{quantity}")
	public String AddCartWithQuantity(HttpServletRequest request, HttpSession session, @PathVariable String code, @PathVariable String slug_name, @PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCartWithQuantity(code, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer"); 
	}
	
	@RequestMapping(value = "them-vao-gio-hang/{slug_name}/{code}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable String code, @PathVariable String slug_name) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCart(code, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer"); 
	}
	
	@RequestMapping(value = "them-vao-gio-hang/{code}", method = RequestMethod.GET)
	public String mapLinkAddcart(@PathVariable String code, Model m) {
		Departments departments = adminService.findSlugNameByCode(code);
		m.addAttribute("departments", departments);
		return "redirect:/them-vao-gio-hang/"+departments.getSlug_name()+"/"+code;
	}
	
	@RequestMapping(value = "xoa-khoi-gio-hang/{code}", method = RequestMethod.GET)
	public String mapLinkDeletecart(@PathVariable String code, Model m) {
		Departments departments = adminService.findSlugNameByCode(code);
		m.addAttribute("departments", departments);
		return "redirect:/xoa-khoi-gio-hang/"+departments.getSlug_name()+"/"+code;
	}
	
	@RequestMapping(value = "xoa-khoi-gio-hang/{slug_name}/{code}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable String code, @PathVariable String slug_name) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.DeleteCart(code, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer"); 
	}
	
	@RequestMapping(value = "cap-nhat-gio-hang/{code}/{quantity}", method = RequestMethod.GET)
	public String mapLinkEditcart(@PathVariable String code, Model m, @PathVariable int quantity) {
		Departments departments = adminService.findSlugNameByCode(code);
		m.addAttribute("departments", departments);
		return "redirect:/cap-nhat-gio-hang/"+departments.getSlug_name()+"/" + code + "/" + quantity;
	}
	
	@RequestMapping(value = "cap-nhat-gio-hang/{slug_name}/{code}/{quantity}")
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable String code, @PathVariable String slug_name, @PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.EditCart(code, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer"); 
	}
}
