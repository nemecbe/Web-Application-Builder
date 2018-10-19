package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.beans.DefinedComp;
import com.revature.interfaces.DAO;
import com.revature.util.SessionUtil;

@Repository
public class DefinedCompDAO implements DAO<DefinedComp> {
	
	private Session sess;
	
	public DefinedCompDAO() {
		sess = SessionUtil.getSession();
	}

	public DefinedComp getByName(String dcId) {
		List<Object> oList = sess.createCriteria(DefinedComp.class).add(Restrictions.eq("compName", dcId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		DefinedComp dc = (DefinedComp) oList.get(0);
		return dc;
	}

	public void create(DefinedComp dc) {
		// TODO Auto-generated method stub

	}

	public void update(DefinedComp dc) {
		// TODO Auto-generated method stub

	}

	public void delete(DefinedComp dc) {
		// TODO Auto-generated method stub

	}

	public boolean contains(DefinedComp dc) {
		// TODO Auto-generated method stub
		return false;
	}

	public DefinedComp getById(Integer dcId) {
		List<Object> oList = sess.createCriteria(DefinedComp.class).add(Restrictions.eq("dc_id", dcId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		DefinedComp dc = (DefinedComp) oList.get(0);
		return dc;
	}

	public List<DefinedComp> getAll() {
		// TODO Auto-generated method stub
		return sess.createCriteria(DefinedComp.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<DefinedComp> getByColumn(String colName, Object o) {
		// TODO Auto-generated method stub
		List<Object> oList = sess.createCriteria(DefinedComp.class).add(Restrictions.eq(colName, o)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		DefinedComp dc = (DefinedComp) oList.get(0);
		return (List<DefinedComp>)(List<?>)oList;
	}

}
