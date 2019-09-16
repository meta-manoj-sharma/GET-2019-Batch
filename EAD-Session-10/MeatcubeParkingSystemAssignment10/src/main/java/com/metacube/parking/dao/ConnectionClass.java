package com.metacube.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

	/** 
	 * @return object of Connection class
	 * @throws Exception
	 *             when driver class not found or can't create connection
	 */
	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		  String userName = "root";
		  String password = "1234";
		  String url = "jdbc:mysql://localhost:3306/employee";
		try {
			Connection conn = null;
			Class.forName( driver);
			conn = DriverManager.getConnection( url, userName, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
