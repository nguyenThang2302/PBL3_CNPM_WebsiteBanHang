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

import com.laptrinhjavaweb.entity.Trademarks;
import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;

@Controller
public class TradeMarksController {
	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping(value = "/thuong-hieu", method = RequestMethod.GET)
	public ModelAndView tradeMakrsPage(HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/trademarks");
			mav.addObject("trademarks", adminService.findAllTradeMarks());
			return mav;
		} else {
			return new ModelAndView("redirect:/khong-tim-thay-yeu-cau");
		}
	}
	
	@RequestMapping(value = "/thuong-hieu/tao-moi", method = RequestMethod.GET)
	public ModelAndView tradeMarksAdd(HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/createTrademark");
			return mav;
		} else {
			return new ModelAndView("redirect:/khong-tim-thay-yeu-cau");
		}
	}
	
	@RequestMapping(value = "/thuong-hieu/add", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String tradeMarkAddSave(@ModelAttribute("trademarks") Trademarks trademarks) {
		adminService.createOneTradeMark(trademarks);
		return "redirect:/thuong-hieu";
	}
	
	@RequestMapping(value = "/thuong-hieu/delete/{id}", method = RequestMethod.GET)
	public String tradeMarkAddSave(@PathVariable int id, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			adminService.deleteOndeTrademark(id);
			return "redirect:/thuong-hieu";
		} else {
			return "redirect:/khong-tim-thay-yeu-cau";
		}
	}
	
	@RequestMapping(value = "/thuong-hieu/update/{id}", method = RequestMethod.GET)
	public String tradeMarkUpdate(@PathVariable int id, Model m, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			Trademarks trademarks = adminService.findByIdTrademark(id);
			m.addAttribute("trademarks", trademarks);
			return "admin/updateTrademark";
		} else {
			return "redirect:/khong-tim-thay-yeu-cau";
		}
	}
	
	@RequestMapping(value = "/thuong-hieu/update/save", method = RequestMethod.POST)
	public String tradeMarkUpdateSave(@ModelAttribute("trademarks") Trademarks trademarks) {
		adminService.updateOneTrademark(trademarks);
		return "redirect:/thuong-hieu";
	}
}
