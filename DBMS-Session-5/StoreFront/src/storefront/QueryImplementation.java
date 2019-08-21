package storefront;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class QueryImplementation {
	
	
	/**
	 * Constructor which helps the program to connect with the database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	QueryImplementation() throws ClassNotFoundException, SQLException{
	
		ConnectionClass.connectionQuery();
	}
	
	/**
	 * Assignment 1:
	 * This method executes the query one and stores the result in the list of orders type
	 * @param userId is the user id of the user
	 * @return  list of order details
	 * @throws SQLException
	 */
	List<Orders> getOrderDetails(String userId) throws SQLException {
		if (userId == null) {
			System.out.println("No user");
			return null;
		}
		List<Orders> orderDetailList = new ArrayList<>();
		try {
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(QueryClass.getQueryFirst(userId));
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				orderDetailList.add(new Orders(resultSet.getInt(1), resultSet.getDate(2), resultSet.getDouble(3)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return orderDetailList;
	}

	/**
	 * Assignment 2:
	 * This method inserts the images of the given product
	 * @param productIds is the product ids
	 * @param imageURLs is the urls of the image
	 * @return length of the resultant table
	 * @throws SQLException
	 */
	int insertImagesOfProduct(int[] productIds, String[] imageURLs) throws SQLException {
		if (productIds == null || imageURLs == null) {
			System.out.println("Id or Images Can't be Null");
			return -1;
		}
		try {
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(QueryClass.getQuerySecond());
			for (int i = 0; i < productIds.length; i++) {
				statement.setInt(1, productIds[i]);
				statement.setString(2, imageURLs[i]);
				statement.addBatch();
			}
			int[] result = statement.executeBatch();
			return result.length;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			ConnectionClass.connect.rollback();
		}
		return -1;
	}
	
	/**
	 * Assignment 3:
	 * This method executes the query which deletes the products that are not Ordered in Last One Year
	 * @return Number of products deleted
	 * @throws SQLException
	 */
	int deleteProductsNotOrdered() throws SQLException {
		int deletedProducts = 0;
		try {
			checkForeignKeyConstraints();
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(QueryClass.getQueryThird());
			deletedProducts = statement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ConnectionClass.connect.rollback();
		}
		return deletedProducts;
	}

	/**
	 * Assignment 4:
	 * This method returns List of Top categories along with their No Of Child Categories
	 * @return list of categories
	 */
	List<CategoryDetail> getCategoryDetail() {
		List<CategoryDetail> categoryDetailList = new ArrayList<CategoryDetail>();

		try {
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(QueryClass.getQueryFourth());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				categoryDetailList.add(new CategoryDetail(resultSet.getString(1), resultSet.getInt(2)));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return categoryDetailList;
	}
	
	/**
	 * This methods prints a table
	 * @param table is the table name
	 */
	void printTable(String table) {
		try {
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(QueryClass.getSelectQuery(table));
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * This method executes the query of foreign key check
	 */
	void checkForeignKeyConstraints() {
		try {
			PreparedStatement statement = (PreparedStatement) ConnectionClass.connect.prepareStatement(QueryClass.correctForeignConstraint());
			statement.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
