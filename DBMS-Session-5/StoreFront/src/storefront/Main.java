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

		System.out.println("Enter 5 images of products : ");
		String[] imageIds = new String[]{"i006","i007","i008","i009","i010"};
		String[] productIds = new String[]{"p006","p007","p008","p009","p010"};
		String[] imageURLS = new String[]{"c/:images/frog.png","c/:images/img1.png","c/:images/img2.png","c/:images/img3.png","c/:images/img4.png","c/:images/img5.png"};
		
		if (queryObject.insertImagesOfProduct(productIds, imageURLS,imageIds) > 0)
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