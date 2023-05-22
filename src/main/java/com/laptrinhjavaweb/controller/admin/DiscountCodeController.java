package com.laptrinhjavaweb.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.DiscountCode;
import com.laptrinhjavaweb.entity.Trademarks;
import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller(value = "discountCodeControllerOfAdmin")
public class DiscountCodeController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping(value = "/ma-giam-gia", method = RequestMethod.GET)
	public ModelAndView discountCodePage(HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/discountcode");
			mav.addObject("discountcodes", adminService.findAllDiscountCode());
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/ma-giam-gia/tao-moi", method = RequestMethod.GET)
	public ModelAndView discountCodeAdd(HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/createDiscountCode");
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/ma-giam-gia/add", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String discountCodeAddSave(@ModelAttribute("discountcode") DiscountCode discountcode) {
		adminService.createOneDiscountCode(discountcode);
		return "redirect:/ma-giam-gia";
	}
	
	@RequestMapping(value = "/ma-giam-gia/delete/{id}", method = RequestMethod.GET)
	public String discountCodeDelete(@PathVariable int id, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			adminService.delteOneDiscountCode(id);
			return "redirect:/ma-giam-gia";
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/ma-giam-gia/update/{id}", method = RequestMethod.GET)
	public String discountCodeUpdate(@PathVariable int id, Model m, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			DiscountCode discountcode = adminService.findByIdDiscountCode(id);
			m.addAttribute("discountcode", discountcode);
			return "admin/updateDiscountCode";
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/ma-giam-gia/update/save", method = RequestMethod.POST)
	public String discountCodeUpdateSave(@ModelAttribute("discountcode") DiscountCode discountcode) {
		adminService.updateOneDiscountCode(discountcode);
		return "redirect:/ma-giam-gia";
	}
}
