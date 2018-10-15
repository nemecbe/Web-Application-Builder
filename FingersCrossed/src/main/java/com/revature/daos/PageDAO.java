package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.PageImpl;
import com.revature.interfaces.DAO;
import com.revature.interfaces.Page;
import com.revature.util.SessionUtil;

public class PageDAO implements DAO<Page> {
	
	private Session sess;
	
	public PageDAO() {
		sess = SessionUtil.getSession();
	}
	

	public Page getById(Integer pId) {
		List<Object> oList = sess.createCriteria(PageImpl.class).add(Restrictions.eq("pId", pId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		Page p = (Page) oList.get(0);
		return p;
	}

	public Page getByName(String pId) {
		List<Object> oList = sess.createCriteria(PageImpl.class).add(Restrictions.eq("pName", pId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		Page p = (Page) oList.get(0);
		return p;
	}

	public void create(Page p) {
		// TODO Auto-generated method stub
		
	}

	public List<Page> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Page p) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Page p) {
		// TODO Auto-generated method stub
		
	}

	public boolean contains(Page p) {
		// TODO Auto-generated method stub
		return false;
	}

}
