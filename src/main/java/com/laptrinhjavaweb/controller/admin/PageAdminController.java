package com.laptrinhjavaweb.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;

@Controller(value = "pageAdminController")
public class PageAdminController {
	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping(value = "/quan-tri", method = RequestMethod.GET)
	public String productManagementPage(Model model) {
		List<Departments> departments = adminService.findAll();
		model.addAttribute("departments", departments);
		return "admin/admin";
	}
}
