package storefront;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QueryImplementationTest {

	// Test for order details
	@Test
	public void testGetOrderDetailsOfShippedOrders() throws SQLException, ClassNotFoundException {
		QueryImplementation queryObject = new QueryImplementation();
		List<Orders> orders = new ArrayList<>();
		orders = queryObject.getOrderDetails("s001");
		assertEquals(4, orders.get(0).getOrderId());
		assertEquals(1, orders.get(1).getOrderId());
	}

	// Test for deleting products
	@Test
	public void testDeleteProductsNotOrdered() throws SQLException, ClassNotFoundException {
		QueryImplementation queryObject = new QueryImplementation();
		assertEquals(8, queryObject.deleteProductsNotOrdered());
	}
}