package com.laptrinhjavaweb.entity;

public class DiscountCodes {
	private int id;
	private String discount_name;
	private String discount_code;
	private double discount_percent;
	private int amount;
	private String valid_date;
	
	public DiscountCodes() {
		super();
	}
	
	
	public String getDiscount_name() {
		return discount_name;
	}


	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}


	public String getDiscount_code() {
		return discount_code;
	}


	public void setDiscount_code(String discount_code) {
		this.discount_code = discount_code;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDiscount_percent() {
		return discount_percent;
	}
	public void setDiscount_percent(double discount_percent) {
		this.discount_percent = discount_percent;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getValid_date() {
		return valid_date;
	}
	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}
	
}
