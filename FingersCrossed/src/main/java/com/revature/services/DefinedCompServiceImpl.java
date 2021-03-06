package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.DefinedCompImpl;
import com.revature.interfaces.DAO;
import com.revature.interfaces.DefinedComp;
import com.revature.interfaces.DefinedCompService;

@Service
public class DefinedCompServiceImpl implements DefinedCompService {

	private DAO<DefinedComp> dcDao;// = new DefinedCompDAO();
	
	public void setDao(DAO<DefinedComp> dcDao) {
		// TODO Auto-generated method stub
		this.dcDao = dcDao;
	}

	public DefinedComp getComp() {
		// TODO Auto-generated method stub
		return null;
	}

	public DefinedComp getCompById(Integer dcId) {
		// TODO Auto-generated method stub
		return null;
	}

	public DefinedComp getCompByName(String dcName) {
		// TODO Auto-generated method stub
		DefinedComp dc = dcDao.getByName(dcName);
		return dc;
	}
}
