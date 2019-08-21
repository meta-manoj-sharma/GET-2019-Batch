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
		orders = queryObject.getOrderDetails("s004");
		assertEquals("o001", orders.get(0).getOrderId());
		assertEquals("o004", orders.get(1).getOrderId());
	}
}