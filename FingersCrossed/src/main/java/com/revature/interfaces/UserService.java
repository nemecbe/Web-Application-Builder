package com.revature.interfaces;

import java.util.List;

import com.revature.beans.User;

public interface UserService {

	public User login(String uName, String pWord);
	
	public User getByName(String uName);
	
	public User getById(User user);
	
	public boolean addUser(User user);
	
	public void updateUser(User user);
	
	public List<User> getAllUsers();
	/*
	public HttpSession getSess();
	
	public void setSess(HttpSession sess); */
	
	public User getCurrentUser();

	public void setCurrentUser(User currentUser);
	
	public boolean isInactive();

	public void setInactive(boolean inactive);
}
