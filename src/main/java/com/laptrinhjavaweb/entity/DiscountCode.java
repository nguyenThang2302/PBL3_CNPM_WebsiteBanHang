package com.laptrinhjavaweb.entity;

import java.sql.Date;

public class DiscountCode {
	private int id;
	private String name;
	private String slug_name;
	private String code;
	private double percent;
	private int amount;
	private Date valid_date;
	
	public DiscountCode() {
		super();
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

	public String getSlug_name() {
		return slug_name;
	}

	public void setSlug_name(String slug_name) {
		this.slug_name = slug_name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getValid_date() {
		return valid_date;
	}

	public void setValid_date(Date valid_date) {
		this.valid_date = valid_date;
	}
	
}
