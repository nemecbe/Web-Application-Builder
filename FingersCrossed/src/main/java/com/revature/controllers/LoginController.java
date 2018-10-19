package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.interfaces.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	private UserService uServ;
	
	@PostMapping(value="/login", produces="application/json")
	public  User userLogin(@RequestBody User user) {
		String uName = user.getuName();
		String pWord = user.getpWord();
		User u = uServ.login(uName, pWord);
		if (u == null) {
			//will return response entity in next iteration, 
			//	for now return null
			return null;
		}
		uServ.setCurrentUser(u);
		return u;
	}
	
	@DeleteMapping(value="/login/{uname}")
	public void logout(@PathVariable(name="uname") String uname,
			@RequestBody User user) {
		if(uServ.getCurrentUser() != null && uServ.getCurrentUser().getuName().equals(uname))
			uServ.setCurrentUser(null);
	}
}
