package com.laptrinhjavaweb.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.web.AccountServiceImpl;

@Controller(value= "profileControllerOfWeb")
public class ProfileController extends BaseController {
	
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/thong-tin-nguoi-dung", method = RequestMethod.GET)
	public ModelAndView DangNhap(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null) {
			_mvShare.setViewName("web/profile");
			_mvShare.addObject("user", new Users());
			return _mvShare;
		} else {
			return new ModelAndView("redirect:/khong-tim-thay-yeu-cau");
		}
	}
	
	@RequestMapping(value = "/cap-nhat-thong-tin", method = RequestMethod.POST, produces ="text/html; charset=UTF-8")
	public String UpdateProfile(HttpServletRequest request, HttpServletResponse respone, HttpSession session, @ModelAttribute("user") Users user, RedirectAttributes redirectAttributes)
	{	
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if(currentUser != null) {
			user.setUser_code(currentUser.getUser_code()); //set user_code for user
			accountService.updateUserProfile(user); // update user infor
			
	        currentUser.setName(user.getName());
	        currentUser.setEmail(user.getEmail());
	        currentUser.setPhone(user.getPhone());
	        currentUser.setAddress(user.getAddress());

			redirectAttributes.addFlashAttribute("successMsg", "Cập nhật thông tin thành công!");
		}
		else {
			redirectAttributes.addFlashAttribute("unsuccessMsg", "Cập nhật thông tin thất bại!");
		}
		return "redirect:/thong-tin-nguoi-dung";
	}
	

	@RequestMapping(value = "doi-mat-khau", method = RequestMethod.POST, produces ="text/html; charset=UTF-8")
	public @ResponseBody String changePassword(HttpServletRequest request, HttpServletResponse response, HttpSession session, @ModelAttribute("user") Users user,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword, RedirectAttributes redirectAttributes) {
	    Users currentUser = (Users) session.getAttribute("LoginInfor");
	    Map<String, Object> result = new HashMap<>();
	    if (currentUser != null && BCrypt.checkpw(oldPassword, currentUser.getPassword())) {
	    	System.out.println("trùng");
	        if (!newPassword.equals(confirmPassword)) {
	            redirectAttributes.addFlashAttribute("thatbai", "New password and confirm password don't match");
	            result.put("status", "New password and confirm password don't match");
	        } 
	        else {
	            	user.setUser_code(currentUser.getUser_code()); 
					user.setPassword(newPassword);
					accountService.changPassword2(user);
					currentUser.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)));
					System.out.println("User: " + user.getPassword());
					System.out.println("currentUser: " + currentUser.getPassword());
					session.setAttribute("LoginInfor", currentUser);
	                redirectAttributes.addFlashAttribute("thanhcong", "Đổi mật khẩu thành công!");
	                result.put("status", "Change Password Successfuly");
	        }
	    } else {
	    	System.out.println("Không trùng");
	    	result.put("status", "old password is not correct");
	        redirectAttributes.addFlashAttribute("thatbai2", "Sai mật khẩu cũ");
	    }
	    ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(result);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
