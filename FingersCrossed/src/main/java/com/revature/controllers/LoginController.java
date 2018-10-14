package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.UserImpl;
import com.revature.interfaces.User;
import com.revature.interfaces.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	UserService uServ;
	
	@PostMapping(value="/login", produces="application/json")
	public  User userLogin(@RequestBody UserImpl user) {
		System.out.println(user.toString());
		String uName = user.getuName();
		String pWord = user.getpWord();
		User u = uServ.login(uName, pWord);
		return u;
	}
}
