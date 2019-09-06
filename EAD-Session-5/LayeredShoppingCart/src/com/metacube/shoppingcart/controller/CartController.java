package com.metacube.shoppingcart.controller;

import java.sql.SQLException;
import java.util.List;

import com.metacube.shoppingcart.dao.CartDao;
import com.metacube.shoppingcart.model.Cart;
	/**
	 * class of cart controller to maintain functioning of user cart
	 * @author Manoj Sharma
	 * Dated 6 sept 2019
	 */
public class CartController {
	/**
	 * @param userID for user to add product in cart
	 * @param productID of product which is to be add in cart
	 * @param quantity of product to be added
	 * @throws SQLException
	 * @throws Exception
	 */
	public void addProductToCart(int userID, String productID, int quantity) throws SQLException, Exception {
		CartDao cart = new CartDao();
		cart.executeAddProductToCartQuery(userID, productID, quantity);
	}
	/**
	 * @param userID for user to update product in cart
	 * @param productID of product which is to update add in cart
	 * @param quantity of product to be updated
	 * @throws SQLException
	 * @throws Exception
	 */
	public void updateCartItem(int userID, String productID, int quantity) throws SQLException, Exception {
		CartDao cart = new CartDao();
		cart.executeUpdateQuantityQuery(userID, productID, quantity);

	}
	/**
	 * @param userID for user to get cart
	 * @return cart of user 
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<Cart> getCartList(int userID) throws SQLException, Exception {
		CartDao cart = new CartDao();
		return cart.executeViewCartQuery();
	}
}