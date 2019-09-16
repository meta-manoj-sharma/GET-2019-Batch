package com.metacube.parking.model;


public class Plan {
	
	private String currency;
	
	private String price;
	/**
	 * 
	 * @param currency
	 * @param price
	 */
	public Plan( String currency , String price) {
		this.price = price;
		this.currency = currency;
	}
	public Plan() {}
	
	
	/**
	 * 
	 * @return currency of String Type
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 
	 * @param currency of String Type
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * 
	 * @return price of String Type
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price of String Type
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Plan [currency=" + currency + ", price=" + price + "]";
	}	
}
