package com.metacube.shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
	/**
	 * class to established connection and layered architecture project
	 * @author Manoj Sharma
	 * dated 6 sept 2019
	 */
public class ConnectionClass {

	/**
	 * @return object of Connection class
	 * @throws Exception
	 * when driver class not found or can't create connection
	 */
	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "1234";
		String url = "jdbc:mysql://localhost:3306/shoppingcart";
		try {
			Connection connection = null;
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}
