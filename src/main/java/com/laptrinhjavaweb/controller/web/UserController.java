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
		int check_pass = 0;
		if(user.getPassword().equals(user.getRepeat_password())) {
			check_pass = 1;
		}
		int count = accountService.AddAccount(user);
		if(count > 0 && check_pass == 1) {
			redirectAttributes.addFlashAttribute("status", "Đăng ký tài khoản thành công");
		}
		else if(check_pass == 0) {
			redirectAttributes.addFlashAttribute("status", "Xác nhận mật khẩu chưa khớp!");
		}
		else {
			redirectAttributes.addFlashAttribute("status", "Email đã tồn tại, vui lòng sử dụng Email khác!");
		}
		return "redirect:/dang-ky";
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView DangNhap(HttpServletRequest request, HttpServletResponse response) {
		_mvShare.setViewName("web/login");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/hoan-thanh", method = RequestMethod.POST, produces ="text/html; charset=UTF-8")
	public String Login(HttpServletRequest request, HttpServletResponse respone, HttpSession session, @ModelAttribute("user") Users user, RedirectAttributes redirectAttributes)
	{	
		user = accountService.CheckAccount(user);
		if(user != null && user.getIs_admin() == 0) {
			session.setAttribute("LoginInfor", user);
			return "redirect:/trang-chu";
		} else if (user != null && user.getIs_admin() == 1) {
			session.setAttribute("LoginInfor", user);
			return "redirect:/quan-tri";
		}
		else {
			redirectAttributes.addFlashAttribute("status_Login", "Sai tên tài khoản hoặc mật khẩu");
		}
		return "redirect:/dang-nhap";
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String DangXuat(HttpSession session) {
	    session.removeAttribute("LoginInfor");
	    return "redirect:/trang-chu";
	}
}
