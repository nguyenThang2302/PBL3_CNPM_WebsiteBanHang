package com.laptrinhjavaweb.entity;

public class Users {
	private String user_code;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String address;
	private String repeat_password;
	
	public Users(){
		
	}
	
	public Users(String user_code,String email, String password, String name, String repeat_password) {
		this.email = email; 
		this.password = password;
		this.name = name; 
		this.repeat_password = repeat_password;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRepeat_password() {
		return repeat_password;
	}

	public void setRepeat_password(String repeat_password) {
		this.repeat_password = repeat_password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
