package com.metacube.parking.dao;

public class DatabaseQuery {
	/**
	 * @return String type Query
	 */
	public static String getInsertionQuery(){
		String query="INSERT INTO Employee("
				+ "Name , Gender , Email , Password , Number , Company , ProfilePhtotoUrl)"
				+ "VALUES(?,?,?,?,?,?,?);";
				
		return query;
	}	
	/**
	 * @return String type Query
	 */
	public static String getVehicleInsertionQuery(){
		String query="INSERT INTO Vehicle("
				+ "Email , Name , Type , Number , EmployeeId , Details)"
				+ "VALUES(?,?,?,?,?,?);";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getVehicleID(){
		String query="SELECT VehicleId FROM vehicle WHERE Email = ? ;";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getPlanInsertionQuery(){
		String query="INSERT INTO plandetails("
				+ "VehicleId , Email , Currency , Price )"
				+ "VALUES(?,?,?,?);";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getPassword(){
		String query="SELECT Password FROM employee WHERE Email = ? ;";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getUserProfile() {
		String query="SELECT Name , Gender , Email , Number , Company FROM employee WHERE Email = ? ;";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getFriendProfile() {
		String query="SELECT Name , Gender , Email , Number , Company FROM employee WHERE Company = ? and Email != ? ;";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getCompany() {
		String query="SELECT Company FROM employee WHERE Email = ? ;";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getEmployeeUpdationQuery() {
		String query="UPDATE Employee SET Name = ? , Gender = ? , Number = ? , Company = ? WHERE email = ? ;";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getUrlQuery() {
		String query="SELECT ProfilePhtotoUrl FROM Employee WHERE email = ? ;";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getPhotoUpdationQuery() {
		String query="UPDATE Employee SET ProfilePhtotoUrl = ? WHERE email = ? ;";
		return query;
	}
	/**
	 * @return String type Query
	 */
	public static String getNameQuery() {
		String query="SELECT Name FROM Employee WHERE email = ? ;";
		return query;
	}
}