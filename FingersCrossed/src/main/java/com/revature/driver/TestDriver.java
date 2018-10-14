package com.revature.driver;

import com.revature.beans.UserImpl;
import com.revature.daos.UserDAO;
import com.revature.interfaces.User;
import com.revature.interfaces.UserService;
import com.revature.services.UserServiceImpl;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new UserImpl();
		u1.setId(1);
		u1.setuName("jmart");
		u1.setfName("jason");
		u1.setlName("martinez");
		u1.seteMail("jamama");
		u1.setpWord("pass");
		
		User u2 = new UserImpl();
		u2.setId(2);
		u2.setuName("sum1");
		u2.setfName("summer");
		u2.setlName("turner");
		u2.seteMail("what");
		u2.setpWord("ever");
		
		User u3 = new UserImpl();
		u3.setId(1);
		u3.setuName("jmart");
		u3.setfName("jason");
		u3.setlName("martinez");
		u3.seteMail("jamama");
		u3.setpWord("pass");
			
		System.out.println("u1 = u2; " + u1.equals(u2));
		System.out.println("u1 = u1; " + u1.equals(u1));
		System.out.println("u1 = u3; " + u1.equals(u3));
	}
}
