package com.laptrinhjavaweb.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.ContactMessage;

@Service
public interface IContactService {
	@Autowired
	public int createOneMessage(ContactMessage c);
}
