package com.petTravel.pet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petTravel.pet.domain.Pet;
import com.petTravel.pet.services.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	PetService ps;
	
	@GetMapping()
	public List<Pet> getPets() {
		return ps.getAllPets();
	}
	
	@GetMapping ("{id}")
	public Pet GetPet(@PathVariable("id") Integer id) {
		return ps.getPet(id);
	}
	
	@PostMapping()
	public void makePet(@RequestBody Pet p) {
		ps.makePet(p);
	}
	@PutMapping("{id}")
	public void updatePet(@PathVariable("id") Integer id, @RequestBody Pet p) {
		p.setId(id);
		ps.updatePet(p);
	}
}
