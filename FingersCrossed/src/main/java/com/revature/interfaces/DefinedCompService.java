package com.revature.interfaces;

import com.revature.beans.DefinedCompImpl;

public interface DefinedCompService {
	
	public DefinedComp getCompById(Integer dcId);

	public DefinedComp getCompByName(String dcName);
	
	public void setDao(DAO<DefinedComp> t);
}
