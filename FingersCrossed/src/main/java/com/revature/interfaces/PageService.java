package com.revature.interfaces;

import java.util.List;

import com.revature.beans.Page;

public interface PageService {
	
	public Page getPageById(Integer pId);

	public Page getPageByName(String pName);
	
	public List<Page> getAllPagesForId(Integer pId);
	
	public void setDao(DAO<Page> t);
	
	public void createPage(Page p);
}
