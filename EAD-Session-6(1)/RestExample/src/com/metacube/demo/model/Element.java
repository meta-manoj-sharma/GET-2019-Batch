package com.metacube.demo.model;

/**
 * @author Manoj Sharma
 * @since Sept 4, 2019 
 * This is Model Class Of Inventory Elements
 */
public class Element {
	String name;
	int quantity;

	// this constructor is used for generate object of element for result
	public Element() {
	}

	public Element(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
