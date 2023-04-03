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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.slugify.Slugify;
import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.Products;
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
