package com.eduardmatei.spring.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eduardmatei.spring.domain.Address;

@Controller
public class ModelController {
	
	private static Logger logger = LoggerFactory.getLogger(ModelController.class); 
	
	@RequestMapping("/home")
	public String home() {
		logger.info("Inside home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}
	
	@RequestMapping("/home2")
	public ModelAndView home2() {
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("modelAttributeHome");
		modelAndView.addObject("address",new Address());
		return modelAndView;
	}
	
	@RequestMapping("/home3")
	public ModelAndView home3() {
		ModelAndView modelAndView= new ModelAndView("modelAttributeHome");
		modelAndView.addObject("anAddress",new Address());
		return modelAndView;
	}
	
	@RequestMapping("/home4")
	public ModelAndView home4() {		
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Melbourne", "21314"));
	}
	

	@RequestMapping("/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Brisbane", "123123"));
		return "modelAttributeHome";
	}
	
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		logger.info("Inside modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to model attribute Test Bed!");
		model.addAttribute("testdata1B", "We will test both usages of the Model Atribute");
	}
	
	@ModelAttribute(name="testdata2")
	public String modelAttributeTest2() {
		return "We will conduct a series of test here";
	}
	
	@ModelAttribute(value="testdata3")
	public Address modelAttributeTest3() {
		return new Address("Bucuresti", "5000");
	}
	
	@ModelAttribute
	public Address modelAttributeTest4() {
		return new Address("Sydney", "2000");
	}
	
	@PostMapping("/test5")
	public String modelAttributeTest5(@ModelAttribute("anAddress") Address address, ModelMap model) {
		model.addAttribute("testdata5A", address.getCity());
		model.addAttribute("testdata5B",address.getZipCode());
		return "modelAttributeTest";
	}
	
	@RequestMapping("/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address modelAttributeTest6() {
		return new Address("Ploiesti", "1234");
	}
}
