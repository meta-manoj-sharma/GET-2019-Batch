package storefront;

import java.util.Date;

public class Orders {
	
	private String orderId;
	private Date orderDate;
	private double orderAmount;
	
	/**
	 * Constructor to initialize the data members
	 * @param order id is the order id
	 * @param order date is the order date
	 * @param order amount is the order amount
	 */
	Orders(String string, Date orderDate, double orderAmount)
	{
		this.orderId = string;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}

	//Getter methods
	public String getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}
}