package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.web.ContactServiceImpl;

@Controller(value = "pageStatusContactMessageContollerOfAdmin")
public class StatusContactMessageContoller {
	@Autowired
	ContactServiceImpl contactService;
	
	@RequestMapping(value = "/quan-li-hop-thoai/tin-nhan-chua-xem", method = RequestMethod.GET)
	public ModelAndView notSeenMessage() {
		ModelAndView mav = new ModelAndView("admin/notseenmessage");
		mav.addObject("not_seen", contactService.findAllMessageNotSeen());
		return mav;
	}
	
	@RequestMapping(value = "/quan-li-hop-thoai/tin-nhan-da-xem", method = RequestMethod.GET)
	public ModelAndView SeenedMessage() {
		ModelAndView mav = new ModelAndView("admin/seenedmessage");
		mav.addObject("seened", contactService.findAllMessageSeened());
		return mav;
	}
	
	@RequestMapping(value="/quan-li-hop-thoai/xac-nhan-da-xem/{id}",method = RequestMethod.GET)
	public String updateStatusOrder(@PathVariable int id) {
		contactService.updateStatusMessage(id);
		contactService.deleteMessageNotification(id);
		return "redirect:/quan-li-hop-thoai/tin-nhan-chua-xem";
	}
}
