package com.laptrinhjavaweb.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.ContactMessageDao;
import com.laptrinhjavaweb.entity.ContactMessage;

@Service
public class ContactServiceImpl implements IContactService {
	@Autowired
	private ContactMessageDao contactMessageDao;
	
	@Override
	public int createOneMessage(ContactMessage c) {
		return contactMessageDao.createOneMessage(c);
	}
}
