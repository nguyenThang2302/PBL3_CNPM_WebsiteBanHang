package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Users;
@Service
public interface IAccountService {
	@Autowired
	public int AddAccount(Users user);
	@Autowired
	public Users CheckAccount(Users user);
	@Autowired
	public int InsertGuest(String guest_code);
	@Autowired
	public List<Users> findAllUser();
	@Autowired
	public List<Users> findUserByUserCode(String user_code);
	@Autowired
	public int updateAdmin(String user_code);
}