package com.laptrinhjavaweb.entity;

public class BillDetail {
	private int id;
	private String product_code;
	private String bill_code;
	private int quantity;
	private double total_price;
	
	public BillDetail() {
		super();
	}

	public BillDetail(int id, String product_code, String bill_code, int quantity, double total_price) {
		super();
		this.id = id;
		this.product_code = product_code;
		this.bill_code = bill_code;
		this.quantity = quantity;
		this.total_price = total_price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getBill_code() {
		return bill_code;
	}

	public void setBill_code(String bill_code) {
		this.bill_code = bill_code;
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
