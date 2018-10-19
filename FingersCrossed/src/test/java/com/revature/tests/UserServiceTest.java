package com.revature.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.beans.User;
import com.revature.interfaces.DAO;
import com.revature.services.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	private DAO<User> userDao;
	
	@InjectMocks
	private UserServiceImpl userServ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
/*
	@Test
	public void testLogin() {
		User u = new User(1, "jmart", "Jason", "Martinez", "jmart@email.com", "password");
		Mockito.when(userDao.getByName("jmart")).thenReturn(u);
		assertEquals("Testing Login", u, userServ.login("jmart", "password"));
	}

	@Test
	public void testGetByName() {
		User u = new User(1, "jmart", "Jason", "Martinez", "jmart@email.com", "password");
		Mockito.when(userDao.getByName("jmart")).thenReturn(u);
		assertEquals("Testing Login", u, userServ.getByName("jmart"));
	}

	@Test
	public void testGetById() {
		User u = new User(1, "jmart", "Jason", "Martinez", "jmart@email.com", "password");
		Mockito.when(userDao.getById(1)).thenReturn(u);
		assertEquals("Testing Login", u, userServ.getById(u));
	}

	@Test
	public void testAddUser() {
		User u = new User(1, "jmart", "Jason", "Martinez", "jmart@email.com", "password");
		InOrder inOrder = Mockito.inOrder(userDao);
		inOrder.verify(userDao, Mockito.calls(1)).create(u);
	}
//	Currently Unused tests
//	@Test
//	public void testGetSess() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetSess() {
//		fail("Not yet implemented");
//	}
*/
}
