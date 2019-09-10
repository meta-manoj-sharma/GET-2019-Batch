package com.metacube.shoppingcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metacube.shoppingcart.ConnectionClass;
import com.metacube.shoppingcart.model.Product;

public class ProductDao {

	private Query query;

	/**
	 * @return list of all products
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<Product> executeGetAllProducts() throws Exception {
		query = new Query();
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Product productObject;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			connect = ConnectionClass.getConnection();
			statement = connect.prepareStatement(query.getAllProducts());
			result = statement.executeQuery();
			while (result.next()) {
				productObject = new Product();
				productObject.setProductCode(result.getString(1));
				productObject.setProductName(result.getString(2));
				productObject.setProductType(result.getString(3));
				productObject.setPrice(result.getInt(4));
				list.add(productObject);
			}
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			connect.close();
			statement.close();
			result.close();
		}
	}
	/**
	 * @param productCode of which details to be get
	 * @return product details
	 * @throws SQLException
	 * @throws Exception
	 */
	public Product executeGetProductDetails(String productCode) throws Exception {
		query = new Query();
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			Product cartProduct = new Product();
			connect = ConnectionClass.getConnection();
			statement = connect.prepareStatement(query.getProductDetails());
			statement.setString(1, productCode);
			result = statement.executeQuery();
			while (result.next()) {
				cartProduct.setProductCode(result.getString(1));
				cartProduct.setProductName(result.getString(2));
				cartProduct.setProductType(result.getString(3));
				cartProduct.setPrice(result.getDouble(4));
			}
			return cartProduct;
		} catch (Exception e) {
			throw e;
		} finally {
			connect.close();
			statement.close();
			result.close();
		}
	}
}