package com.laptrinhjavaweb.service.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Dto.CartDto;
import com.laptrinhjavaweb.dao.CartDao;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartDao cartDao;

	@Override
	public HashMap<String, CartDto> AddCart(String code, HashMap<String, CartDto> cart) {
		return cartDao.AddCart(code, cart);
	}

	@Override
	public HashMap<String, CartDto> EditCart(String code, int quantity ,HashMap<String, CartDto> cart) {
		return cartDao.EditCart(code, quantity, cart);
	}

	@Override
	public HashMap<String, CartDto> DeleteCart(String code, HashMap<String, CartDto> cart) {
		return cartDao.DeleteCart(code, cart);
	}
	
	@Override
	public int TotalQuantity(HashMap<String, CartDto> cart) {
		return cartDao.TotalQuantity(cart);
	}
	
	@Override
	public double TotalPrice(HashMap<String, CartDto> cart) {
		return cartDao.TotalPrice(cart);
	}
	
	@Override
	public HashMap<String, CartDto> AddCartWithQuantity(String code,int quantity, HashMap<String, CartDto> cart) {
		return cartDao.AddCartWithQuantity(code, quantity, cart);
	}
}
