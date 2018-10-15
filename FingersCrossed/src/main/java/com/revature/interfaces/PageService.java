package com.revature.interfaces;

public interface PageService {
	
	public Page getPageById(Integer dcId);

	public Page getPageByName(String dcName);
	
	public void setDao(DAO<Page> t);
}
