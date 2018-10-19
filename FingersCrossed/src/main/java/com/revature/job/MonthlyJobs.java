package com.revature.job;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

public class MonthlyJobs implements Runnable{
	
	@Autowired
	ChargerJob chargerJob;
	
	@Autowired
	PublishedPageCleanupJob publishedPageCleanupJob;

	public void run() {
		// TODO Auto-generated method stub
		if(firstOfMonth()) {
			new Thread(chargerJob).start();
			new Thread(publishedPageCleanupJob).start();
		}
	}

	private boolean firstOfMonth() {
		return LocalDate.now().getDayOfMonth() == 1;
	}
	
}
