package com.revature.interfaces;

public interface UserService {

	public User login(String uName, String pWord);
	
	public User getByName(String uName);
	
	public User getById(User user);
	
	public boolean addUser(User user);
	/*
	public HttpSession getSess();
	
	public void setSess(HttpSession sess); */
}
