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

	// Test for inserting images
	@Test
	public void testInsertImagesOfProduct() throws SQLException, ClassNotFoundException {
		QueryImplementation queryObject = new QueryImplementation();
		String[] imageIds = new String[] { "i006", "i007", "i008", "i009","i010" };
		String[] productIds = new String[] { "p006", "p007", "p008", "p009","p010" };
		String[] imageURLS = { "a", "b", "c", "d", "e" };
		assertEquals(5, queryObject.insertImagesOfProduct(productIds,imageURLS, imageIds));
	}

	// Test for deleting products
	@Test
	public void testDeleteProductsNotOrdered() throws SQLException, ClassNotFoundException {
		QueryImplementation queryObject = new QueryImplementation();
		assertEquals(3, queryObject.deleteProductsNotOrdered());
	}

	@Test
	public void testDeleteProductsNotOrderedNegative() throws SQLException, ClassNotFoundException {
		QueryImplementation queryObject = new QueryImplementation();
		assertEquals(0, queryObject.deleteProductsNotOrdered());
	}

	// Test for category details
	@Test
	public void testGetCategoryDetail() throws SQLException, ClassNotFoundException {
		QueryImplementation queryObject = new QueryImplementation();
		List<CategoryDetail> categoryList = new ArrayList<>();
		categoryList = queryObject.getCategoryDetail();
		assertEquals(2, categoryList.get(0).getNoOfChilds());
		assertEquals(2, categoryList.get(1).getNoOfChilds());
	}
}