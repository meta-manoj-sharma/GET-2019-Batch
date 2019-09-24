package com.metacube.parking.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.metacube.parking.dao.ConnectionClass;
import com.metacube.parking.dto.dtoEmployee;
import com.metacube.parking.facade.DtoEmployeeMapper;
import com.metacube.parking.facade.DtoLinkedListOfEmployeeMapper;
import com.metacube.parking.facade.SingleStringMapper;
import com.metacube.parking.model.Employee;

public class EmployeeDAO {
	
	static JdbcTemplate jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionClass.getConnection() , true));
	
	public boolean insertEmployee(Employee employee) throws SQLException,Exception{
		
		jdbcTemplate.update(DatabaseQuery.getInsertionQuery(),employee.getFullName(), employee.getGender() ,employee.getEmail()
																,employee.getPassword() ,employee.getContactNumber()
																,employee.getOrganization() ,employee.getProfilePhtotoUrl());
		return true;
	}
	
	public static dtoEmployee getUserProfile(String email) throws SQLException,Exception   {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getUserProfile(),new Object[] { email }, new DtoEmployeeMapper());
	}
	
	public static LinkedList<dtoEmployee> getFriendsProfile(String email) throws SQLException,Exception{
		
		String company = jdbcTemplate.queryForObject(DatabaseQuery.getCompany(),new Object[] { email }, new SingleStringMapper());
		System.out.println(company);
		return jdbcTemplate.queryForObject(DatabaseQuery.getFriendProfile(),new Object[] { company,email }, new DtoLinkedListOfEmployeeMapper());
	}
	
	public boolean updateEmployee(String email, dtoEmployee dtoemployee) throws Exception {
		
		jdbcTemplate.update(DatabaseQuery.getEmployeeUpdationQuery(), dtoemployee.getFullName(), dtoemployee.getGender()
				,dtoemployee.getContactNumber(), dtoemployee.getOrganization(), email);
		return true;
	}
	
	public static String getPhotoUrl(String email) throws Exception {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getUrlQuery(),new Object[] { email }, new SingleStringMapper());
	}
	
	public static boolean updatePhotoUrl(String url, String email) throws Exception {
		
		jdbcTemplate.update(DatabaseQuery.getPhotoUpdationQuery(), url, email );
		return true;
	}
	
	public static String getName(String email) {
		
		return jdbcTemplate.queryForObject(DatabaseQuery.getNameQuery(),new Object[] { email }, new SingleStringMapper());
	}
}
