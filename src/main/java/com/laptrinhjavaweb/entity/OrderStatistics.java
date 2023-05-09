package com.laptrinhjavaweb.entity;

public class OrderStatistics {
	private double total_price;
	private int total_quantity;
	private int total_bills;
	
	public OrderStatistics() {
		
	}
	
	public OrderStatistics(double total_price, int total_quantity, int total_bills) {
		super();
		this.total_price = total_price;
		this.total_quantity = total_quantity;
		this.total_bills = total_bills;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	public int getTotal_bills() {
		return total_bills;
	}

	public void setTotal_bills(int total_bills) {
		this.total_bills = total_bills;
	}
	
	
}
