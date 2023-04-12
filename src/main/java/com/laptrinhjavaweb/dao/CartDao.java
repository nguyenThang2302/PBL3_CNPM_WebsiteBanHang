package com.laptrinhjavaweb.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.entity.Products;

@Repository
public class CartDao extends BaseDao {
	@Autowired
	ProductDao productDao = new ProductDao();
	
	public HashMap<String, CartDto> AddCart(String code, HashMap<String, CartDto> cart) {
		CartDto itemCart = new CartDto();
		Products product = productDao.findByCode(code);
		if (product != null && cart.containsKey(code)) {
			itemCart = cart.get(code);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(code, itemCart);
		return cart;
	}
	
	public HashMap<String, CartDto> EditCart(String code, int quantity ,HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(code)) {
			itemCart = cart.get(code);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(quantity * itemCart.getProduct().getPrice());
		}
		cart.put(code, itemCart);
		return cart;
	}
	
	public HashMap<String, CartDto> DeleteCart(String code, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(code)) {
			cart.remove(code);
		}
		return cart;
	}
	
	public int TotalQuantity(HashMap<String, CartDto> cart) {
		int totalQuantity = 0;
		for(Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}
	
	public double TotalPrice(HashMap<String, CartDto> cart) {
		double totalPrice = 0;
		for(Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
