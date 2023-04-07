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
		if(usersDao.isUserExists(user.getEmail())) {
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
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public Users updateUserProfile(Users user) {
	    Users existingUser = usersDao.getUserByUserCode(user.getUser_code());
	    if (existingUser != null) {
	        existingUser.setName(user.getName());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setPhone(user.getPhone());
	        existingUser.setAddress(user.getAddress());
	        usersDao.updateUser(existingUser);
	    }
	    return user;
	}
}