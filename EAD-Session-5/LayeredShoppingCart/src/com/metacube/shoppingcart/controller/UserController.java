package com.metacube.shoppingcart.controller;

import java.sql.SQLException;
import java.util.List;

import com.metacube.shoppingcart.dao.UserDao;
import com.metacube.shoppingcart.model.User;
	/**
	 * class of user controller to maintain functioning of user details
	 * @author Manoj Sharma
	 * Dated 6 sept 2019
	 */
public class UserController {
	UserDao userDaoObject = new UserDao();
	/** 
	 * @param user name to be add in user list
	 * @throws SQLException
	 * @throws Exception
	 */
	public void addUser(String user) throws SQLException, Exception {
		userDaoObject.addUser(user);
	}
	/**
	 * @param userID to get user data
	 * @return user data 
	 * @throws SQLException
	 * @throws Exception
	 */
	public String getUserByID(int userID) throws SQLException, Exception {
		return userDaoObject.getUserByID(userID);
	}
	/**
	 * @return list of all users available
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<User> getUserList() throws SQLException, Exception {
		return userDaoObject.getUserList();
	}
}