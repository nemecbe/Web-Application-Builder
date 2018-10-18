package com.revature.interfaces;

import java.util.List;

public interface DefinedCompService {
	
	public DefinedComp getCompById(Integer dcId);

	public DefinedComp getCompByName(String dcName);
	
	public void setDao(DAO<DefinedComp> t);
	
	public List<DefinedComp> getAllCompForId(Integer puId);
}
