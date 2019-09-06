package com.metacube.shoppingcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.ConnectionClass;
import com.metacube.shoppingcart.model.User;

public class UserDao {
	private Query query;

	public UserDao() {
		query = new Query();
	}
	/**
	 * @param userName to be add in database
	 * @throws SQLException
	 * @throws Exception
	 */
	public void addUser(String userName) throws SQLException, Exception {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = ConnectionClass.getConnection();
			statement = connect.prepareStatement(query.getAddUserQuery());
			statement.setString(1, userName);
			statement.executeUpdate();
			} catch (SQLException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			} finally {
				statement.close();
				connect.close();
			}
	}
	/** 
	 * @param userId at which user to be get
	 * @return user details
	 * @throws SQLException
	 * @throws Exception
	 */
	public String getUserByID(int userId) throws SQLException, Exception {
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connect = ConnectionClass.getConnection();
			statement = connect.prepareStatement(query.getUserId());
			statement.setInt(1, userId);
			result = statement.executeQuery();
			result.next();
			return result.getString(1);
			} catch (SQLException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			} finally {
				statement.close();
				connect.close();
			}
	}
	/**
	 * @return list of all users 
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<User> getUserList() throws SQLException, Exception {
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		User userObject;
		ArrayList<User> listUser = new ArrayList<User>();
		try {
			connect = ConnectionClass.getConnection();
			statement = connect.prepareStatement(query.getUserList());
			result = statement.executeQuery();
			while (result.next()) {
				userObject = new User();
				userObject.setUserID(result.getString(1));
				userObject.setUserName(result.getString(2));
				listUser.add(userObject);
			}
			return listUser;
			} catch (SQLException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			} finally {
			statement.close();
			connect.close();
		}
	}
}