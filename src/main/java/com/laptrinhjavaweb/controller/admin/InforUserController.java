package com.laptrinhjavaweb.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.web.AccountServiceImpl;

@Controller(value = "inforUserControllerOfAdmin")
public class InforUserController {
	@Autowired
	AccountServiceImpl acountService;
	
	@RequestMapping(value = "/thong-tin-khach-hang", method = RequestMethod.GET)
	public ModelAndView notConfimredOrder(HttpServletRequest request, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/inforuser");
			mav.addObject("infor_user", acountService.findAllUser());
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "tim-kiem-khach-hang/{user_code}", method = RequestMethod.GET)
	public @ResponseBody List<Users> searchUser(HttpServletRequest request, @PathVariable String user_code, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			List<Users> user = acountService.findUserByUserCode(user_code);
			if (user == null) {
				return null;
			} else {
				return user;
			}
		} else {
			return null;
		}
	}
}
