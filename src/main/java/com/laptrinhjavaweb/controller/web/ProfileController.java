package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.web.AccountServiceImpl;

@Controller(value= "profileControllerOfWeb")
public class ProfileController extends BaseController {
	
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/thong-tin-nguoi-dung", method = RequestMethod.GET)
	public ModelAndView DangNhap(HttpServletRequest request, HttpServletResponse response) {
		_mvShare.setViewName("web/profile");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/cap-nhat-thong-tin", method = RequestMethod.POST, produces ="text/html; charset=UTF-8")
	public String UpdateProfile(HttpServletRequest request, HttpServletResponse respone, HttpSession session, @ModelAttribute("user") Users user, RedirectAttributes redirectAttributes)
	{	
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if(currentUser != null) {
			user.setUser_code(currentUser.getUser_code()); //set user_code for user
			accountService.updateUserProfile(user); // update user infor
			redirectAttributes.addFlashAttribute("successMsg", "Cập nhật thông tin thành công!");
		}
		else {
			redirectAttributes.addFlashAttribute("unsuccessMsg", "Cập nhật thông tin thất bại!");
		}
		return "redirect:/thong-tin-nguoi-dung";
	}
}
