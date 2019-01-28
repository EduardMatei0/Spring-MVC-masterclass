package com.eduardmatei.spring.validation.test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailVerificationValidator implements ConstraintValidator<EmailVerification, String> {
	
	private String message;

	@Override
	public void initialize(EmailVerification constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		EmailValidator emailValidator = EmailValidator.getInstance();					
		return emailValidator.isValid(email);
	}
	
	
}
