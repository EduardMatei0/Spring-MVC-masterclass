package com.eduardmatei.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardmatei.spring.dao.OrganizationDao;
import com.eduardmatei.spring.domain.Organization;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationDao organizationDao;
	
	public List<Organization> getOrganizationList() {
		return organizationDao.getAllOrganizations();
	}
	
}
