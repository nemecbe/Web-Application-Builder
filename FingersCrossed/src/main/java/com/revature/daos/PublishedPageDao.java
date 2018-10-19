package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.beans.PublishedPage;
import com.revature.interfaces.DAO;
import com.revature.util.SessionUtil;

@Repository
public class PublishedPageDao implements DAO<PublishedPage> {
	
	private Session sess;
	
	public PublishedPageDao() {
		sess = SessionUtil.getSession();
	}

	public PublishedPage getById(Integer tId) {
		// TODO Auto-generated method stub
		return sess.get(PublishedPage.class, tId);
	}

	public PublishedPage getByName(String tName) {
		List<Object> oList = sess.createCriteria(PublishedPage.class).add(Restrictions.eq("pageName", tName)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		PublishedPage p = (PublishedPage) oList.get(0);
		return p;
	}

	public void create(PublishedPage t) {
		// TODO Auto-generated method stub
		sess.save(t);
	}

	public List<PublishedPage> getByColumn(String colName, Object o) {
		List<Object> oList = sess.createCriteria(PublishedPage.class).add(Restrictions.eq(colName, o)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		return (List<PublishedPage>)(List<?>)oList;
	}

	public void update(PublishedPage t) {
		// TODO Auto-generated method stub
		sess.update(t);
	}

	public void delete(PublishedPage t) {
		// TODO Auto-generated method stub
		sess.delete(t);
	}

	public boolean contains(PublishedPage t) {
		// TODO Auto-generated method stub
		return sess.contains(t);
	}

	public List<PublishedPage> getAll() {
		// TODO Auto-generated method stub
		return sess.createCriteria(PublishedPage.class).list();
	}

}
