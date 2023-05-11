package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.ContactMessage;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.ContactServiceImpl;

@Controller(value = "contactControllerOfWeb")
public class ContactController {
	@Autowired
	AdminServiceImpl adminService;
	
	@Autowired
	ContactServiceImpl contactService;
	
	@RequestMapping(value = "/lien-he", method = RequestMethod.GET)
	public ModelAndView contactPage() {
		ModelAndView mav = new ModelAndView("web/contact");
		mav.addObject("departments", adminService.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/send-message", method = RequestMethod.POST) 
	public String sendContactMessage(@ModelAttribute("contactMessage") ContactMessage contactMessage ) {
		contactService.createOneMessage(contactMessage);
		return "redirect:/lien-he";
	}
}
