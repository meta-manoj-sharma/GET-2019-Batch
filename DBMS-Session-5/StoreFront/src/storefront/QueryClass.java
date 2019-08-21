package storefront;

/**
 * DBMS assignment based on JDBC
 * @author Manoj Sharma 
 * Dated 16 August 2019
 */
public class QueryClass {

	/**
	 * Assignment 1 query
	 * @param userID is the user id
	 */
	public static String getQueryFirst(String userId) {
		return " select orders.orderid,orders.date, sum(cart.amount * cart.quantity) as amount "
				+ " from orders inner join cart on " + " orders.orderid = cart.orderid "
				+ " where cart.itemshippingStatus = 'shipped' and orders.userid='" + userId
				+ "' group by orders.orderid order by orders.date asc;";
	}

	/**
	 * Assignment 2 query
	 */
	public static String getQuerySecond() {
		QueryImplementation.checkForeignKeyConstraints();
		return "INSERT INTO images(productId, imageUrl, imageId) VALUES(?,?,?);";
	}

	/**
	 * Assignment 3 query
	 */
	public static String getQueryThird() {
		return "delete from products" + " where products.productname in (select * from("
				+ " select products.productname" + " from products"
				+ " where products.productname not in("
				+ " select products.productname" + " from products"
				+ " inner join cart on" + " cart.productid = products.productid"
				+ " left join orders on" + " orders.orderid = cart.orderid"
				+ " where datediff(current_date(),orders.date)>20)) as t);";
	}

	/**
	 * Assignment 4 query
	 */
	public static String getQueryFourth() {
		return "select parentcategorytitle , count(categoryname) as count" + " from category"
				+ " where parentcategorytitle in(" + " select categoryname " + " from category"
				+ " where parentcategorytitle = 'Topcategory')" + " group by parentcategorytitle;";
	}

	/**
	 * This method makes the query to display a table
	 * @param tablei s the table name
	 * @return The SQL query
	 */
	public static String getSelectQuery(String table) {
		return "SELECT * FROM " + table + ";";
	}

	/**
	 * This method makes the query which checks the foreign key constraints 
	 * @return the query
	 */
	public static String correctForeignConstraint() {
		return "SET FOREIGN_KEY_CHECKS = 0";
	}
}