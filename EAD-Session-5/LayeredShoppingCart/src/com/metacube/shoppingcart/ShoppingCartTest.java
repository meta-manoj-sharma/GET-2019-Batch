package com.metacube.shoppingcart;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import com.metacube.shoppingcart.controller.CartController;
import com.metacube.shoppingcart.controller.ProductController;
import com.metacube.shoppingcart.controller.UserController;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

public class ShoppingCartTest {
	
	/**
	 * test case to test product by product id 
	 * @throws SQLException
	 * @throws Exception
	 */
	@Test
	public void testGetProductById() throws SQLException, Exception {

		ProductController productController = new ProductController();
		assertEquals("AcerLaptop", productController.getProductById("P2").getProductName());
	}
	/**
	 * test case to test productlist 
	 * @throws SQLException
	 * @throws Exception
	 */
	@Test
	public void testGetProductList() throws SQLException, Exception {

		ProductController productController = new ProductController();
		List<Product> productList = productController.getStoreProduct();
		assertEquals("P1", productList.get(0).getProductCode());
	}	
}
