package com.metacube.parking.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.springframework.jdbc.core.RowMapper;
import com.metacube.parking.dto.dtoEmployee;

public class DtoLinkedListOfEmployeeMapper implements RowMapper<LinkedList<dtoEmployee>> {

	@Override
	public LinkedList<dtoEmployee> mapRow(ResultSet result, int rowNum) throws SQLException {
		LinkedList<dtoEmployee> list = new LinkedList<dtoEmployee>();
		do
		{
			dtoEmployee employee = new dtoEmployee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
			System.out.println(employee.toString());
			list.add(employee);
		}
		while(result.next());
		return list;
	}
}