package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.UserImpl;
import com.revature.interfaces.User;
import com.revature.interfaces.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	private UserService uServ;
	
	@PostMapping(value="/login", produces="application/json")
	public  User userLogin(@RequestBody UserImpl user) {
		String uName = user.getuName();
		String pWord = user.getpWord();
		User u = uServ.login(uName, pWord);
		if (u == null) {
			//will return response entity in next iteration, 
			//	for now return null
			return null;
		}
		return u;
	}
}
