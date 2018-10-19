package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Page;
import com.revature.beans.PublishedPage;
import com.revature.interfaces.DAO;
import com.revature.interfaces.PublishedPageService;

@Service
public class PublishedPageServiceImpl implements PublishedPageService {
	
	@Autowired
	private DAO<PublishedPage> ppDao;

	public List<PublishedPage> getAllPages() {
		// TODO Auto-generated method stub
		return ppDao.getAll();
	}

	public PublishedPage getPage(String name) {
		// TODO Auto-generated method stub
		return ppDao.getByName(name);
	}

	public PublishedPage getPage(Integer pId) {
		// TODO Auto-generated method stub
		return ppDao.getById(pId);
	}

	public void publishPage(Page page, String name) {
		// TODO Auto-generated method stub
		PublishedPage pp = new PublishedPage();
		pp.setActive(true);
		pp.setUser(page.getPuId());
		pp.setPageId(page.getpId());
		pp.setPageName(name);
		ppDao.create(pp);
	}

	public void updatePage(PublishedPage page) {
		// TODO Auto-generated method stub
		ppDao.update(page);
	}

	public void takeDownPage(PublishedPage page) {
		// TODO Auto-generated method stub
		ppDao.delete(page);
	}

}
