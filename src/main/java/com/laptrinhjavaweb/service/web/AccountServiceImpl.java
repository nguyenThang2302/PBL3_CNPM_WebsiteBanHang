package com.laptrinhjavaweb.service.web;

import java.util.List;

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
	    if (usersDao.isUserExists(user.getEmail()) || !user.getPassword().equals(user.getRepeat_password())) {
	        return -1;
	    } else {
	        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
	        return usersDao.AddAccount(user);
	    }
	}
	
	@Override
	public int InsertGuest(String guest_code) {
		return usersDao.InsertGuest(guest_code);
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
	

	public Users changePassword(Users user, String oldPassword, String newPassword) {
	    Users currentUser = usersDao.getUserByUserCode(user.getUser_code());
	    if (currentUser != null && currentUser.getPassword().equals(oldPassword)) {
	        currentUser.setPassword(newPassword);
	        usersDao.updateUser(currentUser);
	        return currentUser;
	    } else {
	        throw new RuntimeException("Invalid current password");
	    }
	}

	public Users changPassword2(Users user) {
	    Users existingUser = usersDao.getUserByUserCode(user.getUser_code());
	    if (existingUser != null) {
	        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
	        existingUser.setPassword(hashedPassword);
	        usersDao.updateUser_passWord(existingUser);
	    }
	    return user;
	}
	
	@Override
	public List<Users> findAllUser() {
		return usersDao.findAllUser();
	}
	
	@Override
	public List<Users> findUserByUserCode(String user_code) {
		return usersDao.findUserByUserCode(user_code);
	}
	
	@Override
	public int updateAdmin(String user_code) {
		return usersDao.updateAdmin(user_code);
	}
}