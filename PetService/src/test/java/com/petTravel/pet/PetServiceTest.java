package com.petTravel.pet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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

import com.petTravel.pet.dao.PetRepository;
import com.petTravel.pet.domain.Pet;
import com.petTravel.pet.services.PetServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceTest {

	@Mock
	PetRepository rp;
	
	@InjectMocks
	PetServiceImpl ps;
	
	private static Pet p;
	
	private static List<Pet> pList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.p = new Pet(1, "parakeet", "George", "7");
		
		this.pList.addAll(Arrays.asList(new Pet[] {this.p, new Pet()}));
		
		when (rp.findAll()).thenReturn(this.pList);
		
		when(rp.findOne(1)).thenReturn(this.p);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllPets() {
		assertEquals("Should get whole list of pets", this.pList, this.ps.getAllPets());
	}
	@Test
	public void testGetOnePet() {

		assertEquals("Should get a single pet", this.p, this.ps.getPet(1));
	}
	@Test
	public void testMakePet() {
		ps.makePet(this.p);
		verify(rp).save(p);
	}
	@Test
	public void testUpdatePet() {
		ps.updatePet(this.p);
		verify(rp).save(p);
	}
}
