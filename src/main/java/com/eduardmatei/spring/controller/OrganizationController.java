package com.eduardmatei.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduardmatei.spring.domain.Organization;
import com.eduardmatei.spring.service.OrganizationService;

@Controller
public class OrganizationController {
	
	private Logger logger= LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("/location")
	public String addLocation() {
		return "location";
	}
	
	@RequestMapping("/listOrgs")
	public String listOrganizations(Model model) {
		List<Organization> organizations = organizationService.getOrganizationList();
		model.addAttribute("orgList", organizations);
		logger.info("model={}", model);
		return "listOrganizations";
	}
}
