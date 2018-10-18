package com.petTravel.travel.services;

import java.util.List;

import com.petTravel.travel.domain.Travel;

public interface TravelService {

	public void createTravel(Travel t);
	
	public Travel getTravel(Integer id);
	
	public void updateTravel(Travel t);
	
	public void deleteTravel(Travel t);
	
	public List<Travel> getAllTravel();
}
