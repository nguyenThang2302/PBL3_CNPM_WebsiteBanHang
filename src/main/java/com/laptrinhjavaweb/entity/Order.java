package com.laptrinhjavaweb.entity;

public class Order {
	private String code;
	private int quantity;
	private double total_price;
	private String created_at;
	
	public Order() {
		super();
	}

	public Order(String code, int quantity, double total_price, String created_at) {
		super();
		this.code = code;
		this.quantity = quantity;
		this.total_price = total_price;
		this.created_at = created_at;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
}
