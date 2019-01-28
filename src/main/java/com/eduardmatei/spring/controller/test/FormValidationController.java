package com.eduardmatei.spring.controller.test;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eduardmatei.spring.domain.test.OrganizationRepresentative;

@Controller
@RequestMapping("/formValidationDemo")
public class FormValidationController {
	
	@RequestMapping("/home")
	public ModelAndView home(Model model) {
		return new ModelAndView("test/formValidationViews/formHome", "orgrep", new OrganizationRepresentative());
	}
	
	@PostMapping("/registerOrgRep")
	public String organizationRepresentativeRegistration(@Valid @ModelAttribute("orgrep") OrganizationRepresentative organizationRepresentative,
											BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("formerrors", result.getAllErrors());
			List<FieldError> ferrList = result.getFieldErrors();
			for (FieldError error: ferrList) {
				System.out.println("field error: " + error.getDefaultMessage());
			}
			
			List<ObjectError> gerrFeList = result.getGlobalErrors();
			for (ObjectError error: gerrFeList) {
				System.out.println("global error: " + error.getDefaultMessage());
			}
			
			return "test/formValidationViews/formHome";
		} else {
			return "test/formValidationViews/formResult";
		}
	}
}
