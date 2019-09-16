package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.parking.dao.ConnectionClass;
import com.metacube.parking.model.Plan;

public class PlanDAO {
	/**
	 * 
	 * @param plan
	 * @param email
	 * @param index
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean insertPlan(Plan plan , String email , int index) throws Exception{
		
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getPlanInsertionQuery());
			prepareStatement.setInt(1,index);
			prepareStatement.setString(2,email);
			prepareStatement.setString(3,plan.getCurrency());
			prepareStatement.setString(4,plan.getPrice());
			prepareStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}