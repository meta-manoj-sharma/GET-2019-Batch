package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.metacube.parking.dao.ConnectionClass;
import com.metacube.parking.dto.dtoEmployee;
import com.metacube.parking.model.Employee;

public class EmployeeDAO {
	/**
	 * 
	 * @param employee
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean insertEmployee(Employee employee) throws Exception{
		
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getInsertionQuery());
			prepareStatement.setString(1,employee.getFullName());
			prepareStatement.setString(2,employee.getGender());
			prepareStatement.setString(3,employee.getEmail());
			prepareStatement.setString(4,employee.getPassword());
			prepareStatement.setString(5,employee.getContactNumber());
			prepareStatement.setString(6,employee.getOrganization());
			prepareStatement.setString(7,employee.getProfilePhtotoUrl());
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
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static dtoEmployee getUserProfile(String email) throws Exception   {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		ResultSet result;
		dtoEmployee employee;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getUserProfile());
			prepareStatement.setString(1,email);
			result = prepareStatement.executeQuery();
			result.next();
			employee = new dtoEmployee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static LinkedList<dtoEmployee> getFriendsProfile(String email) throws Exception{
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		ResultSet result;
		LinkedList<dtoEmployee> listOfEmployee;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getCompany());
			prepareStatement.setString(1,email);
			result = prepareStatement.executeQuery();
			result.next();
			String company = result.getString(1);
			listOfEmployee = new LinkedList<dtoEmployee>();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getFriendProfile());
			prepareStatement.setString(1,company);
			prepareStatement.setString(2,email);
			result = prepareStatement.executeQuery();
			while(result.next()) {
				dtoEmployee emp = new dtoEmployee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
				listOfEmployee.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				checkConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfEmployee;
	}
	/**
	 * 
	 * @param email
	 * @param dtoemployee
	 * @return
	 * @throws Exception
	 */
	public boolean updateEmployee(String email, dtoEmployee dtoemployee) throws Exception {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getEmployeeUpdationQuery());
			prepareStatement.setString(1,dtoemployee.getFullName());
			prepareStatement.setString(2,dtoemployee.getGender());
			prepareStatement.setString(3,dtoemployee.getContactNumber());
			prepareStatement.setString(4,dtoemployee.getOrganization());
			prepareStatement.setString(5,email);
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
	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static String getPhotoUrl(String email) throws Exception {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		String url;
		ResultSet result;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getUrlQuery());
			prepareStatement.setString(1,email);
			result=prepareStatement.executeQuery();
			result.next();
			url = result.getString(1);
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
		return url;
	}
	/**
	 * 
	 * @param url
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static boolean updatePhotoUrl(String url, String email) throws Exception {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getPhotoUpdationQuery());
			prepareStatement.setString(1,url);
			prepareStatement.setString(2,email);
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
	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static String getName(String email) throws Exception {
		Connection checkConnection = null;
		PreparedStatement prepareStatement = null;
		String name;
		ResultSet result;
		try {
			ConnectionClass connection = new ConnectionClass();
			checkConnection = connection.getConnection();
			prepareStatement = checkConnection.prepareStatement(DatabaseQuery.getNameQuery());
			prepareStatement.setString(1,email);
			result=prepareStatement.executeQuery();
			result.next();
			name = result.getString(1);
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
		return name;
	}
}
