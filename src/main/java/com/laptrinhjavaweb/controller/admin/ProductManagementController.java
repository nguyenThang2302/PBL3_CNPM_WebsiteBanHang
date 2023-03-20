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

import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller(value = "productManagementControllerOfAdmin")
public class ProductManagementController {
	@Autowired
	HomeServiceImpl homeService;
	
	@RequestMapping("/product-management")
	public String showForm(Model m) {

		
		m.addAttribute("command", new Products());
		return"productmanagement";
	}
	
	@RequestMapping(value = "/product-management", method = RequestMethod.GET)
	public String productManagementPage(Model model) {
		/*
		 * ModelAndView mav = new ModelAndView("admin/productmanagement");
		 * mav.addObject("products", homeService.GetDataSilde()); return mav;
		 */
		List<Products> products = homeService.GetDataSilde();
		model.addAttribute("products", products);
		return "admin/productmanagement";
	}
	
	@RequestMapping(value = "/tao-moi", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/createProducts");
		return mav;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteOne(@PathVariable int id ) {
		homeService.deleteOne(id);
		return "redirect:/product-management"; 
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String createOne(@ModelAttribute("products") Products products) { 
		homeService.createOne(products);
		return "redirect:/product-management"; 
	}
	
    @RequestMapping(value="/{id}/update", method = RequestMethod.GET)    
    public String findById(@PathVariable int id, Model m){    
        Products products= homeService.findById(id);  
        m.addAttribute("products",products);  
        return "admin/updateProducts";    
    }  
    
    @RequestMapping(value="/{id}/save",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("products") Products products){  
        homeService.updateOne(products);    
        return "redirect:/product-management";    
    }    
    
}
