package com.metacube.parking.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.metacube.parking.dao.ConnectionClass;
import com.metacube.parking.facade.SingleStringMapper;

public class ParkingDAO {
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionClass.getConnection() , true));
	
	public boolean checkAuthentication(String email, String password) throws SQLException,Exception{
		
		String extractedPassword = jdbcTemplate.queryForObject(DatabaseQuery.getPassword(),new Object[] { email }, new SingleStringMapper());
		boolean flag = false;
		if(extractedPassword.equals(password)) {
			flag=true;
		}
		return flag;
	}
}