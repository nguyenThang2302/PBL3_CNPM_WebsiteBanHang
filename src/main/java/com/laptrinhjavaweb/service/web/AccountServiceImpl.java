package com.laptrinhjavaweb.service.web;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.UsersDao;
import com.laptrinhjavaweb.entity.Users;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	UsersDao usersDao = new UsersDao();
	
	public int AddAccount(Users user) {
	    if (usersDao.isUserExists(user.getEmail())) {
	        return -1;
	    } else {
	        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
	        return usersDao.AddAccount(user);
	    }
	}

	@Override
	public Users CheckAccount(Users user) {
		String pass = user.getPassword();
		user = usersDao.getUserByAcc(user);
		if(user != null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}
			else {
				return null;
			}
		}
		return null;
	}
}