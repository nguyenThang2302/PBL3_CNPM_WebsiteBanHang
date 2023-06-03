package com.laptrinhjavaweb.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.view.RedirectView;

import com.github.slugify.Slugify;
import com.laptrinhjavaweb.entity.BillNotification;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.BillsServiceImpl;
import com.laptrinhjavaweb.service.web.ContactServiceImpl;

@Controller(value = "pageAdminController")
public class PageAdminController {
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	@Autowired
	private ContactServiceImpl contactService;
	
	@RequestMapping(value = "/quan-tri", method = RequestMethod.GET)
	public ModelAndView productManagementPage(Model m, HttpServletRequest request, HttpServletResponse respone, HttpSession session, @ModelAttribute("user") Users user) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/admin");
			mav.addObject("departments",adminService.findAll());
			mav.addObject("billnotification", billsService.findAllBillNotification());
			m.addAttribute("count_notification", billsService.CountNotification());
			m.addAttribute("count_notification_message", contactService.CountNotification());
			return mav;
		} else {
			return new ModelAndView("redirect:/khong-tim-thay-yeu-cau");
		}
	}
}
