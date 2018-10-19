package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Page;
import com.revature.beans.User;
import com.revature.interfaces.PageService;
import com.revature.interfaces.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private PageService pServ;
	
	@Autowired
	private UserService uServ;
	
	@Deprecated(/*Future implementation*/)
	@PostMapping(value="/user")
	public void registerUser(@RequestBody User user) {
		uServ.addUser(user);
	}
	
	@GetMapping(value="/user/{uName}/page", produces="application/json")
	public List<Page> getPage(@PathVariable String uName) {
		User u = uServ.getByName(uName);
		Integer puId = 0;
		if (u != null && uName.equals(u.getuName())) {
			puId = u.getId();
		}
		List<Page> pList = pServ.getAllPagesForId(puId);
		return pList;
	}
	
	@PostMapping(value="/user/{uname}/page")
	public void createPage(@PathVariable(name="uname") String uname,
			@RequestBody Page page) {
		pServ.createPage(page);
	}
	
	@PutMapping(value="/user/{uname}")
	public void updateInfo(@RequestBody User user) {
		uServ.updateUser(user);
	}
}
