package com.eduardmatei.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.eduardmatei.spring.domain.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public boolean create(Organization organization) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(organization);
		String sqlQuery="INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
					"VALUES(:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";		
		return namedParameterJdbcTemplate.update(sqlQuery, paramSource) == 1;		
	}

	public Organization getOrganization(Integer id) {
		SqlParameterSource paramSource = new MapSqlParameterSource("ID", id);
		String sqlQuery="SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan " +
					 "FROM organization WHERE id = :ID";
		Organization organization = namedParameterJdbcTemplate.queryForObject(sqlQuery, paramSource, new OrganizationRowMapper());
		return organization;
		
	}

	public List<Organization> getAllOrganizations() {
		
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> organizations = namedParameterJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return organizations;
		
	}

	public boolean delete(Organization organization) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(organization);
		String sqlQuery = "DELETE FROM organization where id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, paramSource) == 1;
	}

	public boolean update(Organization organization) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(organization);
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, paramSource) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}
