package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.DefinedCompImpl;
import com.revature.beans.UserImpl;
import com.revature.interfaces.DAO;
import com.revature.interfaces.DefinedComp;
import com.revature.interfaces.User;
import com.revature.util.SessionUtil;

public class DefinedCompDAO implements DAO<DefinedComp> {
	
	private Session sess;
	
	public DefinedCompDAO() {
		sess = SessionUtil.getSession();
	}

	public DefinedComp getByName(String tId) {
		List<Object> oList = sess.createCriteria(DefinedCompImpl.class).add(Restrictions.eq("compName", tId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		DefinedComp u = (DefinedComp) oList.get(0);
		return u;
	}

	public void create(DefinedComp t) {
		// TODO Auto-generated method stub

	}

	public void update(DefinedComp t) {
		// TODO Auto-generated method stub

	}

	public void delete(DefinedComp t) {
		// TODO Auto-generated method stub

	}

	public boolean contains(DefinedComp t) {
		// TODO Auto-generated method stub
		return false;
	}

	public DefinedComp getById(Integer tId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DefinedComp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
