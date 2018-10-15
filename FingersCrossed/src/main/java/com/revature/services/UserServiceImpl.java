package com.revature.services;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.User;
import com.revature.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {	
	
	DAO<User> uDao = new UserDAO();

	public User login(String uName, String pWord) {
		User u = null;
		u = uDao.getByName(uName);
		if (u == null || !u.getpWord().equals(pWord)) {
			return null;
		}		
		return u;
	}

	public boolean addUser(User user) {
		boolean success = false;
		try {
			uDao.create(user);
			success = true;
		}
		catch (HibernateException e) {
			success = false;
		}
		
		return success;
	}

	public User getByName(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getById(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
