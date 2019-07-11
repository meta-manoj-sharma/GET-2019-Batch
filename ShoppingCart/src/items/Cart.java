package items;

public class Cart {
	private String name;
	private double price;
	private int quantity;

	/**
	 * 
	 * @param name
	 *            is string type which is product name .
	 * @param price
	 *            is string type which is product price
	 * @param quantity
	 *            is string type which is product quantity it will assign values
	 *            to respective variables.
	 */
	public Cart(String name, double price, int quantity) {

		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Cart() {
	}

	public String getItemName() {
		return name;
	}

	public void setItemName(String itemName) {
		this.name = itemName;
	}

	public double getItemPrice() {
		return price;
	}

	public void setItemPrice(double itemPrice) {
		this.price = itemPrice;
	}

	public int getItemQuantity() {
		return quantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.quantity = itemQuantity;
	}
}
