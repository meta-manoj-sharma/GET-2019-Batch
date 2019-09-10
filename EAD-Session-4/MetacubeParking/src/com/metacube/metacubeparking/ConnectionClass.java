package com.metacube.metacubeparking;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


/**
 * conection class for establishing connection with database.
 * @author Manoj sharma
 * Dated 10 sept 2019
 */
public class ConnectionClass {
	
	public static Connection connect;

	// method to established connection with mySql database
	public static void connectionQuery() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "1234");
			System.out.println("Remote DB connection established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Remote db connection establishment error");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("False query");
		}
	}
}