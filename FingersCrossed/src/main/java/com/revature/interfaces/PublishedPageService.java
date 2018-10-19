package com.revature.interfaces;

import java.util.List;

import com.revature.beans.Page;
import com.revature.beans.PublishedPage;

public interface PublishedPageService {

	public List<PublishedPage> getAllPages();
	
	public PublishedPage getPage(String name);
	
	public PublishedPage getPage(Integer pId);
	
	public void publishPage(Page page, String name);
	
	public void updatePage(PublishedPage page);
	
	public void takeDownPage(PublishedPage page);
	
}
