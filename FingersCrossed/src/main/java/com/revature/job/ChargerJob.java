package com.revature.job;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.interfaces.UserService;

@Service
public class ChargerJob implements Runnable {

	private static final double RATE = 75.0;

	@Autowired
	private UserService uServ;

	public void run() {
		// TODO Auto-generated method stub
		for (User user : uServ.getAllUsers()) {
			//chargeUser(user);
			//uServ.updateUser(user);
		}
	}
/*
	private void chargeUser(User user) {
		user.setTotalCharge(user.getTotalCharge()
				+ toCurrency(calculateCharge(
						user.getPageCount())
						)
				);
	}
*/
	private double calculateCharge(int pages) {
		return pages * RATE;
	}

	private double toCurrency(double amount) {
		return ((int) (amount * 100)) / 100.0;
	}

}
