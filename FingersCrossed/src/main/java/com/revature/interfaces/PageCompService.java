package com.revature.interfaces;

import java.util.List;

import com.revature.beans.PageComp;

public interface PageCompService {
	
	public PageComp getCompById(Integer dcId);

	public PageComp getCompByName(String dcName);
	
	public void setDao(DAO<PageComp> t);
	
	public List<PageComp> getAllCompForId(Integer puId);
	
	public void updatePageComp(PageComp comp);

}
