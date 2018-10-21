package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.beans.Page;
import com.revature.beans.PageComp;
import com.revature.interfaces.DAO;
import com.revature.util.SessionUtil;

@Repository
public class PageCompDAO implements DAO<PageComp> {
	
	private Session sess;
	
	public PageCompDAO() {
		sess = SessionUtil.getSession();
	}

	public PageComp getById(Integer tId) {
		// TODO Auto-generated method stub
		return sess.get(PageComp.class, tId);
	}

	@Deprecated(/* Not Used */)
	public PageComp getByName(String tName) {
		return null;
	}

	public void create(PageComp t) {
		// TODO Auto-generated method stub
		if(t != null) {
			sess.save(t);
		}
	}

	/**
	 * @param colName = "page_id"
	 * @param o = integer representing the page
	 */
	public List<PageComp> getByColumn(String colName, Object o) {
		List<Object> oList = sess.createCriteria(PageComp.class).add(Restrictions.eq(colName, o)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		return (List<PageComp>)(List<?>)oList;
	}

	public void update(PageComp t) {
		// TODO Auto-generated method stub
		sess.saveOrUpdate(t);
	}

	public void delete(PageComp t) {
		// TODO Auto-generated method stub
		sess.remove(t);
	}

	public boolean contains(PageComp t) {
		// TODO Auto-generated method stub
		return sess.contains(t);
	}

	public List<PageComp> getAll() {
		// TODO Auto-generated method stub
		return sess.createCriteria(PageComp.class).list();
	}

}
