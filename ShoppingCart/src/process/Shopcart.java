/**
 * this is shopping cart program. in which a user can buy a product.
 * add it into cart
 * display cart items, their quantity and their price.
 */
package process; //this is to generate a package in which the shopcart class is created.

import java.util.*; //this is to import java predefind packages.
import items.*;
import items.Process; //this is used to import items package class. 

public class Shopcart {

	public static void main(String[] args) {
try{
		// to get input from the user.
		Scanner input = new Scanner(System.in);
        Process process = new Process();
		// this the array list initialization and put products into it
		ArrayList<Item> item = new ArrayList<Item>();
		Item i1 = new Item("Tea", 20);
		item.add(i1);
		Item i2 = new Item("Coffee", 40);
		item.add(i2);
		Item i3 = new Item("Sprite", 90);
		item.add(i3);
		Item i4 = new Item("mouse", 200);
		item.add(i4);
		ArrayList<Cart> cartItems = new ArrayList<Cart>();             // initialization of ArrayList.
		Cart cartItem;
		int flag = 1;                                                 // this variable control the flow of do-while loop.
		do {
			System.out.println("Press 1 for Add Items To Cart");
			System.out.println("Press 2 for show cart item");
			System.out.println("Press 3 for Update Cart Item");
			System.out.println("Press 4 for delete Cart Item");
			System.out.println("Press 5 for generating Bill");
			System.out.println("Press 6 for exit");
			int choice = 0;
				choice = input.nextInt();                             // the choice variable store the user

			switch (choice) {
			case 1:
				process.showProducts(item);                           // this is used to display product list which are available to buy.
				System.out.println("\nEnter Product No. To ADD to Cart");
				int productNumber = 0;
					productNumber = input.nextInt(); 
					
                if (productNumber > 0 && productNumber <= item.size()) {
					String cartProductName = item.get(productNumber - 1)
							.getItemName();
					double cartProductPrice = item.get(productNumber - 1)
							.getPrice();
					System.out.println("Enter Item Quantity :");
					int productQuantity = input.nextInt();
					if (productQuantity < 0) {                         // To get only positive value of quantity
						System.out.println("Wrong Quantity value :");
						break;
					}

					cartItem = new Cart(cartProductName, cartProductPrice,
							productQuantity);
					cartItems.add(cartItem);
					break;
				} 
                else {
					System.out.println("enter valid item");
					break;
				}
			case 2:
				process.showcartItems(cartItems);
				break;
			case 3:
				if (process.isCartEmpty(cartItems)) {         
					System.out.println("Card Is Empty !!");
					break;
				}
				process.showcartItems(cartItems);
				System.out.println("\nEnter Product No. To Update Quantity");
				int productId = input.nextInt();
				System.out.println("\n Enter New Quantity :");
				int productUpdatedQuantity = input.nextInt();
				if (productUpdatedQuantity == 0)
					cartItems.remove(productId - 1);
				else
					cartItems.get(productId - 1).setItemQuantity(productUpdatedQuantity);          // to trace item and set the quantity
					System.out.println("Updated Successful !!!");
				break;
			case 4:
				if (process.isCartEmpty(cartItems)) {         
					System.out.println("Card Is Empty !!");
					break;
				}
				process.showcartItems(cartItems);
				System.out.println("\nEnter Product No.to delete ");
				int deleteProductId = input.nextInt();
				cartItems.remove(deleteProductId - 1);                     // to remove item from the cart
				System.out.println("Deleted Successful !!!");
				break;
			case 5:
				process.printBill(cartItems);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter A Valid Choice");
			}
			    System.out.println("Press any number to Continue..");
            flag = input.nextInt();  
			flag = 1;
		} while (flag == 1);
	}
		catch (Exception e) {
			System.out.println("Invalid Entry!!..Program Exit");
            System.exit(0);
		}
	}
}
