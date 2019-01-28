package com.eduardmatei.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.eduardmatei.spring.domain.Organization;

public interface OrganizationDao {
	
	// Set the data source
	public void setDataSource(DataSource dataSource);
	
	// Create the record
	public boolean create(Organization organization);
	
	// Retrieve a organization
	public Organization getOrganization(Integer id);
	
	// Retrieve all organizations
	public List<Organization> getAllOrganizations();
	
	// Delete an organization
	public boolean delete(Organization organization);
	
	// Update a record
	public boolean update(Organization organization);
	
	// Clean up
	public void cleanup();
}
