package com.laptrinhjavaweb.entity;

public class MessageNotification {
	private int id;
	private int contact_id;
	
	public MessageNotification() {
		
	}

	public MessageNotification(int id, int contact_id) {
		super();
		this.id = id;
		this.contact_id = contact_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
}
