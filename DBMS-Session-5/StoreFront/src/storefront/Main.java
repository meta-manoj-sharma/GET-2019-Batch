package storefront;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner inputScanner = new Scanner(System.in);
		QueryImplementation queryObject = new QueryImplementation();

		System.out.print("Enter the user id of the user whose order is to be determined : ");
		String userId = inputScanner.next();
		List<Orders> orders = new ArrayList<>();
		orders = queryObject.getOrderDetails(userId);
		for (int i = 0, j = 0; i < orders.size(); i++) {
			System.out.print("\tOrder id : " + orders.get(i).getOrderId());
			System.out.print("\tOrder date : " + orders.get(i).getOrderDate());
			System.out.print("\tOrder amount : " + orders.get(i).getOrderAmount());
			System.out.println();
		}

		System.out.println("Enter 5 images of 2 products : ");
		int[] productIds = new int[10];
		String[] imageURLS = new String[10];
		System.out.println("Enter the image URLS for product \"MI note 8\" : ");
		for (int i = 0; i < 5; i++) {
			productIds[i] = 1;
			imageURLS[i] = inputScanner.next();
		}
		System.out.println("\nEnter the image URLS for product \"Acer mouse\" : ");
		for (int i = 5; i < 10; i++) {
			productIds[i] = 2;
			imageURLS[i] = inputScanner.next();
		}
		if (queryObject.insertImagesOfProduct(productIds, imageURLS) > 0)
			System.out.println("Images inserted");
		else
			System.out.println("There was a error while inserting the images");

		System.out.println("\nThe images table is : ");
		queryObject.printTable("images");

		queryObject.deleteProductsNotOrdered();
		System.out.println("\nThe products table afer operation is : ");
		queryObject.printTable("products");

		List<CategoryDetail> categoryList = new ArrayList<>();
		categoryList = queryObject.getCategoryDetail();
		System.out.println("\nThe categories are : ");
		for (int i = 0; i < categoryList.size(); i++) {
			System.out.println("Category Name : " + categoryList.get(i).getCategoryName());
			System.out.print("  Number of Childs : " + categoryList.get(i).getNoOfChilds());
			System.out.println();
		}
		inputScanner.close();
	}
}