package com.metacube.parking.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SingleStringMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet result, int rowNum) throws SQLException {
		return result.getString(1);
	}
}