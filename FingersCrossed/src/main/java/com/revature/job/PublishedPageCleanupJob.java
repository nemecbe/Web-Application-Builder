package com.revature.job;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.PublishedPage;
import com.revature.interfaces.PublishedPageService;

@Service
public class PublishedPageCleanupJob implements Runnable {
	
	@Autowired
	private PublishedPageService  pps;

	public void run() {
		// TODO Auto-generated method stub
		Set<PublishedPage> toDelete = new HashSet<PublishedPage>();
		for(PublishedPage pp: pps.getAllPages()) {
			if(!pp.isActive()) {
				toDelete.add(pp);
			}
		}
		for(PublishedPage pp: toDelete) {
			pps.takeDownPage(pp);
		}
	}

}
