package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.ConnectionClass;
import com.metacube.shoppingcart.model.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
	/**
	 * cart database class to handle database related operations
	 * @author Manoj Sharma
	 * Dated 6 sept 2019
	 */
public class CartDao {
	private Query query;
	// constructor to get query object
	public CartDao() {
		query = new Query();
	}
	/**
	 * @param userId at which product to be added
	 * @param productCode to be added
	 * @param quantity of product to be added
	 * @return status of operation
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean executeAddProductToCartQuery(int userId, String productCode, int quantity) throws SQLException, Exception {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = ConnectionClass.getConnection();
			statement = connect.prepareStatement(query
					.getAddProductToCartQuery());
			statement.setInt(1, userId);
			statement.setString(2, productCode);
			statement.setInt(3, quantity);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			connect.close();
			statement.close();
		}
	}
	/**
	 * @return list of cart items
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<Cart> executeViewCartQuery() throws SQLException, Exception {
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connect = ConnectionClass.getConnection();
			statement = connect.prepareStatement(query.getCart());
			result = statement.executeQuery();
			Cart cartObject;
			ArrayList<Cart> list = new ArrayList<Cart>();
			while (result.next()) {
				cartObject = new Cart();
				cartObject.setUserID(result.getString(1));
				cartObject.setProductCode(result.getString(2));
				cartObject.setQuantity(result.getInt(3));
				list.add(cartObject);
			}

			return list;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			connect.close();
			statement.close();
			result.close();
		}

	}
	/**
	 * @param userId at which quantity of product to be calculated
	 * @param productCode of product which quantity to be calculated
	 * @return quantity of product
	 * @throws SQLException
	 * @throws Exception
	 */
	public int executeGetProductQuantity(int userId, String productCode) throws SQLException, Exception {
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connect = ConnectionClass.getConnection();
			statement = connect.prepareStatement(query.getProductQuantity());
			statement.setString(1, productCode);
			statement.setInt(2, userId);
			result = statement.executeQuery();
			result.next();
			return result.getInt(1);
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			connect.close();
			statement.close();
			result.close();
		}
	}
	/**
	 * @param userId at which product to be update
	 * @param productCode to bee updated
	 * @param quantity updated quantity
	 * @return status of operation
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean executeUpdateQuantityQuery(int userId, String productCode, int quantity) throws SQLException, Exception {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = ConnectionClass.getConnection();
			statement = connect
					.prepareStatement(query.getUpdateQuantityQuery());
			statement.setInt(1, quantity);
			statement.setString(2, productCode);
			statement.setInt(3, userId);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			connect.close();
			statement.close();
		}
	}
}