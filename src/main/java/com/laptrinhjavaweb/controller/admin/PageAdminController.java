package com.laptrinhjavaweb.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.slugify.Slugify;
import com.laptrinhjavaweb.entity.BillNotification;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.BillsServiceImpl;

@Controller(value = "pageAdminController")
public class PageAdminController {
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	
	@RequestMapping(value = "/quan-tri", method = RequestMethod.GET)
	public ModelAndView productManagementPage(Model m) {
		ModelAndView mav = new ModelAndView("admin/admin");
		mav.addObject("departments",adminService.findAll());
		mav.addObject("billnotification", billsService.findAllBillNotification());
		m.addAttribute("count_notification", billsService.CountNotification());
		return mav;
	}
}
