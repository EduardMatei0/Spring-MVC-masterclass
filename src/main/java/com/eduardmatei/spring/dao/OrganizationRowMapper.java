package com.eduardmatei.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eduardmatei.spring.domain.Organization;

public class OrganizationRowMapper implements RowMapper<Organization> {

	public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
		Organization organization = new Organization();
		
		organization.setId(rs.getInt("id"));
		organization.setCompanyName(rs.getString("company_name"));
		organization.setYearOfIncorporation(rs.getInt("year_of_incorporation"));
		organization.setPostalCode(rs.getString("postal_code"));
		organization.setEmployeeCount(rs.getInt("employee_count"));
		organization.setSlogan(rs.getString("slogan"));
		
		return organization;
	}
	
}
