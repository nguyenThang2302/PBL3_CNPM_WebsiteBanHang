package com.laptrinhjavaweb.entity;

public class Departments {
	private int id;
	private String name;
	private String slug_name;
	
	public Departments() {
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
	
}
