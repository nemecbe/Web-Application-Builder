package com.petTravel.pet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petTravel.pet.domain.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

	
}
