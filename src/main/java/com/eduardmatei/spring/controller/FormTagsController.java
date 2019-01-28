package com.eduardmatei.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eduardmatei.spring.domain.test.OrganizationRegistration;
import com.eduardmatei.spring.service.OrganizationRegistrationService;

@Controller
@RequestMapping("/form")
public class FormTagsController {
	
	@Autowired
	private OrganizationRegistrationService orgRegService;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("test/formViews/formHome", "orgRegistration", new OrganizationRegistration());
	}
	
	@PostMapping("/registerOrg")
	public String organizationRegistration(@ModelAttribute OrganizationRegistration orgRegistration, Model model) {
		model.addAttribute("orgreg", orgRegistration);
		return "test/formViews/formResult";				
	}
	
	@ModelAttribute
	public void populateFormObjectWithData(Model model) {
		Map<String, Object> map = model.asMap();
		map.put("turnoverlist", orgRegService.populateTurnover());
		map.put("typeslist", orgRegService.populateTypes());
		map.put("serviceLengthList", orgRegService.populateServiceLength());
		map.put("registeredList", orgRegService.populateRegisteredPreviosly());
		map.put("subscriptionList", orgRegService.populateOptionalServices());
		map.put("premiumServiceList", orgRegService.populatePremiumServices());
		map.put("employeeStengthList", orgRegService.populateEmployeeStrength());
	}
}
