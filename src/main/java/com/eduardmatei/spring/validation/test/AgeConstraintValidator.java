package com.eduardmatei.spring.validation.test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<AgeConstraint, Integer> {
	
	private int lower;
	private int higher;
	
	@Override
	public void initialize(AgeConstraint constraintAnnotation) {
		lower = constraintAnnotation.lower();
		higher = constraintAnnotation.higher();
	}
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		
		if(age == null) {
			return false;
		}
		
		if(age < lower || age > higher) {
			return false;
		}
		
		return true;
	}
	
	
}
