package com.petTravel.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petTravel.travel.dao.TravelRepository;
import com.petTravel.travel.domain.Travel;

@Service
public class TravelServiceImpl implements TravelService {
	
	@Autowired
	TravelRepository tr;

	@Override
	public void createTravel(Travel t) {
		// TODO Auto-generated method stub
		tr.save(t);
	}

	@Override
	public Travel getTravel(Integer id) {
		// TODO Auto-generated method stub
		return tr.findOne(id);
	}

	@Override
	public void updateTravel(Travel t) {
		// TODO Auto-generated method stub
		tr.save(t);
	}

	@Override
	public void deleteTravel(Travel t) {
		// TODO Auto-generated method stub
		tr.delete(t);
	}

	@Override
	public List<Travel> getAllTravel() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

}
