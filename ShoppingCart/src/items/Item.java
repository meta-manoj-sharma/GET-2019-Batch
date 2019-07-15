package items;

public class Item {
	private String ItemName;
	private double Price;

	/**
	 * 
	 * @param name is string type which is product name .
	 * @param price is string type which is product price. 
	 * it will assign value to respective variables.
	 */

	public Item(String ItemName, double Price) {
		this.ItemName = ItemName;
		this.Price = Price;
	}

	public Item() {

	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		this.ItemName = ItemName;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		this.Price = Price;
	}

}