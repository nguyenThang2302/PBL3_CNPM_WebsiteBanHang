package com.laptrinhjavaweb.entity;

public class FavouriteProduct {
	private int id;
	private String product_code;
	private int department_id;
	
	public FavouriteProduct() {
		super();
	}

	public FavouriteProduct(int id, String product_code, int department_id) {
		super();
		this.id = id;
		this.product_code = product_code;
		this.department_id = department_id;
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

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
	
}
