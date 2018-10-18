package com.petTravel.travel;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.petTravel.travel.dao.TravelRepository;
import com.petTravel.travel.domain.Travel;
import com.petTravel.travel.services.TravelServiceImpl;
@RunWith(MockitoJUnitRunner.class)

public class TravelServiceTest {
	
	@Mock
	TravelRepository tr;
	
	@InjectMocks
	TravelServiceImpl ts;
	
	static Travel travel;
	
	static List<Travel> tList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tList = new ArrayList<Travel>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		travel = new Travel(0, "Hawaii", "Tampa", "10/31/2018");
		tList.add(travel);
		
		when(tr.findOne(0)).thenReturn(travel);
		when(tr.findAll()).thenReturn(tList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void makeTravelTest() {
		ts.createTravel(travel);
		verify(tr).save(travel);
	}
	
	@Test
	public void updateTravelTest() {
		ts.updateTravel(travel);
		verify(tr).save(travel);
	}
	
	@Test
	public void deleteTravelTest() {
		ts.deleteTravel(travel);
		verify(tr).delete(travel);
	}
	
	@Test
	public void readTravelTest() {
		assertEquals(ts.getTravel(0), travel);
	}
	
	@Test
	public void getAllTravelTest() {
		assertEquals(ts.getAllTravel(), tList);
	}

}
