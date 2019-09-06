package com.metacube.shoppingcart.dao;

public class Query {
	private String query;

	public Query() {
		this.query = "";
	}

	/**
	 * @return query
	 */
	public String getQuery() {
		return this.query;
	}

	/*
	 * ** CART QUERIES **
	 */
	public String getAddProductToCartQuery() {
		this.query = "INSERT INTO cart (userId,ProductCode , Quantity) Values (?,?,?);";
		return this.query;
	}

	public String getCart() {
		this.query = "SELECT userId, ProductCode , Quantity From Cart;";
		return this.query;
	}

	public String getProductQuantity() {
		this.query = "SELECT quantity FROM Cart WHERE Cart.ProductCode = ? and Cart.userId = ?;";
		return this.query;
	}

	public String getProductName() {
		this.query = "SELECT product.productName FROM product RIGHT JOIN Cart On Product.ProductCode = Cart.ProductCode WHERE Cart.ProductCode = ?;";
		return this.query;
	}

	public String getUpdateQuantityQuery() {
		this.query = "UPDATE cart SET cart.quantity = ? WHERE cart.productCode = ? and cart.userId = ? ;";
		return this.query;
	}

	/*
	 * ** PRODUCT QUERIES **
	 */
	public String getAllProducts() {
		this.query = "SELECT ProductCode , ProductName , Type , Price FROM Product ;";
		return this.query;
	}

	public String getProductDetails() {
		this.query = "SELECT ProductCode , ProductName , Type , Price FROM Product WHERE ProductCode = ?;";
		return this.query;
	}

	/*
	 * ** USER QUERIES **
	 */
	public String getAddUserQuery() {
		this.query = " Insert into User(UserName) values(?) ;";
		return this.query;
	}

	public String getUserId() {
		this.query = "SELECT UserName FROM User WHERE userId = ? ;";
		return this.query;
	}

	public String getUserList() {
		this.query = "SELECT UserId, UserName FROM User ;";
		return this.query;
	}
}
