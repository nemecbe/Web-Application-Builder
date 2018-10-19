package com.revature.job;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.interfaces.UserService;

public class UserTimeoutJob implements Runnable {
	
	@Autowired
	UserService uServ;

	public void run() {
		// TODO Auto-generated method stub
		if(uServ.isInactive()) {
			uServ.setCurrentUser(null);
		}
		uServ.setInactive(true);
	}

}
