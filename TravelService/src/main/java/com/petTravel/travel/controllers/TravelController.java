package com.petTravel.travel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petTravel.travel.domain.Travel;
import com.petTravel.travel.services.TravelService;

@RestController
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	TravelService ts;
	
	@GetMapping()
	public List<Travel> getTravel() {
		return ts.getAllTravel();
	}
	
	@GetMapping ("{id}")
	public Travel GetTravel(@PathVariable("id") Integer id) {
		return ts.getTravel(id);
	}
	
	@PostMapping()
	public void makeTravel(@RequestBody Travel p) {
		ts.createTravel(p);
	}
	@PutMapping("{id}")
	public void updateTravel(@PathVariable("id") Integer id, @RequestBody Travel p) {
		p.setId(id);
		ts.updateTravel(p);
	}
}
