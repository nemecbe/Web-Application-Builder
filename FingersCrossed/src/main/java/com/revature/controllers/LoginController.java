package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.UserImpl;
import com.revature.interfaces.Page;
import com.revature.interfaces.PageService;
import com.revature.interfaces.User;
import com.revature.interfaces.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	private UserService uServ;
	
	@Autowired
	private PageService pServ;
	
	@PostMapping(value="/login", produces="application/json")
	public  User userLogin(@RequestBody UserImpl user) {
		String uName = user.getuName();
		String pWord = user.getpWord();
		User u = uServ.login(uName, pWord);
		return u;
	}
	
	@PostMapping(value="/user/jmart/page", produces="appliction/json")
	public Page getPage(@RequestBody Page page, @PathVariable String uName) {
		String pName = page.getpName();
		Page p = pServ.getPageByName(pName);
		return p;
	}
}
