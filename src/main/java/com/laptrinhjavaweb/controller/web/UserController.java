
package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Users;

@Controller
public class UserController extends BaseController {

	/*
	 * @RequestMapping(value = "/dang-ky", method = RequestMethod.GET) public
	 * ModelAndView DangKy() { _mvShare.setViewName("web/register");
	 * _mvShare.addObject("user", new Users()); return _mvShare; }
	 * 
	 * @RequestMapping(value = "/dang-ky", method = RequestMethod.POST) public
	 * ModelAndView TaoAcc(@ModelAttribute("user") Users user) { return _mvShare; }
	 */

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy(HttpServletRequest request, HttpServletResponse response, Model model) {
		_mvShare.setViewName("web/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "/hoan-tat", method = RequestMethod.POST, produces ="text/html; charset=UTF-8")
	public String TaoAcc(HttpServletRequest request, HttpServletResponse respone, HttpSession session, @ModelAttribute("user") Users user, ModelMap model)
	{
		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("repeat_password", user.getRepeat_password());
		System.out.println(user.getName() + user.getEmail() + user.getPassword() + user.getRepeat_password());
		return "redirect:/dang-ky";
	}	

}
