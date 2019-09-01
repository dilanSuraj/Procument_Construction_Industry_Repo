package com.procument.construction.industry.app.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.procument.construction.industry.app.entity.Site;
import com.procument.construction.industry.app.respository.SiteRepository;

@RequestMapping(value = "/sites")
@Controller
public class SiteController {

	@Autowired
	private SiteRepository siteRepository;
	
	private static final String OBJECT_NOT_FOUND = "404 Object not found";

	public static final Logger log = Logger.getLogger(SiteController.class.getName());

	@PostMapping("/")
	public String addSite(@ModelAttribute(value = "siteObj") Site site) {
		siteRepository.save(site);
		log.info(site.toString() + "\n");
		return site.toString();
	}

	@GetMapping("/")
	public List<Site> findAllSites() {
		List<Site> siteList = (List<Site>) siteRepository.findAll();
		log.info(siteList.toString() + "\n");
		return siteList;
	}
	
	@GetMapping("/{siteid}")
	public Site findBySiteId(@RequestParam Long siteid) {
        Site site = siteRepository.findBySiteid(siteid);
        log.info(site.toString() + "\n");
        return site;
    }
	
	@PutMapping("/")
	public String updateSite(@ModelAttribute(value = "siteObj") Site site) {
		
		Site existingSiteObj = siteRepository.findBySiteid(site.getSiteid());
		
		if(existingSiteObj != null) {
			existingSiteObj.setBudget(site.getBudget());
			existingSiteObj.setLocation(site.getLocation());
			existingSiteObj.setEmployee_employee_id(site.getEmployee_employee_id());
			siteRepository.save(existingSiteObj);
			
			log.info(existingSiteObj.toString() + "\n");
			return existingSiteObj.toString();
		}
		log.info(OBJECT_NOT_FOUND + "\n");
		return OBJECT_NOT_FOUND;
	}
	
	@DeleteMapping("/{siteid}")
	public String deleteSite(@RequestParam Long siteid) {
		
		Site existingSiteObj = siteRepository.findBySiteid(siteid);
		
		if(existingSiteObj != null) {
			siteRepository.deleteBySiteid(siteid);			
			log.info(existingSiteObj.toString() + "\n");
			return existingSiteObj.toString();
		}
		log.info(OBJECT_NOT_FOUND + "\n");
		return OBJECT_NOT_FOUND;
	}
}
