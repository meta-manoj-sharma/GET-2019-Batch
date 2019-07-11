package items;

import java.util.ArrayList;

public class Process {
	/**
	 * 
	 * @param item
	 *            which is a array list of Item type it will display the
	 *            products list which are available to buy and their price.
	 */
	public void showProducts(ArrayList<Item> item) {

		System.out.println("Items(Price)");
		for (int i = 0; i < item.size(); i++) {
			String currentItemName = item.get(i).getItemName();
			double currentItemPrice = item.get(i).getPrice();
			if (i % 3 == 0)
				System.out.println();
			System.out.print(i + 1 + ". " + currentItemName + "("
					+ currentItemPrice + " INR)\t");
		}
	}

	/**
	 * 
	 * @param CartItems
	 *            which is a arraylist of cart type. 
	 *            it display the item in the
	 *            cart,their price and quantity .
	 */
	public void showCartItems(ArrayList<Cart> CartItems) {

		if (CartItems == null) {
			System.out.println("Add Items To Cart !!");
			return;
		}
		if (CartItems.size() == 0) {
			System.out.println("Add Items To Cart !!");
			return;
		}
		System.out.println("Items In Cart Are:");
		System.out.println("SN\tItem\tPrice\tQuantity\tAmount");
		for (int i = 0; i < CartItems.size(); i++) {
			String currentItemName = CartItems.get(i).getItemName();
			double currentItemPrice = CartItems.get(i).getItemPrice();
			int currentItemQuantity = CartItems.get(i).getItemQuantity();
			double currentItemAmount = currentItemPrice * currentItemQuantity;
			System.out.println(i + 1 + "\t" + currentItemName + "\t"
					+ currentItemPrice + "\t" + currentItemQuantity + "\t"
					+ currentItemAmount);
		}
	}

	/**
	 * 
	 * @param CartItems
	 *            which is a arraylist of cart type. it will display the total
	 *            amount of items in their list.
	 */
	public void printBill(ArrayList<Cart> CartItems) {

		if (CartItems == null) {
			System.out.println("Add Items To Cart !!");
			return;
		}
		if (CartItems.size() == 0) {
			System.out.println("Add Items To Cart !!");
			return;
		}
		System.out.println("SN\tItem\tPrice\tQuantity\tAmount");
		System.out.println("----------------------------------");
		int totalAmount = 0;
		for (int i = 0; i < CartItems.size(); i++) {
			String currentItemName = CartItems.get(i).getItemName();
			double currentItemPrice = CartItems.get(i).getItemPrice();
			int currentItemQuantity = CartItems.get(i).getItemQuantity();
			double currentItemAmount = currentItemPrice * currentItemQuantity;
			totalAmount += currentItemAmount;
			System.out.println(i + 1 + "\t" + currentItemName + "\t"
					+ currentItemPrice + "\t" + currentItemQuantity + "\t"
					+ currentItemAmount);
		}
		System.out.println("----------------------------------");
		System.out.println("\t\t\tTotal Amount\t" + totalAmount);
	}
}