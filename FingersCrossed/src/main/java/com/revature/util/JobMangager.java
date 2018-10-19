package com.revature.util;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.revature.job.MonthlyJobs;

@WebListener
public class JobMangager implements ServletContextListener {

	private ScheduledExecutorService scheduler;
	
	private static final int MIN_TO_DAY = 1440;
	
	private static final int MIN_TO_HOUR = 60;
	
	public void contextInitialized(ServletContextEvent sce) {
		scheduler = Executors.newSingleThreadScheduledExecutor();
		// Checks all of the monthly jobs to see if they need to be ran
		scheduler.scheduleAtFixedRate(new MonthlyJobs(), 
				getMinsToMidnight(), MIN_TO_DAY, TimeUnit.MINUTES);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		scheduler.shutdownNow();
	}
	
	/**
	 * Gets the number of minutes to midnight
	 * @return The number of minutes until midnight of the next day
	 */
	private long getMinsToMidnight() {
		return MIN_TO_DAY - (getTotalMins(
				LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()));
	}
	
	/**
	 * Gets the total minutes given the hours and minutes
	 * @param hours The amount of hours
	 * @param minutes The amount of minutes
	 * @return The amount of minutes represented by the hours and minutes
	 */
	private long getTotalMins(long hours, long minutes) {
		return (hours * MIN_TO_HOUR) + minutes;
	}

}
