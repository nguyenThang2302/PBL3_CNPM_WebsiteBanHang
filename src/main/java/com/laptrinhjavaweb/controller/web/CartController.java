package com.laptrinhjavaweb.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DiscountCode;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.CartServiceImpl;

@Controller(value = "cartControllerOfWeb")
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView registerPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("web/cart");
		mav.addObject("discountCodes", adminService.findAllDiscountCode());
		mav.addObject("departments", adminService.findAll());
		session.setAttribute("PercentDiscount", 0);
		return mav;
	}
	
	@RequestMapping(value = "/check/discount/{code}", method = RequestMethod.GET)
	public @ResponseBody String checkDiscount(HttpServletRequest request, HttpSession session, @PathVariable String code) {
		DiscountCode discountcode = adminService.findByCode(code);
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		session.setAttribute("PercentDiscount", discountcode.getPercent());
		Map<String, Object> result = new HashMap<>();
		double tempTotalPrice = cartService.TotalPrice(cart);
		result.put("TotalPrice", cartService.TotalPrice(cart));
		result.put("TotalPriceDiscount", tempTotalPrice * (1- discountcode.getPercent()));
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(result);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json; 
	}
	
	@RequestMapping(value = "them-vao-gio-hang/{slug_name}/{code}/{quantity}")
	public @ResponseBody String AddCartWithQuantity(HttpServletRequest request, HttpSession session, @PathVariable String code, @PathVariable String slug_name, @PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCart(code, cart);
		cart = cartService.EditCart(code, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		Map<String, Object> result = new HashMap<>();
		result.put("TotalQuantity", cartService.TotalQuantity(cart));
		result.put("TotalPrice", cartService.TotalPrice(cart));
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(result);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value = "them-vao-gio-hang/{slug_name}/{code}")
	public @ResponseBody String AddCart(HttpServletRequest request, HttpSession session, @PathVariable String code, @PathVariable String slug_name) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCart(code, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		Map<String, Object> result = new HashMap<>();
		result.put("Name", cart.get(code).getProduct().getName());
		result.put("Price", cart.get(code).getProduct().getPrice());
		result.put("Quantity", 1);
		result.put("TotalPriceProduct", cart.get(code).getTotalPrice());
		result.put("TotalQuantity", cartService.TotalQuantity(cart));
		result.put("TotalPrice", cartService.TotalPrice(cart));
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(result);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
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
	public @ResponseBody String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable String code, @PathVariable String slug_name) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		Map<String, Object> result = new HashMap<>();
		result.put("deletedCode", cart.get(code).getProduct().getCode());
		cart = cartService.DeleteCart(code, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		result.put("TotalQuantity", cartService.TotalQuantity(cart));
		result.put("TotalPrice", cartService.TotalPrice(cart));
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(result);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value = "cap-nhat-gio-hang/{code}/{quantity}", method = RequestMethod.GET)
	public String mapLinkEditcart(@PathVariable String code, Model m, @PathVariable int quantity) {
		Departments departments = adminService.findSlugNameByCode(code);
		m.addAttribute("departments", departments);
		return "redirect:/cap-nhat-gio-hang/"+departments.getSlug_name()+"/" + code + "/" + quantity;
	}
	
	@RequestMapping(value = "cap-nhat-gio-hang/{slug_name}/{code}/{quantity}", method = RequestMethod.GET)
	public @ResponseBody String EditCart(HttpServletRequest request, HttpSession session, @PathVariable String code, @PathVariable String slug_name, @PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.EditCart(code, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		double updatePrice = cart.get(code).getTotalPrice();
		Map<String, Object> result = new HashMap<>();
		result.put("updatePrice", updatePrice);
		result.put("TotalQuantity", cartService.TotalQuantity(cart));
		result.put("TotalPrice", cartService.TotalPrice(cart));
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(result);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}

