package com.metacube.shoppingcart.controller;

import java.sql.SQLException;
import java.util.*;
import com.metacube.shoppingcart.dao.ProductDao;
import com.metacube.shoppingcart.model.Product;
	/**
	 * class of product controller to maintain functioning of products
	 * @author Manoj Sharma
	 * Dated 6 sept 2019
	 */
public class ProductController {

	private ProductDao product;
	// contstructor of product controller
	public ProductController() {
		product = new ProductDao();
	}
	/**
	 * @return all products available in database 
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<Product> getStoreProduct() throws SQLException, Exception {
		return product.executeGetAllProducts();
	}
	/**
	 * @param productID of product id 
	 * @return details of product of specific id
	 * @throws SQLException
	 * @throws Exception
	 */
	public Product getProductById(String productID) throws SQLException,Exception {
		return product.executeGetProductDetails(productID);
	}
}