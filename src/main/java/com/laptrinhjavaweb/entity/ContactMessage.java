package com.laptrinhjavaweb.entity;

public class ContactMessage {
	private int id;
	private String name;
	private String email;
	private String message;
	private String created_at;
	private String phone;
	
	public ContactMessage() {
		
	}

	public ContactMessage(int id, String name, String email, String message, String created_at, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.created_at = created_at;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
