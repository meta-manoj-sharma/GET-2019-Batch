package com.metacube.parking.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.metacube.parking.dao.ConnectionClass;
import com.metacube.parking.facade.SingleStringMapper;
import com.metacube.parking.model.Vehicle;

public class VehicleDAO {
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionClass.getConnection() , true));
	
	public boolean insertVehicle(Vehicle vehicle , String email) throws SQLException,Exception{
		
		jdbcTemplate.update(DatabaseQuery.getVehicleInsertionQuery(), email, vehicle.getVehicleName(), vehicle.getVehicleType()
				,vehicle.getvehicleNumber(), vehicle.getEmployeeId(), vehicle.getVehicleDetails());
		return true;
	}
	
	public int getVehicleId(String email) throws SQLException,Exception{
		
		String vehicleId = jdbcTemplate.queryForObject(DatabaseQuery.getVehicleID(),new Object[] { email }, new SingleStringMapper());
		return Integer.parseInt(vehicleId);
	}
}