package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.PageComp;
import com.revature.interfaces.DAO;
import com.revature.interfaces.PageCompService;

@Service
public class PageCompServiceImpl implements PageCompService {
	
	@Autowired
	DAO<PageComp> pageCompDao;

	public PageComp getCompById(Integer dcId) {
		// TODO Auto-generated method stub
		return pageCompDao.getById(dcId);
	}

	public PageComp getCompByName(String dcName) {
		// TODO Auto-generated method stub
		return pageCompDao.getByName(dcName);
	}

	public void setDao(DAO<PageComp> t) {
		// TODO Auto-generated method stub
		this.pageCompDao = t;
	}

	public List<PageComp> getAllCompForId(Integer puId) {
		// TODO Auto-generated method stub
		return pageCompDao.getByColumn("pageId", puId);
	}
	
	public void updatePageComp(PageComp comp) {
		pageCompDao.update(comp);
	}

}
