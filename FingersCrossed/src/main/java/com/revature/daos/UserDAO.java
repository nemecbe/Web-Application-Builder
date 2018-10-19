package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.beans.Page;
import com.revature.beans.User;
import com.revature.interfaces.DAO;
import com.revature.util.SessionUtil;

@Repository
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
		return sess.createCriteria(User.class).list();
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		sess.saveOrUpdate(u);
	}

	public void delete(User u) {
		// TODO Auto-generated method stub
		sess.remove(u);
	}	
	
	public boolean contains(User u) {
		return sess.contains(u);
	}

	@SuppressWarnings("unchecked")
	public List<User> getByColumn(String colName, Object o) {
		// TODO Auto-generated method stub
		List<Object> oList = sess.createCriteria(User.class).add(Restrictions.eq(colName, o)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		return (List<User>)(List<?>)oList;
	}

	public User getById(Integer uId) {
		// TODO Auto-generated method stub
		List<Object> oList = sess.createCriteria(Page.class).add(Restrictions.eq("id", uId)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		User u = (User) oList.get(0);
		return u;
	}

	public User getByName(String uName) {
		// TODO Auto-generated method stub
		List<Object> oList = sess.createCriteria(User.class).add(Restrictions.eq("uName", uName)).list();
		if (oList.size() == 0) {
			System.out.println("nothing returned from list");
			return null;
		}
		User u = (User) oList.get(0);
		return u;
	}
}
