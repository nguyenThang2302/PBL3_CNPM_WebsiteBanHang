package com.laptrinhjavaweb.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Users;
@Service
public interface IAccountService {
	@Autowired
	public int AddAccount(Users user);
	@Autowired
	public Users CheckAccount(Users user);
}