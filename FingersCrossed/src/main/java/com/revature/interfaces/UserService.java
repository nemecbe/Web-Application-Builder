package com.revature.interfaces;

public interface UserService {

	public User login(String uName, String pWord);
	
	public User getByName(User user);
	
	public User getById(User user);
	
	public boolean addUser(User user);
}
