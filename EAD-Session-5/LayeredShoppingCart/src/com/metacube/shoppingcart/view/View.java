package com.metacube.shoppingcart.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingcart.controller.CartController;
import com.metacube.shoppingcart.controller.ProductController;
import com.metacube.shoppingcart.controller.UserController;
import com.metacube.shoppingcart.dao.CartDao;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

public class View {

	// show the general menu options
	public static void showMenu() {
		System.out.println("Choose the option below");
		System.out.println("1. Add User");
		System.out.println("2. Show All Users");
		System.out.println("3. Choose user");
		System.out.println("Press any other key to exit");
	}

	// shows the cart menu options
	public static void showCartMenu() {
		System.out.println("Choose the below cart option");
		System.out.println("1. Add Product to cart");
		System.out.println("2. Update product to cart");
		System.out.println("3. Show Cart");
		System.out.println("4. Exit");
	}

	public static void main(String args[]) throws SQLException, Exception {
		View.showMenu();
		UserController userController = new UserController();
		ProductController productController = new ProductController();
		CartController cartController = new CartController();
		Scanner input = new Scanner(System.in);
		int menuChoice, cartChoice;
		menuChoice = input.nextInt();
		try {
			while (menuChoice > 0 && menuChoice < 4) {
				switch (menuChoice) {
				case 1:
					System.out.println("Enter the name of the user");
					String newname = input.next();
					userController.addUser(newname);
					System.out.println("Added");
					break;
					
				case 2:
					List<User> userList = userController.getUserList();
					System.out.println("UserId\tUserName");
					for (int i = 0; i < userList.size(); i++) {
						System.out.println(userList.get(i).getUserID() + " \t " + userList.get(i).getUserName());
					}
					break;
					
				case 3:
					System.out.println("Enter the id of the user");
					int userID = input.nextInt();
					String user = userController.getUserByID(userID);
					System.out.println(" user  --> " + user);
					if (user != null) {
						View.showCartMenu();
						cartChoice = input.nextInt();
						while (cartChoice > 0 && cartChoice < 5) {
							switch (cartChoice) {
							// add product to cart
							case 1:
								List<Product> store = productController.getStoreProduct();
								System.out.println("ProductCode\tProductName\tProductType\tPrice");
								for (int i = 0; i < store.size(); i++) {
									System.out.println(store.get(i).getProductCode() + " \t " + store.get(i).getProductName()
											+ " \t " + store.get(i).getProductType() + " \t " + store.get(i).getPrice());
								}
								
								System.out.println("Enter the id of the product...");
								String productID = input.next();
								System.out.println("Enter the quantity of the product...");
								int productQuantity = input.nextInt();
								if (productQuantity > 0) {
									cartController.addProductToCart(userID, productID, productQuantity);
									System.out.println("Added the products");
								} else {
									System.out.println("Quantity should be greater than 0");
								}
								break;

							case 2:
								List<Cart> cartList = cartController.getCartList(userID);
								System.out.println("ProductCode\tUserId\tQuantity");
								for (int i = 0; i < cartList.size(); i++) {
									System.out.println(cartList.get(i).getProductCode()+ "\t"
											+ cartList.get(i).getUserID()+ "\t"+ cartList.get(i).getQuantity());
								}

								System.out.println("Enter the id of the product to update...");
								String productID1 = input.next();
								System.out.println("Enter the Quantity of the product...");
								int productQTY = input.nextInt();
								if (productQTY > 0) {
									cartController.updateCartItem(userID, productID1, productQTY);
								} else {
									System.out.println("Quantity should be greater than 0");
								}
								break;

							// show the user cart
							case 3:
								List<Cart> cartList1 = cartController.getCartList(userID);
								Product productById;
								CartDao cartObject = new CartDao();
								double totalPrice = 0;
								for (int i = 0; i < cartList1.size(); i++) {
									productController = new ProductController();
									String cartProduct = cartList1.get(i).getProductCode();
									productById = productController.getProductById(cartProduct);
									totalPrice += cartObject.executeGetProductQuantity(userID,cartProduct) * productById.getPrice();
									System.out.println(productById.getProductCode() + " \t "+ productById.getProductName()
													+ " \t " + cartObject.executeGetProductQuantity(userID,cartProduct)
													+ " \t " + +productById.getPrice() * cartObject.executeGetProductQuantity(userID,cartProduct));
								}
								System.out.println("The total to be paid  Rs --> "+ totalPrice);
								break;
								
							case 4:
								break;
								
							default:
								System.out.println("Invalid Choice!!");
							}

							if (cartChoice == 4) {
								break;
							}
							View.showCartMenu();
							cartChoice = input.nextInt();
						}
					} else {
						System.out.println("User doesn't exist");
					}
					break;
				default:
					System.out.println("Invalid choice!!!");
				}
				System.out.println();
				View.showMenu();
				menuChoice = input.nextInt();
			}

		} catch (Exception e) {
			System.out.println("Error is " + e.getMessage());
			main(args);
		}

	}
}