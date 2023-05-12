package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.ContactMessage;
import com.laptrinhjavaweb.entity.MessageNotification;

@Service
public interface IContactService {
	@Autowired
	public int createOneMessage(ContactMessage c);
	@Autowired
	public List<ContactMessage> findAllMessageNotSeen();
	@Autowired
	public List<ContactMessage> findAllMessageSeened();
	@Autowired
	public int updateStatusMessage(int id);
	@Autowired
	public int createMessageNotificaton(MessageNotification m);
	@Autowired
	public int deleteMessageNotification(int contact_id);
	@Autowired
	public int CountNotification();
}
