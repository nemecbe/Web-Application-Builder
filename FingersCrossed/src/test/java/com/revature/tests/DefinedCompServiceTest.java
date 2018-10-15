package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.beans.DefinedCompImpl;
import com.revature.daos.DefinedCompDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.DefinedComp;
import com.revature.interfaces.DefinedCompService;
import com.revature.services.DefinedCompServiceImpl;

public class DefinedCompServiceTest {

	private static DAO<DefinedComp> dcDAO;
	private static DefinedCompService dcs;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dcDAO = Mockito.mock(DefinedCompDAO.class);
		dcs = new DefinedCompServiceImpl();
		dcs.setDao(dcDAO);
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
	public void testGetCompByName() {
		DefinedComp dc1 = new DefinedCompImpl(1, "bigButton", "button");
		Mockito.when(dcDAO.getByName(dc1.getCompName())).thenReturn(dc1);
		DefinedComp dc2 = dcs.getCompByName(dc1.getCompName());
		assertEquals("Testing getCompByName", dc1, dc2);
	}

}
