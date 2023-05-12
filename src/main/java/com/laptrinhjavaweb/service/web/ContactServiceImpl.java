package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.ContactMessageDao;
import com.laptrinhjavaweb.dao.MessageNotificationDao;
import com.laptrinhjavaweb.entity.ContactMessage;
import com.laptrinhjavaweb.entity.MessageNotification;

@Service
public class ContactServiceImpl implements IContactService {
	@Autowired
	private ContactMessageDao contactMessageDao;
	
	@Autowired
	private MessageNotificationDao messageNotificationDao;
	
	@Override
	public int createOneMessage(ContactMessage c) {
		return contactMessageDao.createOneMessage(c);
	}
	
	public void AddMessageNotification() {
		int contact_id = messageNotificationDao.getLastContactId();
		MessageNotification messageNotification = new MessageNotification();
		messageNotification.setContact_id(contact_id);
		messageNotificationDao.createMessageNotificaton(messageNotification);
	}
	
	@Override
	public List<ContactMessage> findAllMessageNotSeen() {
		return contactMessageDao.findAllMessageNotSeen();
	}
	
	@Override
	public List<ContactMessage> findAllMessageSeened() {
		return contactMessageDao.findAllMessageSeened();
	}
	
	@Override
	public int updateStatusMessage(int id) {
		return contactMessageDao.updateStatusMessage(id);
	}
	
	@Override
	public int createMessageNotificaton(MessageNotification m) {
		return messageNotificationDao.createMessageNotificaton(m);
	}
	
	@Override
	public int deleteMessageNotification(int contact_id) {
		return messageNotificationDao.deleteMessageNotification(contact_id);
	}
	
	@Override
	public int CountNotification() {
		return messageNotificationDao.CountNotification();
	}
}
