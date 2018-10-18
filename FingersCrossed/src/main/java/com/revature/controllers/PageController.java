package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.interfaces.DefinedCompService;
import com.revature.interfaces.PageService;

@RestController
@CrossOrigin(origins="http:localhost:4200")
public class PageController {

	@Autowired
	private DefinedCompService pcs;
	
	@Autowired
	private PageService ps;
	
	@GetMapping(value="/user/{uname}/page/{pId}", produces="application/json")
	public List<> getComp(@PathVariable Integer pId, @PathVariable String uname) {a
		/*Integer puId = 0;
		if (page != null) {
			puId = page.getPuId();
		}*/
		
		List<> pcList = dcs.getAllCompForId(pId);
		return pcList;
	}
}
