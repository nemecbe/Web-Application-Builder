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

	public DefinedComp getByName(String dcId) {
		List<Object> oList = sess.createCriteria(DefinedCompImpl.class).add(Restrictions.eq("compName", dcId)).list();
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
		List<Object> oList = sess.createCriteria(DefinedCompImpl.class).add(Restrictions.eq("id", dcId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		DefinedComp dc = (DefinedComp) oList.get(0);
		return dc;
	}

	public List<DefinedComp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
