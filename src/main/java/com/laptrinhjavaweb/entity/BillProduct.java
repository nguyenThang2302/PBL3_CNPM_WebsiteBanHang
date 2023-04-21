package com.laptrinhjavaweb.entity;

public class BillProduct {
	private String name;
	private double price;
	private int quantity;
	private double total_price;
	
	public BillProduct() {
		super();
	}
	
	public BillProduct(String name, double price, int quantity, double total_price) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.total_price = total_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
}
