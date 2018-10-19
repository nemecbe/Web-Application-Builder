package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.beans.Page;
import com.revature.interfaces.DAO;
import com.revature.util.SessionUtil;

@Repository
public class PageDAO implements DAO<Page> {
	
	private Session sess;
	
	public PageDAO() {
		sess = SessionUtil.getSession();
	}
	

	public Page getById(Integer pId) {
		List<Object> oList = sess.createCriteria(Page.class).add(Restrictions.eq("pId", pId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		Page p = (Page) oList.get(0);
		return p;
	}

	public Page getByName(String pId) {
		List<Object> oList = sess.createCriteria(Page.class).add(Restrictions.eq("pName", pId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		Page p = (Page) oList.get(0);
		return p;
	}

	public void create(Page p) {
		// TODO Auto-generated method stub
		sess.save(p);
	}

	public List<Page> getAll() {
		// TODO Auto-generated method stub
		return sess.createCriteria(Page.class).list();
	}

	public void update(Page p) {
		// TODO Auto-generated method stub
		sess.saveOrUpdate(p);
	}

	public void delete(Page p) {
		// TODO Auto-generated method stub
		sess.remove(p);
	}

	public boolean contains(Page p) {
		// TODO Auto-generated method stub
		return false;
	}


	@SuppressWarnings("unchecked")
	public List<Page> getByColumn(String colName, Object o) {
		// TODO Auto-generated method stub
		List<Object> oList = sess.createCriteria(Page.class).add(Restrictions.eq(colName, o)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		return (List<Page>)(List<?>)oList;
	}

}
