package com.petTravel.pet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petTravel.pet.dao.PetRepository;
import com.petTravel.pet.domain.Pet;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetRepository pr;
	
	@Override
	public void makePet(Pet p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public List<Pet> getAllPets() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Pet getPet(Integer id) {
		// TODO Auto-generated method stub
		return pr.findOne(id);
	}

	@Override
	public void updatePet(Pet p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void killPet(Pet p) {
		// TODO Auto-generated method stub
		
	}

}
