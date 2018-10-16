package com.revature.daos;

import java.util.List;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.PageImpl;
import com.revature.beans.UserImpl;
import com.revature.interfaces.DAO;
import com.revature.interfaces.Page;
import com.revature.interfaces.User;
import com.revature.util.SessionUtil;

public class UserDAO implements DAO<User> {

private Session sess;
	
	public UserDAO() {
		sess = SessionUtil.getSession();
	}

	public void create(User u) {
		// TODO Auto-generated method stub
		sess.save(u);
		sess.flush();
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User u) {
		// TODO Auto-generated method stub
		
	}	
	
	public boolean contains(User u) {
		return sess.contains(u);
	}

	@SuppressWarnings("unchecked")
	public List<User> getByColumn(String colName, Object o) {
		// TODO Auto-generated method stub
		List<Object> oList = sess.createCriteria(UserImpl.class).add(Restrictions.eq(colName, o)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		return (List<User>)(List<?>)oList;
	}

	public User getById(Integer uId) {
		// TODO Auto-generated method stub
		List<Object> oList = sess.createCriteria(PageImpl.class).add(Restrictions.eq("id", uId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		User u = (User) oList.get(0);
		return u;
	}

	public User getByName(String uName) {
		// TODO Auto-generated method stub
		List<Object> oList = sess.createCriteria(UserImpl.class).add(Restrictions.eq("uName", uName)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		User u = (User) oList.get(0);
		return u;
	}
}
