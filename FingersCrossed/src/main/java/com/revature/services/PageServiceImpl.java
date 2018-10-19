package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Page;
import com.revature.daos.PageDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.PageService;

@Service
public class PageServiceImpl implements PageService {

	private DAO<Page> pDao;
	
	public PageServiceImpl() {
		pDao = new PageDAO();
	}
	
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

	public List<Page> getAllPagesForId(Integer puId) {
		// TODO Auto-generated method stub
		List<Page> pList = pDao.getByColumn("puId", puId);
		return pList;
	}

	public void createPage(Page p) {
		// TODO Auto-generated method stub
		pDao.create(p);
	}
}
