package com.metacube.demo.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author Manoj Sharma
 * @since Sept 4, 2019 
 * This is Model Class Of Inventory Elements
 */
//@XmlRootElement
public class Element {
	String name;
	int quantity;
	
	public Element() {
		super();
	}
	public Element(String name, int quantity) {
		super();
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
