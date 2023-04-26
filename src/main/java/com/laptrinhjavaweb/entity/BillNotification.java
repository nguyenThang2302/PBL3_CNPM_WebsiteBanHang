package com.laptrinhjavaweb.entity;

public class BillNotification {
	private int id;
	private String bill_code;
	
	public BillNotification() {
		super();
	}
	
	public BillNotification(int id, String bill_code) {
		super();
		this.id = id;
		this.bill_code = bill_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBill_code() {
		return bill_code;
	}

	public void setBill_code(String bill_code) {
		this.bill_code = bill_code;
	}
}
