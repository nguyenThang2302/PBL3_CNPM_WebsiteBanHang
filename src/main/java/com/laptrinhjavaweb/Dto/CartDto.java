package com.laptrinhjavaweb.Dto;

import com.laptrinhjavaweb.entity.Products;

public class CartDto {
	private int quantity;
	private double totalPrice;
	private Products product;
	
	public CartDto() {
	}
	
	public CartDto(int quantity, double totalPrice, Products product, double totalPriceDiscount) {
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	
}
