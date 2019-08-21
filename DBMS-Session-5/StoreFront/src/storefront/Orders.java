package storefront;

import java.util.Date;

public class Orders {
	
	private int orderId;
	private Date orderDate;
	private double orderAmount;
	
	/**
	 * Constructor to initialize the data members
	 * @param order id is the order id
	 * @param order date is the order date
	 * @param order amount is the order amount
	 */
	Orders(int orderId, Date orderDate, double orderAmount)
	{
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}

	//Getter methods
	public int getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}
}