package com.revature.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.interfaces.DAO;
import com.revature.interfaces.UserService;

@Service
//@Scope(value="globalSession")
public class UserServiceImpl implements UserService {	
	
	@Autowired
	DAO<User> uDao;
	
	private boolean inactive = true;
	
	private User currentUser;

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
		return uDao.getById(user.getId());
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		uDao.update(user);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return uDao.getAll();
	}

	public User getCurrentUser() {
		setInactive(false);
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		if(this.currentUser == null) {
			this.currentUser = currentUser;
			setInactive(false);
		}
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
}
