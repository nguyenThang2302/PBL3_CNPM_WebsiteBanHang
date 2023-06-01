package com.laptrinhjavaweb.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
	AccountServiceImpl accountService;
	
	@RequestMapping(value = "/thong-tin-khach-hang", method = RequestMethod.GET)
	public ModelAndView notConfimredOrder(HttpServletRequest request, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/inforuser");
			mav.addObject("infor_user", accountService.findAllUser());
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "tim-kiem-khach-hang/{user_code}", method = RequestMethod.GET)
	public @ResponseBody List<Users> searchUser(HttpServletRequest request, @PathVariable String user_code, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			List<Users> user = accountService.findUserByUserCode(user_code);
			if (user == null) {
				return null;
			} else {
				return user;
			}
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "cap-quyen-admin/{user_code}", method = RequestMethod.GET)
	public String updateAdminForUser(@PathVariable String user_code, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			accountService.updateAdmin(user_code);
			return "redirect:/thong-tin-khach-hang";
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "reset-mat-khau/{user_code}", method = RequestMethod.GET)
	public String resetPassWordForUser(@PathVariable String user_code, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			List<Users> userList = accountService.findUserByUserCode(user_code);
			String defaultPassWord = "12345";
			Users user = userList.get(0);
			user.setPassword(defaultPassWord);
			accountService.changPassword2(user);
			user.setPassword(BCrypt.hashpw(defaultPassWord, BCrypt.gensalt(12)));
			return "redirect:/thong-tin-khach-hang";
		} else {
			return null;
		}
	}
}
