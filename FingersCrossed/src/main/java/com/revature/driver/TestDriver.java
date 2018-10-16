package com.revature.driver;

import java.util.List;

import com.revature.beans.PageImpl;
import com.revature.daos.PageDAO;
import com.revature.interfaces.Page;
import com.revature.interfaces.PageService;
import com.revature.services.PageServiceImpl;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PageService psi = new PageServiceImpl();
		psi.setDao(new PageDAO());
		Integer puId = 1;
		List<Page> pList = psi.getAllPagesForId(puId);
		for (Page p : pList) {
			System.out.println(p);
		}
	}
}
