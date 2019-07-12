package items;
import java.util.ArrayList;
public class Process {
	/**
	 *  @param item which is a array list of Item type 
	 *  it will display the products list which are available to buy and their price.
	 */
	
	public void showProducts(ArrayList<Item> item) {

		System.out.println("Items(Price)");
		for (int i = 0; i < item.size(); i++) {
			String currentItemName = item.get(i).getItemName();
			double currentItemPrice = item.get(i).getPrice();
			if (i % 3 == 0)                                            // for displaying items available for buy in set of three in order to make table
				System.out.println();
			System.out.print(i + 1 + ". " + currentItemName + "("
					+ currentItemPrice + " INR)\t");
		}
	}
	/**
	 * 
	 * @param cartItems array list which contains items in cart
	 * @param i value for present item
	 * @return present item amount in list
	 */
     public double display(ArrayList<Cart> cartItems , int i){
		
		String currentItemName = cartItems.get(i).getItemName();                        // To get item name to display using index i;                       // To get item name to display using index i                        // To get item name to display using index i
		double currentItemPrice = cartItems.get(i).getItemPrice();                      // To get item price to display using index i
		int currentItemQuantity = cartItems.get(i).getItemQuantity();                   // To get item quantity to display using index i
		double currentItemAmount = currentItemPrice * currentItemQuantity;              // to generate the total amount of items
		System.out.println(i + 1 + "\t" + currentItemName + "\t"
				+ currentItemPrice + "\t" + " " + currentItemQuantity
				+ "\t" + "         " + currentItemAmount);
		
		return currentItemAmount;
	}

	/**
	 * @param cartItems
	 * which is a arraylist of cart type. 
	 * it display the item in the cart,their price and quantity .
	 */
	public void showcartItems(ArrayList<Cart> cartItems) {

		if (cartItems == null) {
			System.out.println("Add Items To Cart !!");
			return;
		}
		if (cartItems.size() == 0) {
			System.out.println("Add Items To Cart !!");
			return;
		}
		System.out.println("Items In Cart Are:");
		System.out.println("SN\tItem\tPrice\tQuantity\tAmount");
		for (int i = 0; i < cartItems.size(); i++) {
		double	amount = display(cartItems,i);                           //call to display items list and to get current amount
		}
	}

	/**
	 * @param cartItems
	 * which is a arraylist of cart type. 
	 * it will display the total amount of items in their list.
	 */
	public void printBill(ArrayList<Cart> cartItems) {

		
		if (cartItems == null) {
			System.out.println("Add Items To Cart !!");
			return;
		}
		if (cartItems.size() == 0) {
			System.out.println("Add Items To Cart !!");
			return;
		}
		System.out.println("SN\tItem\tPrice\tQuantity\tAmount");
		System.out.println("----------------------------------");
		int totalAmount = 0;
		for (int i = 0; i < cartItems.size(); i++) {
			totalAmount += display(cartItems,i);                                 //call to display items list and to get total amount
		}
		System.out.println("----------------------------------");
		System.out.println("\t\t\tTotal Amount\t" + " " + totalAmount);
	}
	public boolean isCartEmpty(ArrayList<Cart> cartItems ){
		if (cartItems == null || cartItems.size() == 0) {                        // To check wheather the cart is empty or not
			return true;
		}
		else return false;
	}
}