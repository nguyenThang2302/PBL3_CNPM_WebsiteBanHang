package com.laptrinhjavaweb.controller.web;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.web.AccountServiceImpl;

@Controller
public class UserController extends BaseController {

	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy(HttpServletRequest request, HttpServletResponse response, Model model) {
		_mvShare.setViewName("web/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/hoan-tat", method = RequestMethod.POST, produces ="text/html; charset=UTF-8")
	public String CreatAcc(HttpServletRequest request, HttpServletResponse respone, HttpSession session, @ModelAttribute("user") Users user, RedirectAttributes redirectAttributes) {
		Random rd = new Random();
		String user_code = System.currentTimeMillis() + rd.nextInt(1000) + "";
		user.setUser_code(user_code);
		System.out.println(user.getUser_code() + user.getName() + user.getEmail() + user.getPassword() + user.getRepeat_password());
		int count = accountService.AddAccount(user);
		if(count > 0) {
			redirectAttributes.addFlashAttribute("status", "Đăng ký tài khoản thành công");
		}
		else {
			redirectAttributes.addFlashAttribute("status", "Đăng ký tài khoản thất bại");
		}
		return "redirect:/dang-ky";
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView DangNhap(HttpServletRequest request, HttpServletResponse response, Model model) {
		_mvShare.setViewName("web/login");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/hoan-thanh", method = RequestMethod.POST, produces ="text/html; charset=UTF-8")
	public String Login(HttpServletRequest request, HttpServletResponse respone, HttpSession session, @ModelAttribute("user") Users user, RedirectAttributes redirectAttributes)
	{	
		user = accountService.CheckAccount(user);
		if(user != null) {
			session.setAttribute("LoginInfor", user);
			return "redirect:/trang-chu";
		}
		else {
			redirectAttributes.addFlashAttribute("status_Login", "Đăng nhập thất bại");
		}
		return "redirect:/dang-nhap";
	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String DangXuat(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) {
		session.removeAttribute("LoginInfor");
		return "redirect:" + request.getHeader("Referer");
	}
}
