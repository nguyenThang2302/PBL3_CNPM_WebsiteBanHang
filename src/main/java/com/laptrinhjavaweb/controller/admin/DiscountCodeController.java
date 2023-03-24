
package com.laptrinhjavaweb.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DiscountCodes;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.admin.DiscountCodesServiceImpl;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller(value = "DiscountCodesControllerOfAdmin")
public class DiscountCodeController {
	
	@Autowired
	DiscountCodesServiceImpl DiscountCodesService;
	
	@RequestMapping(value = "/discount-management", method = RequestMethod.GET)
	public String discountManagementPage(Model model) {
		List<DiscountCodes> discountcodes = DiscountCodesService.GetDataSilde();
		model.addAttribute("discountcodes", discountcodes);
		return "admin/discountcodes";
	}
	
	
	  @RequestMapping(value = "/discount-management/tao-moi", method = RequestMethod.GET)
	  public ModelAndView homePage() { ModelAndView mav = new
	  ModelAndView("admin/createDiscountCodes"); return mav; }
//
	  @RequestMapping(value = "/discount-management/create", method = RequestMethod.POST, produces =
	  "text/html; charset=UTF-8") public String
	  createOne(@ModelAttribute("discountcodes") DiscountCodes discountcodes) {
	  DiscountCodesService.createOne(discountcodes); 
	  return "redirect:/discount-management"; }
	  
	  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) public
	  String deleteOne(@PathVariable int id ) { DiscountCodesService.deleteOne(id);
	  return "redirect:/discount-codes"; }
		  
	  @RequestMapping(value = "/discount-management/delete", method = RequestMethod.DELETE)
	  public ModelAndView homePage1() { ModelAndView mav = new
	  ModelAndView("admin/deleteDiscountCodes"); return mav; }
	  
	  
	  @RequestMapping(value="/discount-management/search", method = RequestMethod.GET) public
	  String findById(@PathVariable int id, Model m){ DiscountCodes discountcodes=
	  DiscountCodesService.findById(id); m.addAttribute("discountcodes",
	  discountcodes); return "admin/searchDiscountCodes"; }
	 
	  
//	  @RequestMapping(value="/discount-management/delete", method = RequestMethod.DELETE) public
//	  String findById(@PathVariable int id, Model m){ DiscountCodes discountcodes=
//	  DiscountCodesService.deleteOne(id); m.addAttribute("discountcodes",
//	  discountcodes); return "admin/updateDiscountCodes"; }
	  
//	  @RequestMapping(value="/discount-management/update", method = RequestMethod.GET) public
//	  String updateOne(@PathVariable int id, Model m){ DiscountCodes discountcodes=
//	  DiscountCodesService.updateOne(id); m.addAttribute("discountcodes",
//	  discountcodes); //return "admin/updateDiscountCodes"; 
//	  return "admin/updateDiscountCodes";
//	  }
	  
	  
	 /* @RequestMapping(value="/{id}/save",method = RequestMethod.POST) public String
	 * editsave(@ModelAttribute("discountcodes") DiscountCodes discountcodes){
	 * DiscountCodesService.updateOne(discountcodes); return
	 * "redirect:/discount-codes"; }
	 */
        
}
