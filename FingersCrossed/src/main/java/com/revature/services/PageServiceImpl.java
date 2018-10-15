package com.revature.services;

import com.revature.interfaces.DAO;
import com.revature.interfaces.DefinedComp;
import com.revature.interfaces.Page;
import com.revature.interfaces.PageService;

public class PageServiceImpl implements PageService {

	private DAO<Page> pDao;
	
	public Page getPageById(Integer dcId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getPageByName(String dcName) {
		// TODO Auto-generated method stub
		Page p = pDao.getByName(dcName);
		return p;
	}

	public void setDao(DAO<Page> pDao) {
		// TODO Auto-generated method stub
		this.pDao = pDao;
	}

}
