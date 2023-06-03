package com.laptrinhjavaweb.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinhjavaweb.entity.Departments;
import com.laptrinhjavaweb.entity.DescriptionProduct;
import com.laptrinhjavaweb.entity.Products;
import com.laptrinhjavaweb.entity.Users;
import com.laptrinhjavaweb.service.admin.AdminServiceImpl;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller(value = "productManagementControllerOfAdmin")
public class ProductManagementController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	AdminServiceImpl adminService;
	
	@RequestMapping(value = "/san-pham/{slug_name}", method = RequestMethod.GET)
	public String productManagementPage(Model model, @PathVariable String slug_name, HttpServletRequest request, HttpServletResponse respone, HttpSession session, @ModelAttribute("user") Users user) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			Departments departments = adminService.findBySlugName(slug_name);
			List<Products> products = null;
			if(departments.getSlug_name().equals("tat-ca-san-pham") == true) {
				products = homeService.findAllProducts();
			} 
			if(departments.getSlug_name().equals("tat-ca-san-pham") == false) {
				products = homeService.GetDataSilde(departments.getId());
			}
			model.addAttribute("products", products);
			model.addAttribute("departments", departments);
			return "admin/productmanagement";
		} else {
			return "redirect:/khong-tim-thay-yeu-cau";
		}
	}
	
	@RequestMapping(value = "/san-pham/tao-moi/{slug_name}", method = RequestMethod.GET)
	public String updateProductPage(@PathVariable String slug_name, Model model, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			Departments departments = adminService.findBySlugName(slug_name);
			model.addAttribute("departments",departments);
			return "admin/createProducts";
		} else {
			return "redirect:/khong-tim-thay-yeu-cau";
		}
	}
	
	@RequestMapping(value = "/san-pham/delete/{slug_name}/{code}", method = RequestMethod.GET)
	public String deleteOne(@PathVariable String code, @PathVariable String slug_name, HttpSession session) {
		Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			homeService.deleteOne(code);
			return "redirect:/san-pham/"+slug_name; 
		} else {
			return "redirect:/khong-tim-thay-yeu-cau";
		}
	}
	
	@RequestMapping(value = "/san-pham/tao-moi/{slug_name}/add", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String createOne(@ModelAttribute("products") Products products, @PathVariable String slug_name) {
		Departments departments = adminService.findBySlugName(slug_name);
		homeService.createOne(products, departments.getId());
		return "redirect:/san-pham/"+slug_name; 
	}
	
    @RequestMapping(value="/san-pham/{slug_name}/{code}/update", method = RequestMethod.GET)    
    public String findByCode(@PathVariable String code, Model m, HttpSession session){    
    	Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			Products products= homeService.findByCode(code);
	        Departments departments = adminService.findSlugNameByCode(code);
	        m.addAttribute("products",products);  
	        m.addAttribute("departments",departments);  
	        return "admin/updateProduct";  
		} else {
			return "redirect:/khong-tim-thay-yeu-cau";
		}
    }  
    
    @RequestMapping(value="/san-pham/{slug_name}/{code}/save",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("products") Products products, @PathVariable String slug_name, @PathVariable String code){  
        homeService.updateOne(products);    
        return "redirect:/san-pham/"+slug_name;    
    }
    
    @RequestMapping(value="/san-pham/{slug_name}/{code}/mo-ta", method = RequestMethod.GET)    
    public String updateDescriptionProduct(@PathVariable String slug_name,@PathVariable String code, Model m, HttpSession session){    
    	Users currentUser = (Users) session.getAttribute("LoginInfor");
		if (currentUser != null && currentUser.getIs_admin() == 1) {
			DescriptionProduct desProduct= adminService.findProductDescription(code);
	        Products products = homeService.findByCode(code);
	        m.addAttribute("desProduct",desProduct);  
	        m.addAttribute("products",products);
	        return "admin/updateDescriptionProduct";  
		} else {
			return "redirect:/khong-tim-thay-yeu-cau";
		}
    }  
    
    @RequestMapping(value="/san-pham/{slug_name}/{code}/savemota",method = RequestMethod.POST)    
    public String editsaveDescriptionProduct(@ModelAttribute("desProduct") DescriptionProduct desProduct, @PathVariable String code, @PathVariable String slug_name){  
         adminService.updateDescritionProduct(desProduct);
        return "redirect:/san-pham/"+slug_name;    
    }
}
