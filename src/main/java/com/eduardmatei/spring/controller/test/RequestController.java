package com.eduardmatei.spring.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value="/requestController")
@Controller
public class RequestController {

	private static Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	@RequestMapping(value="/home")
	public String home() {
		return "requestMapping";
	}
	
	@RequestMapping(value="/test1")
	public String requestMappingTest1(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value="/test2", method = RequestMethod.GET)
	public String requestMappingTest2(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";
	}
	
	
	@RequestMapping(value="*", method = RequestMethod.GET)
	public String requestMappingTest3() {
		return "fallback";
	}
	
	@RequestMapping(value="/test4")
	public String requestMappingTest4(@RequestParam(value = "orgname", defaultValue="Anonymous Organization") String orgName, Model model)  {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value="/test5", method = RequestMethod.GET)
	public String requestMappingTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test5");
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value="/test6", params = "orgname")
	public String requestMappingTest6Subtest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value="/test6", params = "empcount")
	public String requestMappingTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value="/test6/subtest3", method=RequestMethod.GET, params = {"orgname","empcount"})
	public String requestMappingTest6Subtest3(@RequestParam String orgname,@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("empCount", empcount);
		model.addAttribute("testserial", "test6-subtest3");
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value="/test6/subtest4", method=RequestMethod.GET, params = {"orgname","empcount"})
	public String requestMappingTest6Subtest4(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest4");
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value= {"/test7","/test8"}, method=RequestMethod.GET)
	public String requestMappingTest7and8(@RequestParam String orgname, Model model, HttpServletRequest request) {		
		model.addAttribute("orgname", orgname);		
		logger.info(request.getRequestURL().toString());
		
		if(request.getRequestURL().toString().contains("test7")) {
			model.addAttribute("testserial", "test7");
		} else {
			model.addAttribute("testserial", "test8");

		}
		
		return "requestMappingAndParamResults2";
	}
	
	
}
