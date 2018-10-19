package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.DefinedComp;
import com.revature.interfaces.DefinedCompService;

@RestController
@RequestMapping(value="component")
public class ComponentController {
	
	@Autowired
	private DefinedCompService dcs;
	
	@GetMapping
	public List<DefinedComp> getDefinedComponents(){
		return dcs.getAllComps();
	}

}
