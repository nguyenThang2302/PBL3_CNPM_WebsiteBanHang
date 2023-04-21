package com.laptrinhjavaweb.entity;

public class Bills {
	private int id;
	private String code;
	private String user_code;
	private String phone;
	private String email;
	private String address;
	private String name;
	private int quantity;
	private double total_price;
	private String note;
	private String created_at;
	
	public Bills() {
		super();
	}

	public Bills(int id, String code, String phone, String email, String name, int quantity, double total_price,
			String note, String address, String user_code, String created_at) {
		super();
		this.id = id;
		this.code = code;
		this.phone = phone;
		this.email = email;
		this.name = name;
		this.quantity = quantity;
		this.total_price = total_price;
		this.note = note;
		this.address = address;
		this.user_code = user_code;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
}
