package com.laptrinhjavaweb.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.entity.Bills;
import com.laptrinhjavaweb.entity.OrderStatistics;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.BillsServiceImpl;

@Controller(value = "pageStatusOrderController")
public class StatusOrderController {
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	
	@RequestMapping(value = "/quan-li-don-hang/chua-xac-nhan", method = RequestMethod.GET)
	public ModelAndView notConfimredOrder(HttpServletRequest request, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/unconfimredorder");
			mav.addObject("unconfimred", billsService.findAllBillsUnconfimred());
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value="/quan-li-don-hang/xac-nhan-don-hang/{code}",method = RequestMethod.GET)
	public String updateStatusOrder(@PathVariable String code, HttpServletRequest request, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			billsService.updateStatusOrder(code);
			billsService.deleteNotificationByCode(code);
			return "redirect:/quan-li-don-hang/chua-xac-nhan";
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/quan-li-don-hang/da-xac-nhan", method = RequestMethod.GET)
	public ModelAndView ConfimredOrder(HttpServletRequest request, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/confimredorder");
			mav.addObject("confimred", billsService.findAllBillsConfimred());
			return mav;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/quan-li-don-hang/tim-kiem-don-hang/da-xac-nhan/{code}", method = RequestMethod.GET)
	public @ResponseBody String searchOrderConfimred(HttpServletRequest request, @PathVariable String code, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			Map<String, Object> result = new HashMap<>();
			Bills bills = billsService.findBillComfirmedByCode(code);
			result.put("code", bills.getCode());
			result.put("status", bills.getStatus());
			result.put("quantity", bills.getQuantity());
			result.put("total_price", bills.getTotal_price());
			result.put("created_at", bills.getCreated_at());
			ObjectMapper objectMapper = new ObjectMapper();
			String json = "";
			try {
				json = objectMapper.writeValueAsString(result);
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/quan-li-don-hang/tim-kiem-don-hang/cho-xac-nhan/{code}", method = RequestMethod.GET)
	public @ResponseBody String searchOrderUnonfimred(HttpServletRequest request, @PathVariable String code, HttpServletResponse respone, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			Map<String, Object> result = new HashMap<>();
			Bills bills = billsService.findBillUnconfirmedByCode(code);
			result.put("code", bills.getCode());
			result.put("status", bills.getStatus());
			result.put("quantity", bills.getQuantity());
			result.put("total_price", bills.getTotal_price());
			result.put("created_at", bills.getCreated_at());
			ObjectMapper objectMapper = new ObjectMapper();
			String json = "";
			try {
				json = objectMapper.writeValueAsString(result);
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
			return json;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/quan-li-don-hang/thong-ke", method = RequestMethod.GET)
	public ModelAndView statisticsOrder(HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			ModelAndView mav = new ModelAndView("admin/orderstatistics");
			return mav;
		} else {
			return null;
		}
	}
	
	@GetMapping(value = "/quan-li-don-hang/thong-ke/{fromDate}/{toDate}")
	public @ResponseBody Map<String, Object> ajaxStatisticsOrder(HttpServletRequest request, @PathVariable String fromDate, @PathVariable String toDate, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser.getIs_admin() == 1) {
			Map<String, Object> result = new HashMap<>();
			OrderStatistics orderStatistics = billsService.findBestInforOrder(fromDate, toDate);
			Products product = billsService.findProductBestSale(fromDate, toDate);
			result.put("total_bills", orderStatistics.getTotal_bills());
			result.put("total_price", orderStatistics.getTotal_price());
			result.put("total_quantity", orderStatistics.getTotal_quantity());
			result.put("product_best_sale", product.getName());
			return result;
		} else {
			return null;
		}
	}
}
