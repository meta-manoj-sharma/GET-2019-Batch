package com.metacube.parking.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.parking.dto.dtoEmployee;

public class DtoEmployeeMapper implements RowMapper<dtoEmployee> {

	@Override
	public dtoEmployee mapRow(ResultSet result, int rowNum) throws SQLException {
		System.out.println(result.getString(1));
		dtoEmployee employee = new dtoEmployee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
		return employee;
	}
}