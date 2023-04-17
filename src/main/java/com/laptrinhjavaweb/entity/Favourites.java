package com.laptrinhjavaweb.entity;

public class Favourites {
	private String name;
	private String code;
	private double price;
	private int count_favourite;
	
	public Favourites() {
		super();
	}

	public Favourites(String name, String code, double price, int count_favourite) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.count_favourite = count_favourite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount_favourite() {
		return count_favourite;
	}

	public void setCount_favourite(int count_favourite) {
		this.count_favourite = count_favourite;
	}
}
