package com.revature.driver;

import com.revature.beans.DefinedComp;
import com.revature.daos.PageCompDAO;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PageCompDAO pcd = new PageCompDAO();
		
		DefinedComp dc = null;
		dc = pcd.getById(1).getCompId();
		//System.out.println(dc);
		
		System.out.println(pcd.getAll());
	}
}
