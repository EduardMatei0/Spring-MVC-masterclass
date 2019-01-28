package com.eduardmatei.spring.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrganizationRegistrationService {
	
	
	@Value("#{serviceLengthOptions}")
	private Map<String, String> serviceLenghtList;
	
	public Map<String, String> populateTurnover() {
		
		Map<String, String> turnover = new LinkedHashMap<>();
		turnover.put("none", "----SELECT----");
		turnover.put("1000", "Less than $1000");
		turnover.put("10000", "Greater than $1000 but less than $10,000");
		turnover.put("100000", "Greater than $10000 but less than $10,0000");
		
		return turnover;
	}
	
	
	public Map<String, String> populateTypes() {
		
		Map<String, String> types = new LinkedHashMap<>();
		types.put("none", "----SELECT----");
		types.put("gov", "Goverment");
		types.put("semi-gov", "Semi-goverment");
		types.put("private", "Private");
		
		return types;
	}
	
	public Map<String, String> populateServiceLength() {
		return new TreeMap<>(serviceLenghtList);
	}
	
	public Map<String, String> populateRegisteredPreviosly() {
		
		Map<String, String> registered = new LinkedHashMap<>();
		registered.put("true", "yes");
		registered.put("false", "no");	
		
		return registered;
		
	}
	
	public Map<String, String> populateOptionalServices() {
		
		Map<String, String> optionalServices = new LinkedHashMap<>();
		optionalServices.put("emailService", "Mailing List");
		optionalServices.put("promotionalService", "Promotional Emails");
		optionalServices.put("newsLetterService", "Weekly Newsletter");
		
		return optionalServices;
		
	}
	
	public Map<String, String> populatePremiumServices() {
		
		Map<String, String> premiumServices = new LinkedHashMap<>();
		premiumServices.put("directoryService", "Directory");
		premiumServices.put("revenueReportService", "Revenue Reports");
		premiumServices.put("revenueAnalyticsService", "Revenue Analytics");
		
		return premiumServices;
		
	}
	
	public Map<String, String> populateEmployeeStrength() {
		
		Map<String, String> employeeStrength = new LinkedHashMap<>();
		employeeStrength.put("small", "Less than 100");
		employeeStrength.put("medium", "Greater than or equal to 100 but less than 1000");
		employeeStrength.put("large", "1000 or more");
		
		return employeeStrength;
		
	}
}
