package com.revature.interfaces;

import java.util.List;

public interface DAO<T> {

	/**
	 * Searches the DataBase for T with id = tId
	 * and returns the object if found, else returns null
	 * @param tId
	 * @return
	 */	
	public T getById(Integer tId);
	
	public T getByName(String tName);
	
	public void create(T t);
	
	public List<T> getByColumn(String colName, Object o);
	
	public void update(T t);
	
	public void delete(T t);
	
	public boolean contains(T t);
}
