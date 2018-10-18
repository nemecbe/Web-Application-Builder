package com.revature.services;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.User;
import com.revature.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {	
	
	@Autowired
	DAO<User> uDao;

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

	public User getByName(String username) {
		// TODO Auto-generated method stub
		return uDao.getByName(username);
	}

	public User getById(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
