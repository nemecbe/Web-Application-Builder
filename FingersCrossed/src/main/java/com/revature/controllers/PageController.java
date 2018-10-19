package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.beans.Page;
import com.revature.beans.PageComp;
import com.revature.beans.PublishedPage;
import com.revature.interfaces.PageCompService;
import com.revature.interfaces.PageService;
import com.revature.interfaces.PublishedPageService;
import com.revature.interfaces.UserService;

@RestController
@CrossOrigin(origins="http:localhost:4200")
public class PageController {

	@Autowired
	private PageCompService pcs;
	
	@Autowired
	private PageService ps;
	
	@Autowired
	private PublishedPageService pps;
	
	@Autowired
	private UserService uServ;
	
	@GetMapping(value="/user/{uname}/page/{pId}", produces="application/json")
	public List<PageComp> getComp(@PathVariable(name="pId") Integer pId, 
			@PathVariable(name="uname") String uname) {
		/*Integer puId = 0;
		if (page != null) {
			puId = page.getPuId();
		}*/
		if(uServ.getCurrentUser() != null && uServ.getCurrentUser().getuName().equals(uname)) {
			List<PageComp> pcList = pcs.getAllCompForId(pId);
			return pcList;
		}
		return null;
	}
	
	@PostMapping(value="/user/{uname}/page/{pId}/component")
	public void setComps(@PathVariable(name="uname") String uname,
			@PathVariable(name="pId") Integer pId, @RequestBody List<PageComp> comps) {
		if(uServ.getCurrentUser() != null && uServ.getCurrentUser().getuName().equals(uname)) {
			for(PageComp comp: comps) {
				comp.setPageId(pId);
				pcs.updatePageComp(comp);
			}
		}
	}
	
	@GetMapping(value="/page")
	public List<PublishedPage> getPublishedPages(){
		if(uServ.getCurrentUser() != null)
			return pps.getAllPages();
		return null;
	}
	
	@GetMapping(value="/page/{pId}")
	public PublishedPage getPublishedPage(@PathVariable(name="pId") Integer pId) {
		if(uServ.getCurrentUser() != null)
			return pps.getPage(pId);
		return null;
	}
	
	@PostMapping(value="/page/{name}")
	public void publishPage(@PathVariable(name="name") String name, @RequestBody Page page) {
		if(uServ.getCurrentUser() != null)
			pps.publishPage(page, name);
	}
	
	@PutMapping(value="/page/{pId}")
	public void updatePage(@PathVariable(name="pId") Integer pId,
			@RequestBody PublishedPage page) {
		if(uServ.getCurrentUser() != null) {
			page.setPublishedId(pId);
			pps.updatePage(page);
		}
	}
	
	@DeleteMapping(value="/page/{pId}")
	public void takeDownPage(@PathVariable(name="pId") Integer pId,
			@RequestBody PublishedPage page) {
		if(uServ.getCurrentUser() != null)
			pps.takeDownPage(page);
	}
}
