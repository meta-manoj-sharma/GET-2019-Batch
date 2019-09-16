package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	public static Connection connect;
	/** 
	 * @return object of Connection class
	 * @throws Exception when driver class not found or can't create connection
	 */
	public Connection getConnection() throws Exception {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "1234");
			System.out.println("Remote DB connection established");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
		} catch (NullPointerException e) 
		{
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
		} catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("Remote db connection establishment error");
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("False query");
		}
		return connect;
	}
}
