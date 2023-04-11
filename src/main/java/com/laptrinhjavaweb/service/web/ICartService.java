package com.laptrinhjavaweb.service.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Dto.CartDto;

@Service
public interface ICartService {
	@Autowired
	public HashMap<String, CartDto> AddCart(String code, HashMap<String, CartDto> cart);
	@Autowired
	public HashMap<String, CartDto> EditCart(String code, int quantity ,HashMap<String, CartDto> cart);
	@Autowired
	public HashMap<String, CartDto> DeleteCart(String code, HashMap<String, CartDto> cart);
	@Autowired
	public int TotalQuantity(HashMap<String, CartDto> cart);
	@Autowired
	public double TotalPrice(HashMap<String, CartDto> cart);
	@Autowired
	public HashMap<String, CartDto> AddCartWithQuantity(String code,int quantity, HashMap<String, CartDto> cart);
}
