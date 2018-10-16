package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.interfaces.Page;
import com.revature.interfaces.PageService;
import com.revature.interfaces.User;
import com.revature.interfaces.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private PageService pServ;
	
	@Autowired
	private UserService uServ;
	
	@GetMapping(value="/user/{uName}/page", produces="application/json")
	public List<Page> getPage(@PathVariable String uName) {
		User u = uServ.getByName(uName);
		Integer puId = 0;
		System.out.println(u);
		if (u != null && uName.equals(u.getuName())) {
			puId = u.getId();
		}
		List<Page> pList = pServ.getAllPagesForId(puId);
		return pList;
	}
}
