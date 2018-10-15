package com.revature.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.beans.PageImpl;
import com.revature.daos.PageDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.Page;
import com.revature.interfaces.PageService;
import com.revature.services.PageServiceImpl;

public class PageServiceTest {
	
	private static DAO<Page> pDao;
	private static PageService ps;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pDao = Mockito.mock(PageDAO.class);
		ps = new PageServiceImpl();
		ps.setDao(pDao);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetByPageName() {
		Page p1 = new PageImpl(1, 1, "p1Name", true);
		Mockito.when(pDao.getByName(p1.getpName())).thenReturn(p1);
		Page p2 = ps.getPageByName(p1.getpName());
		assertEquals("Testing getPageByName", p1, p2);
	}

}
